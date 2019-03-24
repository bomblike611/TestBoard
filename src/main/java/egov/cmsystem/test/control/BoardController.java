package egov.cmsystem.test.control;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardServiceImpl boardService;
	
	
	@RequestMapping(value = "/main.do")
	public ModelAndView mainview() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("main/banner");
		return view;
	}

	//추가절 ****************************************
	
	@RequestMapping(value = "/qnaList.do")
	public ModelAndView qnaList(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=boardService.selectList(vo);
		view.addObject("list", ar);
		view.addObject("page", vo);
		view.setViewName("qna/qnaList");
		return view;
	}
	
	@RequestMapping(value = "/qnaContents.do")
	public ModelAndView qnaContents(BoardDTO boardDTO) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO dto=boardService.selectContents(boardDTO);
		view.addObject("contents", dto);
		view.setViewName("qna/qnaContents");
		return view;
	}
	
}
