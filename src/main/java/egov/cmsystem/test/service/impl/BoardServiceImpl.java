package egov.cmsystem.test.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	public String selectOne()throws Exception{
		return boardDAO.selectOne();
	}
	
	
}
