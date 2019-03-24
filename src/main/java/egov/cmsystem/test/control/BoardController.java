package egov.cmsystem.test.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
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
	index.do
	*********************/
	
	
	@Resource(name="boardService")
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/index.do")
	public ModelAndView selectOne() throws Exception {
		ModelAndView view=new ModelAndView();
		String title=boardService.selectOne();
		view.addObject("title", title);
		view.setViewName("test/test");
		
		return view;
	}
	
	@RequestMapping(value = "/main.do")
	public ModelAndView mainview() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/mainView2");
		return view;
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
