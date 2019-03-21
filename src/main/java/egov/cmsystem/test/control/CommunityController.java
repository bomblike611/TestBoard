package egov.cmsystem.test.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.impl.CommunityServiceImpl;

@Controller
public class CommunityController {
	
	@Resource(name="communityService")
	private CommunityServiceImpl communityService;

	
	@RequestMapping(value = "/communityList.do")
	public ModelAndView communityList(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=communityService.selectList(vo);
		view.addObject("list", ar);
		view.setViewName("community/communityList");
		return view;
	}
	
	@RequestMapping(value = "/communityContents.do")
	public ModelAndView communityContents(BoardDTO boardDTO) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO dto=communityService.selectContents(boardDTO);
		view.addObject("contents", dto);
		view.setViewName("community/communityContents");
		return view;
	}
	@RequestMapping(value = "/communityWrite.do",method=RequestMethod.GET)
	public ModelAndView communityFrom() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/communityForm");
		return view;
	}
	@RequestMapping(value = "/communityWrite.do", method=RequestMethod.POST)
	public ModelAndView communityFrom(BoardDTO boardDTO) throws Exception {
		ModelAndView view=new ModelAndView();
		System.out.println(boardDTO.getBoardTitle());
		int result=communityService.insertContents(boardDTO);
		if(result>0){
			
		}else{
			
		}
		view.setViewName("community/communityForm");
		return view;
	}
}
