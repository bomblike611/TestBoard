package egov.cmsystem.test.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("communityDAO")
public class CommunityDAO extends EgovAbstractMapper{
	
	public final String namespace="egovframework.sqlmap.mappers.communityMapper.";
	
	SqlSession sqlSession=getSqlSession();
	
    public int insertContents(BoardDTO boardDTO) throws Exception{
    	return sqlSession.insert(namespace+"insertContents", boardDTO);
    }
	
    public int updateContents(BoardDTO boardDTO) throws Exception{
    	return sqlSession.update(namespace+"updateContents", boardDTO);
    }
	
    public int deleteContents(BoardDTO boardDTO) throws Exception{
    	return sqlSession.delete(namespace+"deleteContents", boardDTO);
    }
	
    public BoardDTO selectContents(BoardDTO boardDTO) throws Exception{
    	return sqlSession.selectOne(namespace+"selectContents", boardDTO);
    }
	
    public List<?> selectList(BoardVO vo) throws Exception{
    	return sqlSession.selectList(namespace+"selectList", vo);
    }
	
    public int selectTotalCount(BoardVO vo) throws Exception{
    	return sqlSession.selectOne(namespace+"selectTotalCount", vo);
    }
	
	
}
