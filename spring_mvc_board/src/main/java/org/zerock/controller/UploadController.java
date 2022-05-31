package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.java.Log;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		
		String uploadFolder = "G:\\upload";
		
		for (MultipartFile multipartFile : uploadFile) {
			
			log.info("----------------------------------");
			log.info("Upload File Name:" + multipartFile.getOriginalFilename());
			log.info("Upload File Size:" + multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
		log.info("upload Ajax");
	}
	
   @PostMapping("/uploadAjaxAction")
   public void uploadAjaxPost(MultipartFile[] uploadFile) {
	   
	   log.info("update ajax post....");
	   
	   String uploadFolder = "G:\\upload";
	   
	   // make folder ------
	   File uploadPath = new File(uploadFolder, getFolder());
	   
	   if(uploadPath.exists()==false) {
		   uploadPath.mkdir();
	   }
	   
	   // make yyyy/MM/dd folder
	   for(MultipartFile multipartFile : uploadFile) {
		   
		   String uploadFileName = multipartFile.getOriginalFilename();
		   
		   uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
		   
		   UUID uuid = UUID.randomUUID();
		   
		   uploadFileName = uuid.toString() + "_" + uploadFileName;
		   
		   
		   try {
			   File saveFile = new File(uploadFolder, uploadFileName);
			multipartFile.transferTo(saveFile);
			// check image type file
			if(checkImageType(saveFile)) {
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName));
				Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
				thumbnail.close();
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	   }
   }
   
   private String getFolder() {
	   
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   
	   Date date = new Date();
	   
	   String str = sdf.format(date);
	   
	   return str.replace("-", File.separator);
	   
   }
	
   private boolean checkImageType(File file) {
	   
	   try {
		   String contentType = Files.probeContentType(file.toPath());
		   
		   return contentType.startsWith("image");
		   
	   }catch(IOException e) {
		   e.printStackTrace();
	   }
	   return false;
   }
	
}
