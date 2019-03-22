package egov.cmsystem.test.util;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import egov.cmsystem.test.service.BoardDTO;

public class FileSaver {
	
	@Resource(name = "fileUploadProperties")
	Properties fileUploadProperties;
	

	public BoardDTO saveFile(MultipartFile file,BoardDTO boardDTO)throws Exception{
		String uploadPath = fileUploadProperties.getProperty("file.upload.path");
		File saveFolder = new File(uploadPath);
		//없을 경우에 폴더 생성
		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		String fileName= file.getOriginalFilename();
		boardDTO.setFileOriginalName(fileName);
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		boardDTO.setFileSaveName(fileName);
		File f = new File(uploadPath, fileName);
		file.transferTo(f);
		
		return boardDTO;
	}
	
}
