package egov.cmsystem.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardService;
import egov.cmsystem.test.service.BoardVO;

@Service("communityService")
public class CommunityServiceImpl implements BoardService {
	
	@Resource(name="communityDAO")
	private CommunityDAO communityDAO;

	@Override
	public int insertContents(BoardDTO boardDTO) throws Exception {
		return communityDAO.insertContents(boardDTO);
	}

	@Override
	public int updateContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.updateContents(boardDTO);
	}

	@Override
	public int deleteContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.updateContents(boardDTO);
	}

	@Override
	public BoardDTO selectContents(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.selectContents(boardDTO);
	}

	@Override
	public List<?> selectList(BoardVO vo) throws Exception {
		int totalCount=communityDAO.selectTotalCount();
		vo.setTotalIndex(totalCount);
		if(totalCount<vo.getLastIndex()){
			vo.setLastIndex(totalCount);
		}
		return communityDAO.selectList(vo);
	}



}
