package egov.cmsystem.test.service;

import java.util.List;

public interface BoardService {

	int insertContents(BoardDTO boardDTO) throws Exception;
	
	int updateContents(BoardDTO boardDTO) throws Exception;
	
	int deleteContents(BoardDTO boardDTO) throws Exception;
	
	BoardDTO selectContents(BoardDTO boardDTO) throws Exception;
	
	List<?> selectList(BoardVO vo) throws Exception;

	
	
	
	
}
