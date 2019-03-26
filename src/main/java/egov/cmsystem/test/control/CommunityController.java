package egov.cmsystem.test.control;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;


import egov.cmsystem.test.service.BoardDTO;
import egov.cmsystem.test.service.BoardVO;
import egov.cmsystem.test.service.impl.CommunityServiceImpl;

@Controller
public class CommunityController {
	
	@Resource(name = "fileUploadProperties")
	Properties fileUploadProperties;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	
	@Resource(name="communityService")
	private CommunityServiceImpl communityService;

	
	@RequestMapping(value = "/communityList.do")
	public ModelAndView communityList(BoardVO vo) throws Exception {
		ModelAndView view=new ModelAndView();
		List<?> ar=communityService.selectList(vo);
		view.addObject("list", ar);
		view.setViewName("community/communityList");
		/*
		view.addObject("subject", "커뮤니티");
		view.addObject("mini1", "자유게시판");
		view.addObject("mini2", "Q&A");*/
		return view;
	}
	
	@RequestMapping(value = "/communityContents.do")
	public ModelAndView communityContents(BoardDTO boardDTO) throws Exception {
		ModelAndView view=new ModelAndView();
		BoardDTO dto=communityService.selectContents(boardDTO);
		view.addObject("contents", dto);
		view.setViewName("community/communityContents");
		return view;
	}
	@RequestMapping(value = "/communityWrite.do",method=RequestMethod.GET)
	public ModelAndView communityForm() throws Exception {
		ModelAndView view=new ModelAndView();
		view.setViewName("community/communityForm");

		return view;
	}
	@RequestMapping(value = "/communityWrite.do", method=RequestMethod.POST)
	public String communityForm(BoardDTO boardDTO,HttpServletRequest request,HttpSession session) throws Exception {
		boardDTO.setAdminDelete("n");
		boardDTO.setFileOriginalName("");
		boardDTO.setFileSaveName("");
		//파일업로드파트
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		MultipartFile file=multipartHttpServletRequest.getFile("file");
		//이거 안먹힘 ㅠ,,
		/*String uploadPath=session.getServletContext().getRealPath("resources/upload");*/
		if(file.getOriginalFilename()!=""){
		String uploadPath = fileUploadProperties.getProperty("file.upload.path");
		File saveFolder = new File(uploadPath);
		 
		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		boardDTO.setFileOriginalName(file.getOriginalFilename());
		String fileName= file.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		File f = new File(uploadPath, fileName);
		file.transferTo(f);
		boardDTO.setFileSaveName(fileName);
		}
		int result=communityService.insertContents(boardDTO);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		return "redirect:/communityList.do";
	}
	
	@RequestMapping(value = "/communityUpdate.do",method=RequestMethod.GET)
	public ModelAndView communityUpdate(BoardDTO boardDTO) throws Exception{
		ModelAndView mv=new ModelAndView();
		BoardDTO dto=communityService.selectContents(boardDTO);
		mv.addObject("contents", dto);
		mv.setViewName("community/communityUpdate");

		return mv;
	}
	@RequestMapping(value = "/communityUpdate.do",method=RequestMethod.POST)
	public String communityUpdatePOST(BoardDTO boardDTO,HttpServletRequest request,HttpSession session) throws Exception{
		String check=(String)request.getParameter("check");
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		MultipartFile file=multipartHttpServletRequest.getFile("file");
		//이거 안먹힘 ㅠ,,
		/*String uploadPath=session.getServletContext().getRealPath("resources/upload");*/
		if(check.equals("1")){
			
		}else if(file.getOriginalFilename()!=""){
		String uploadPath = fileUploadProperties.getProperty("file.upload.path");
		File saveFolder = new File(uploadPath);
		 
		BoardDTO boardDTO2=communityService.selectContents(boardDTO);
		if(boardDTO2.getFileSaveName()!=null){
			File deletefile=new File("D:\\upload\\"+boardDTO2.getFileSaveName());
			System.out.println(boardDTO2.getFileSaveName());
			deletefile.delete();
		}
		
		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		boardDTO.setFileOriginalName(file.getOriginalFilename());
		String fileName= file.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		File f = new File(uploadPath, fileName);
		file.transferTo(f);
		boardDTO.setFileSaveName(fileName);
		}else{
			BoardDTO boardDTO2=communityService.selectContents(boardDTO);
			if(boardDTO2.getFileSaveName()!=null){
				File deletefile=new File("D:\\upload\\"+boardDTO2.getFileSaveName());
				System.out.println(boardDTO2.getFileSaveName());
				deletefile.delete();
			}
			boardDTO.setFileOriginalName("");
			boardDTO.setFileSaveName("");
		}
		int result=communityService.updateContents(boardDTO);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		return "redirect:/communityContents.do?boardNum="+boardDTO.getBoardNum();
	}
	
	@RequestMapping(value="/communityDelete.do")
	public String communityDelete(BoardDTO boardDTO) throws Exception{
		BoardDTO dto=communityService.selectContents(boardDTO);
		int result=communityService.deleteContents(dto);
		String resultText="";
		if(result>0){
			resultText="성공";
		}else{
			resultText="실패";
		}
		System.out.println(resultText);
		return "redirect:/communityList.do";
	}
	
	@RequestMapping(value="/moreContents.do")
	public ModelAndView moreContents(BoardVO vo)throws Exception{
		ModelAndView mv=new ModelAndView();
		List<?> ar=communityService.selectList(vo);
		mv.addObject("list", ar);
		mv.setViewName("community/moreContents");
		return mv;
	}
	
}
