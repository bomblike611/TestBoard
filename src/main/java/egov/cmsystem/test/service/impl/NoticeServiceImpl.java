package egov.cmsystem.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardService;
import egov.cmsystem.test.service.BoardVO;

@Service("noticeService")
public class NoticeServiceImpl implements BoardService{
	
	@Resource(name="noticeDAO")
	private NoticeDAO noticeDAO;
	
	@Override
	public int deleteContents(BoardDTO boardDTO) throws Exception {
		return noticeDAO.deleteContents(boardDTO);
	}
	@Override
	public int insertContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.insertContents(boardDTO);
	}
	@Override
	public BoardDTO selectContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.selectContents(boardDTO);
	}
	@Override
	public List<?> selectList(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.selectList(vo);
	}
	@Override
	public int updateContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.updateContents(boardDTO);
	}
}
