package egov.cmsystem.test.control;

import java.net.InetAddress;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	String adminIp="192.168.0.29";
	String adminIp2="192.168.0.6";
	/*******************
	 주소 통일합시다!
	 ---자유게시판----
	communityList.do
	communityContents.do
	communityWrite.do
	communityUpdate.do
	communityDelete.do
	
	----공지사항----
	List.do
	Contents.do
	Write.do
	Update.do
	Delete.do
	
	----qna----
	qnaList.do
	Contents.do
	Write.do
	Update.do
	Delete.do
	
	
	----메인----
	main.do
	admin0327Main.do
	*********************/
	
	
	@Resource(name="boardService")
	private BoardServiceImpl boardService;

	@RequestMapping(value = "/main.do")
	public ModelAndView mainview() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/mainView2");
		return view;
	}

	//추가절 ****************************************

	@RequestMapping(value="/admin0327Main.do",method=RequestMethod.GET)
	public ModelAndView adminMainView(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String ip=request.getRemoteAddr();
		if(ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")){
		    InetAddress inetAddress=InetAddress.getLocalHost();
		    ip=inetAddress.getHostAddress();
		}
		System.out.println(ip);
		String text="";
		if(adminIp.equals(ip) || adminIp2.equals(ip)){
			mv.addObject("adminPw", "admin0327");			
		}else{
			text="관리자 ip주소가 아닙니다.";
			mv.addObject("text",text);
		}
		mv.setViewName("main/mainView2");
		return mv;
	}
	
	@RequestMapping(value="/admin0327Main.do",method=RequestMethod.POST)
	public ModelAndView adminMainView(HttpSession session,HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		session.setAttribute("admin", "관리자");
		session.setMaxInactiveInterval(60*10);
		mv.setViewName("main/mainView2");
		return mv;
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/admin0327Main.do";
	}
	
	
@RequestMapping(value = "/qnaList.do",method=RequestMethod.GET)
public ModelAndView qnaList(BoardVO vo) throws Exception {
	ModelAndView view=new ModelAndView();
		List<?> ar=boardService.selectList(vo);
		view.addObject("list", ar);
		view.addObject("page", vo);
		view.setViewName("qna/qnaList");
		
		return view;
	}
	@RequestMapping(value = "/qnaList.do",method=RequestMethod.POST)
	public ModelAndView qnaListSearch(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=boardService.selectListSearch(vo);
		view.addObject("list", ar);
		view.addObject("page", vo);
		view.setViewName("qna/qnaList");
		return view;
	}
	
	
	@RequestMapping(value = "/qnaContents.do")
	public ModelAndView qnaContents(BoardDTO boardDTO,HttpSession session) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO dto=boardService.selectContents(boardDTO);
		int count =boardService.selectCount(boardDTO);
		
		view.addObject("contents", dto);
		view.addObject("count",count);
		String AdminDelete = dto.getAdminDelete();
		
		if(AdminDelete.equals("n")){
			view.setViewName("qna/qnaContents");	
		}else{
			String admin=(String) session.getAttribute("admin");
			if(admin==null){
				view.addObject("alert", "관리자만 접근 가능합니다.");
				view.addObject("url", "/qnaList.do");
				view.setViewName("main/alert");
			}else{
				view.setViewName("qna/qnaContents");			
			}
			
		}
		
		return view;
	}
	
	@RequestMapping(value = "/qnaUpdate.do",method=RequestMethod.GET)
	public ModelAndView qnaUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv=new ModelAndView();
		BoardDTO dto=boardService.selectContents(boardDTO);
		mv.addObject("contents", dto);
		mv.setViewName("qna/qnaUpdate");
		return mv;
	}
	@RequestMapping(value = "/qnaUpdate.do",method=RequestMethod.POST)
	public String qnaUpdatePOST(BoardDTO boardDTO) throws Exception{
		int result=boardService.updateContents(boardDTO);

		return "redirect:/qnaContents.do?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "/qnaWrite.do",method=RequestMethod.GET)
	public ModelAndView qnaFrom() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("qna/qnaForm");
		return view;
	}
	
	@RequestMapping(value = "/qnaWrite.do", method=RequestMethod.POST)
	public String qnaFrom(BoardDTO boardDTO) throws Exception {
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		int result=boardService.insertContents(boardDTO);

		return "redirect:/qnaList.do";
	}
	
	@RequestMapping(value = "/qnaAdminForm.do",method=RequestMethod.GET)
	public ModelAndView qnaAdminForm(BoardDTO boardDTO,HttpSession session) throws Exception{
		ModelAndView view=new ModelAndView();
		BoardDTO dto=boardService.selectContents(boardDTO);
		view.addObject("contents", dto);
		
		String admin=(String) session.getAttribute("admin");
		if(admin==null){
			view.addObject("alert", "관리자만 접근 가능합니다.");
			view.addObject("url", "/qnaList.do");
			view.setViewName("main/alert");
		}else{
			view.setViewName("qna/qnaAdminForm");			
		}
		return view;
	}
	
	@RequestMapping(value = "/qnaAdminUpdate.do",method=RequestMethod.GET)
	public ModelAndView qnaAdminUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv=new ModelAndView();
		BoardDTO dto=boardService.selectContents(boardDTO);
		mv.addObject("contents", dto);
		mv.setViewName("qna/qnaAdminUpdate");
		return mv;
	}
	@RequestMapping(value = "/qnaAdminUpdate.do",method=RequestMethod.POST)
	public String qnaAdminUpdatePost(BoardDTO boardDTO) throws Exception{

		int dto=boardService.relplyupdateContents(boardDTO);

		return "redirect:/qnaContents.do?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value = "/qnaAdminForm.do",method=RequestMethod.POST)
	public String qnaAdminFormPost(BoardDTO boardDTO) throws Exception{
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		int result=boardService.replyinsertContents(boardDTO);
		return "redirect:/qnaContents.do?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value="/qnaDelete.do")
	public String communityDelete(BoardDTO boardDTO) throws Exception{
		BoardDTO dto=boardService.selectContents(boardDTO);
		int result=boardService.deleteContents(dto);
	
		return "redirect:/qnaList.do";
	}
	
	@RequestMapping(value = "/Profile.do")
	public ModelAndView Profile() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/profile");
		return view;
	}
	
	@RequestMapping(value = "/History.do")
	public ModelAndView history() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/history");
		return view;
	}
	
}
