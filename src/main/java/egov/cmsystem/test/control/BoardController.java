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
	
	
}
