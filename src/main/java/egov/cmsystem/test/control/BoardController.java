package egov.cmsystem.test.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardServiceImpl boardService;
	
	@RequestMapping(value = "/index.do")
	public ModelAndView selectOne() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("test/test");

		return view;
	}
	
	@RequestMapping(value = "/communityList.do")
	public ModelAndView communityList() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/communityList");
		return view;
	}
	
	@RequestMapping(value = "/communityContents.do")
	public ModelAndView communityContents() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/communityContents");
		return view;
	}
	@RequestMapping(value = "/mylist.do")
	public ModelAndView mylist() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/mylist");
		return view;
	}
	
	@RequestMapping(value = "/main.do")
	public ModelAndView mainview() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/Main");
		return view;
	}
	
	
}
