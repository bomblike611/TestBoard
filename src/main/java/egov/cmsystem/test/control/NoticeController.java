package egov.cmsystem.test.control;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.NoticeReplyDTO;
import egov.cmsystem.test.service.impl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Resource(name="noticeService")
	private NoticeServiceImpl noticeService;
	
	@Resource(name="beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value = "/List.do")
	public ModelAndView noticeList(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=noticeService.selectList(vo);
		
		/*BoardDTO boardDTO=new BoardDTO();
		for(int i=0;i<62;i++){
			boardDTO.setBoardTitle("제목"+i);
			boardDTO.setBoardPw("s"+i);
			boardDTO.setBoardWriter("사용자");
			boardDTO.setBoardContents("내용"+i);
			boardDTO.setBoardRef(i);
			boardDTO.setAdminDelete("n");
			boardDTO.setFileOriginalName("");
			boardDTO.setFileSaveName("");
			noticeService.insertContents(boardDTO);
			System.out.println(i);
		}*/
		
		
		view.addObject("list", ar);
		view.addObject("page", vo);
		view.setViewName("notice/noticeList");
		return view;
	}
	@RequestMapping(value = "/Contents.do")
	public ModelAndView noticeContents(BoardDTO boardDTO) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO dto=noticeService.selectContents(boardDTO);
		List<?> ar=noticeService.selectReplyList(boardDTO);
		BoardDTO nextPre=noticeService.selectPrevNext(boardDTO);
		view.addObject("next", nextPre.getBoardRef());
		view.addObject("prev", nextPre.getBoardNum());
		view.addObject("contents", dto);
		view.addObject("replyList",ar);
		view.setViewName("notice/noticeContents");
		return view;
	}
	@RequestMapping(value = "/Write.do",method=RequestMethod.GET)
	public ModelAndView noticeWrite(@ModelAttribute("boardDTO") BoardDTO boardDTO,HttpSession session) throws Exception {
		ModelAndView view=new ModelAndView();
		String admin=(String) session.getAttribute("admin");
		if(admin==null){
			view.addObject("alert", "관리자만 접근 가능합니다.");
			view.addObject("url", "/List.do");
			view.setViewName("main/alert");
		}else{
			view.setViewName("notice/noticeForm");			
		}
		return view;
	}
	@RequestMapping(value = "/Write.do",method=RequestMethod.POST)
	public ModelAndView noticeWrite(@ModelAttribute("boardDTO") BoardDTO boardDTO,BindingResult bindingResult) throws Exception {
		boardDTO.setBoardPw("");
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		ModelAndView mv=new ModelAndView();
		
		beanValidator.validate(boardDTO, bindingResult);
		
		if(bindingResult.hasErrors()){
			mv.addObject("alert", "내용에 Html태그가 포함되었는지 또는 글자수를 확인해주세요.");
			mv.addObject("url", "/Write.do");
			mv.setViewName("main/alert");
			/*bindingResult.getAllErrors().forEach(obj -> {
			    System.out.println(obj.getCode() + " " + obj.getObjectName() + " " + obj.getDefaultMessage().toString());
			});*/
			return mv;
		}
		
		int result=noticeService.insertContents(boardDTO);
		
		mv.setViewName("redirect:/List.do");
		
		return mv;
	}
	@RequestMapping(value = "/Update.do",method=RequestMethod.GET)
	public ModelAndView noticeUpdate(BoardDTO boardDTO,HttpSession session) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO boardDTO2=noticeService.selectContents(boardDTO);
		view.addObject("contents", boardDTO2);
		String admin=(String) session.getAttribute("admin");
		if(admin==null){			
			view.addObject("alert", "관리자만 접근 가능합니다.");
			view.addObject("url", "/List.do");
			view.setViewName("main/alert");
		}else{
			view.setViewName("notice/noticeUpdate");
	
		}
		return view;
	}
	@RequestMapping(value = "/Update.do",method=RequestMethod.POST)
	public String noticeUpdatePost(BoardDTO boardDTO) throws Exception {
		int result=noticeService.updateContents(boardDTO);
		return "redirect:/Contents.do?boardNum="+boardDTO.getBoardNum();
	}
	@RequestMapping(value = "/Delete.do")
	public ModelAndView noticeDelete(BoardDTO boardDTO,HttpSession session) throws Exception {
		boardDTO.setAdminDelete("y");
		int result=noticeService.deleteContents(boardDTO);
		ModelAndView view=new ModelAndView();
		String admin=(String) session.getAttribute("admin");
		if(admin==null){
			view.addObject("alert", "관리자만 접근 가능합니다.");
			view.addObject("url", "/List.do");
			view.setViewName("main/alert");
		}else{
			view.setViewName("redirect:/List.do");			
		}
		return view;
	}
	
	@RequestMapping(value="/replyWrite.do",method=RequestMethod.POST)
	public String replyWrite(NoticeReplyDTO noticeReplyDTO) throws Exception{
		int result=noticeService.insertReply(noticeReplyDTO);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		return "redirect:/Contents.do?boardNum="+noticeReplyDTO.getBoardNum();
	}
	
	@RequestMapping(value="/replyDelete.do")
	public String replyDelete(NoticeReplyDTO noticeReplyDTO) throws Exception{
		int result=noticeService.deleteReply(noticeReplyDTO);
		return "redirect:/Contents.do?boardNum="+noticeReplyDTO.getBoardNum();
	}
	
}
