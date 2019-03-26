package egov.cmsystem.test.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.NoticeReplyDTO;
import egov.cmsystem.test.service.impl.NoticeServiceImpl;

@Controller
public class NoticeController {

	@Resource(name="noticeService")
	private NoticeServiceImpl noticeService;

	@RequestMapping(value = "/List.do")
	public ModelAndView noticeList(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=noticeService.selectList(vo);
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
		view.addObject("contents", dto);
		view.addObject("replyList",ar);
		view.setViewName("notice/noticeContents");
		return view;
	}
	@RequestMapping(value = "/Write.do",method=RequestMethod.GET)
	public ModelAndView noticeWrite(HttpSession session) throws Exception {
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
	public String noticeWrite(BoardDTO boardDTO) throws Exception {
		boardDTO.setBoardPw("");
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		ModelAndView view=new ModelAndView();
		int result=noticeService.insertContents(boardDTO);
		view.setViewName("notice/noticeForm");
		return "redirect:/List.do";
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