package egov.cmsystem.test.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {

	
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
	@RequestMapping(value = "/communityWrite.do")
	public ModelAndView communityFrom() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/communityForm");
		return view;
	}
}
