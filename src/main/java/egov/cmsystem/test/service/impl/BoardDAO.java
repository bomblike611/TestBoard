package egov.cmsystem.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.BoardDTO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractMapper{

	public final String namespace="egovframework.sqlmap.mappers.boardMapper.";
	

    public List<?> selectList(BoardVO vo) throws Exception{
    	return getSqlSession().selectList(namespace+"selectList", vo);
    }
	
    public int selectTotalCount() throws Exception{
    	return getSqlSession().selectOne(namespace+"selectTotalCount");
    }
    
    public BoardDTO selectContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectOne(namespace+"selectContents", boardDTO);
    }
	
}
