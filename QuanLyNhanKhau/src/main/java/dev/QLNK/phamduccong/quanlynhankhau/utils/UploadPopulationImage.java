package dev.QLNK.phamduccong.quanlynhankhau.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadPopulationImage {
    private final String uploadFolder = "D:\\Haui\\MSCNPT\\Test\\QuanLyNhanKhau\\src\\main\\resources\\static\\images\\image_population";

    public boolean upload(MultipartFile image){
        boolean isupload=false;
        try {
            Files.copy(image.getInputStream(), Paths.get(uploadFolder + File.separator,image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            isupload=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isupload;
    }

    public boolean checkExited(MultipartFile image){
        boolean isExisted=false;
        try {
            File file = new File(uploadFolder+"\\"+image.getOriginalFilename());
            isExisted=file.exists();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isExisted;
    }
}
