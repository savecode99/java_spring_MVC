package com.bavung.javaMVC.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UpLoadFileService {

    String avatar = "";
    private ServletContext servletContext;
    public  UpLoadFileService(ServletContext servletContext){
        this.servletContext = servletContext;
    }
    public String hanldeUpLoadFile(MultipartFile file, String targetFile)
    {
         try {
            byte[] bytes = file.getBytes();
            String a = this.servletContext.getRealPath("");
            String rootPath = this.servletContext.getRealPath("/resources/images");
            File dir = new File(rootPath + File.separator + targetFile);
            
            if (!dir.exists())
            dir.mkdirs();
            // Create the file on server
            avatar = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + avatar);

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return avatar;
    }
}
