package egov.cmsystem.test.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardService;
import egov.cmsystem.test.service.BoardVO;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;


@Service("boardService")
public class BoardServiceImpl implements BoardService,Validator{
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	
	
	public boolean supports(Class clazz) {
		return BoardDTO.class.isAssignableFrom(clazz);
	}
 
	public void validate(Object target, Errors errors) {
 
		BoardDTO BoardDTO = (BoardDTO)target;
 
		
		if(BoardDTO.getBoardTitle()==null || BoardDTO.getBoardTitle().length()>200){ //부서설명 프로퍼티는 값의 길이가 10 이상인가?
			errors.rejectValue("boardTitle", "lengthsizeT","제목 입력 허용치를 초과하였습니다.");
		}else if(BoardDTO.getBoardTitle()==null || BoardDTO.getBoardTitle().length()>10){ //부서설명 프로퍼티는 값의 길이가 10 이상인가?
			errors.rejectValue("boardPw", "lengthsizeP","패스워드 입력 허용치를 초과하였습니다.");
		}else if(BoardDTO.getBoardTitle()==null || BoardDTO.getBoardTitle().length()>2000){ //부서설명 프로퍼티는 값의 길이가 10 이상인가?
			errors.rejectValue("boardContents", "lengthsizeC","내용 입력 허용치를 초과하였습니다.");
		}
		
	}	
 
	public boolean isEmptyOrWhitespace(String value){
		if(value==null || value.trim().length() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
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
	
	public int selectCount(BoardDTO boardDTO) throws Exception {
		return boardDAO.selectCount(boardDTO);
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
