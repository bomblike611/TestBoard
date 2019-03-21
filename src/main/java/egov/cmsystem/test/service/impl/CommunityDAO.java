package egov.cmsystem.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("communityDAO")
public class CommunityDAO extends EgovAbstractMapper{
	
	public final String namespace="egovframework.sqlmap.mappers.communityMapper.";
	
	
    public int insertContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().insert(namespace+"insertContents", boardDTO);
    }
	
    public int updateContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().update(namespace+"updateContents", boardDTO);
    }
	
    public int deleteContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().delete(namespace+"deleteContents", boardDTO);
    }
	
    public BoardDTO selectContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectOne(namespace+"selectContents", boardDTO);
    }
	
    public List<?> selectList(BoardVO vo) throws Exception{
    	return getSqlSession().selectList(namespace+"selectList", vo);
    }
	
    public int selectTotalCount() throws Exception{
    	return getSqlSession().selectOne(namespace+"selectTotalCount");
    }
	
	
}
