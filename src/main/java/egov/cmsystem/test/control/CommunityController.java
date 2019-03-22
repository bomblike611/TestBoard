package egov.cmsystem.test.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String communityFrom(BoardDTO boardDTO,MultipartFile file) throws Exception {
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		int result=communityService.insertContents(boardDTO);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		return "redirect:/communityList.do";
	}
	
	@RequestMapping(value = "/communityUpdate.do",method=RequestMethod.GET)
	public ModelAndView communityUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv=new ModelAndView();
		BoardDTO dto=communityService.selectContents(boardDTO);
		mv.addObject("contents", dto);
		mv.setViewName("community/communityUpdate");
		return mv;
	}
	@RequestMapping(value = "/communityUpdate.do",method=RequestMethod.POST)
	public String communityUpdatePOST(BoardDTO boardDTO) throws Exception{
		System.out.println(boardDTO.getBoardTitle());
		int result=communityService.updateContents(boardDTO);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		System.out.println(resultText);
		return "redirect:/communityContents.do?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value="/communityDelete.do")
	public String communityDelete(BoardDTO boardDTO) throws Exception{
		BoardDTO dto=communityService.selectContents(boardDTO);
		int result=communityService.deleteContents(dto);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		System.out.println(resultText);
		return "redirect:/communityList.do";
	}
}
