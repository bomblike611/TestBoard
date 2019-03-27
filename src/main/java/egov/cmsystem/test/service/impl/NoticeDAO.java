package egov.cmsystem.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.NoticeReplyDTO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("noticeDAO")
public class NoticeDAO extends EgovAbstractMapper{

public final String namespace="egovframework.sqlmap.mappers.noticeMapper.";
	
	
    public int insertContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().insert(namespace+"insertContents", boardDTO);
    }
	
    public int updateContents(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().update(namespace+"updateContents", boardDTO);
    }
    public int updateHits(BoardDTO boardDTO)throws Exception{
    	return getSqlSession().update(namespace+"updateHits", boardDTO);
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
    public List<?> selectReplyList(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectList(namespace+"selectReplyList",boardDTO);
    }
    public int insertReply(NoticeReplyDTO noticeReplyDTO) throws Exception{
    	return getSqlSession().insert(namespace+"insertReply",noticeReplyDTO);
    }
    public int deleteReply(NoticeReplyDTO noticeReplyDTO) throws Exception{
    	return getSqlSession().delete(namespace+"deleteReply", noticeReplyDTO);
    }
    public BoardDTO selectPrevNext(BoardDTO boardDTO) throws Exception{
    	return getSqlSession().selectOne(namespace+"selectPrevNext", boardDTO);
    }
}
