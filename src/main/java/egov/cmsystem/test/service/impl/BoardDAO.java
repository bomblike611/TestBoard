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
    
    public List<?> selectListSearch(BoardVO vo) throws Exception{
    	System.out.println(vo.getSearchKeyword());
    	return getSqlSession().selectList(namespace+"selectListSearch", vo);
    }
	
    public int selectTotalCount() throws Exception{
    	return getSqlSession().selectOne(namespace+"selectTotalCount");
    }
    public int selectTotalCountSearch(BoardVO vo) throws Exception{
    	
    	return getSqlSession().selectOne(namespace+"selectTotalCountSearch",vo);
    }
    
    public BoardDTO selectContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectOne(namespace+"selectContents", boardDTO);
    }
    
    public int selectCount(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectOne(namespace+"selectCount", boardDTO);
    }
    
    
    public int updateContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().update(namespace+"updateContents", boardDTO);
    }
    
    public int insertContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().insert(namespace+"insertContents", boardDTO);
    }
    
    public int replyinsertContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().insert(namespace+"replyinsertContents", boardDTO);
    }
   
    public int  replyupdateContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().update(namespace+"replyupdateContents", boardDTO);
    }
    
    public int deleteContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().delete(namespace+"deleteContents", boardDTO);
    }
}
