package egov.cmsystem.test.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.swing.event.CellEditorListener;

import org.springframework.stereotype.Service;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardService;
import egov.cmsystem.test.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;

	@Override
	public int insertContents(BoardDTO boardDTO) throws Exception {
		return boardDAO.insertContents(boardDTO);
	}

	public int replyinsertContents(BoardDTO boardDTO) throws Exception {
		return boardDAO.replyinsertContents(boardDTO);
	}

	@Override
	public int updateContents(BoardDTO boardDTO) throws Exception {
		return boardDAO.updateContents(boardDTO);
	}
	
	public int relplyupdateContents(BoardDTO boardDTO) throws Exception {
		return boardDAO.replyupdateContents(boardDTO);
	}

	@Override
	public int deleteContents(BoardDTO boardDTO) throws Exception {
		boardDTO.setAdminDelete("y");
		return boardDAO.deleteContents(boardDTO);
	}

	@Override
	public BoardDTO selectContents(BoardDTO boardDTO) throws Exception {
		return boardDAO.selectContents(boardDTO);
	}

	@Override
	public List<?> selectList(BoardVO vo) throws Exception {
		
		int totalrecord=boardDAO.selectTotalCount();
		
		vo.setTotalrecord(totalrecord);
	
		return boardDAO.selectList(vo);
	}
	
	public List<?> selectListSearch(BoardVO vo) throws Exception {
	
		int totalrecord=boardDAO.selectTotalCountSearch(vo);
		vo.setTotalrecord(totalrecord);
		
		return boardDAO.selectListSearch(vo);
	}
	

	
	
}
