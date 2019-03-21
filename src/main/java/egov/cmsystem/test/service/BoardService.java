package egov.cmsystem.test.service;

import java.util.List;

public interface BoardService {

	int insertContents() throws Exception;
	
	int updateContents() throws Exception;
	
	int deleteContents() throws Exception;
	
	BoardDTO selectContents(BoardDTO boardDTO) throws Exception;
	
	List<?> selectList(BoardVO vo) throws Exception;
	
	int selectTotalCount(BoardVO vo) throws Exception;
	
	
	
	
}
