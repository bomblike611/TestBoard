package egov.cmsystem.test.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	String adminIp="0:0:0:0:0:0:0:1";
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
	
	@RequestMapping(value="/admin0327Main.do",method=RequestMethod.GET)
	public ModelAndView adminMainView(HttpServletRequest request) throws Exception{
		ModelAndView mv=new ModelAndView();
		String ip=request.getRemoteAddr();
		System.out.println(ip);
		String text="";
		if(adminIp.equals(ip)){
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
	
	@RequestMapping(value = "/List.do")
	public ModelAndView List() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("notice/noticeList");
		return view;
	}
	
	@RequestMapping(value="/noticeContents.do")
	public ModelAndView noticeContents()throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("notice/noticeContents");
		return mv;
	}


	
}
