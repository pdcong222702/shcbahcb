package dev.QLNK.phamduccong.quanlynhankhau.Service.Impl;

import dev.QLNK.Entity.Population;
import dev.QLNK.phamduccong.quanlynhankhau.Dto.PopulationDto;
import dev.QLNK.phamduccong.quanlynhankhau.Reponsitory.PopulationRespository;
import dev.QLNK.phamduccong.quanlynhankhau.Service.PopulationService;
import dev.QLNK.phamduccong.quanlynhankhau.utils.UploadPopulationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PopulationServiceImpl implements PopulationService {
    @Autowired
    private PopulationRespository populationRespository;
    @Autowired
    private UploadPopulationImage populationImage;
    @Override
    public List<Population> selectAll() {
//        List<Population> population = populationRespository.findAll();
//        List<PopulationDto> populationDtoList =transferData(population);
        return populationRespository.findAll();
    }
/*
    private List<PopulationDto> transferData(List<Population> populations){
        List<PopulationDto> populationDtoList = new ArrayList<>();
        for (Population population : populations){
            PopulationDto populationDto =new PopulationDto();
            populationDto.setPopulationCode(population.getPopulationCode());
            populationDto.setResidenceBookletCode(population.getResidenceBookletCode());
            populationDto.setPopulationName(population.getPopulationName());
            populationDto.setPopulationNickName(population.getPopulationNickName());
            populationDto.setImage(population.getImage());
            populationDto.setDateOfBirth(population.getDateOfBirth());
            populationDto.setGender(population.getGender());
            populationDto.setBirthPlace(population.getBirthPlace());
            populationDto.setEthnicity(population.getEthnicity());
            populationDto.setReligion(population.getReligion());
            populationDto.setJob(population.getJob());
            populationDto.setRelationship(population.getRelationship());
            populationDto.setDateOfIssue(population.getDateOfIssue());
            populationDto.setPlaceOfIssue(population.getPlaceOfIssue());
            populationDto.setWorkPlace(population.getWorkPlace());
            populationDto.setCreateDate(population.getCreateDate());
            populationDtoList.add(populationDto);
        }
        return populationDtoList;
    }*/
    @Override
    public Population save(MultipartFile image,PopulationDto population) {
        try {
            Population populationSave = new Population();
            populationSave.setPopulationCode(population.getPopulationCode());
            populationSave.setResidenceBookletCode(population.getResidenceBookletCode());
            populationSave.setPopulationName(population.getPopulationName());
            populationSave.setPopulationNickName(population.getPopulationNickName());
            String data=population.getImageName();
            //MultipartFile file =population.getImage();
//            String uploadFolder = "D:\\Haui\\MSCNPT\\QuanLyNhanKhau\\src\\main\\resources\\static\\images\\image_population";
//            byte[] imageData=image.getBytes();
//            String imagePath="images/image_population/"+data;
//            //Files.write(Paths.get(imagePath),imageData);
//            Files.copy(image.getInputStream(), Paths.get(uploadFolder + File.separator,image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            //populationImage.upload(image);
            populationImage.upload(image);
            populationSave.setImage(data);
            populationSave.setImageName(population.getImageName());
            populationSave.setDateOfBirth(population.getDateOfBirth());
            populationSave.setGender(population.getGender());
            populationSave.setBirthPlace(population.getBirthPlace());
            populationSave.setEthnicity(population.getEthnicity());
            populationSave.setReligion(population.getReligion());
            populationSave.setJob(population.getJob());
            populationSave.setRelationship(population.getRelationship());
            populationSave.setDateOfIssue(population.getDateOfIssue());
            populationSave.setPlaceOfIssue(population.getPlaceOfIssue());
            populationSave.setDead(false);
            populationSave.setAlive(true);
            populationSave.setWorkPlace(population.getWorkPlace());
            populationSave.setCreateDate(population.getCreateDate());
            return populationRespository.save(populationSave);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Population update(PopulationDto populationDto) {
        try{
            Population populationUpdate = populationRespository.getReferenceById(populationDto.getId());
            //Population populationUpdate = populationRespository.findById(population.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid population ID: " + population.getId()));;
            populationUpdate.setPopulationCode(populationDto.getPopulationCode());
            populationUpdate.setResidenceBookletCode(populationDto.getResidenceBookletCode());
            populationUpdate.setPopulationName(populationDto.getPopulationName());
            populationUpdate.setPopulationNickName(populationDto.getPopulationNickName());
//            String data=populationDto.getImageName();
//            if(file==null){
//                populationUpdate.setImage(data);
//            }else {
//                if(!populationImage.checkExited(file)){
//                    //populationImage.upload(file);
//                    System.out.println("Upload thanh cong");
//                }
//                System.out.println("Anh da ton tai");
//                populationUpdate.setImageName(populationDto.getImageName());
//            }
            populationUpdate.setDateOfBirth(populationDto.getDateOfBirth());
            populationUpdate.setGender(populationDto.getGender());
            populationUpdate.setBirthPlace(populationDto.getBirthPlace());
            populationUpdate.setEthnicity(populationDto.getEthnicity());
            populationUpdate.setReligion(populationDto.getReligion());
            populationUpdate.setJob(populationDto.getJob());
            populationUpdate.setRelationship(populationDto.getRelationship());
            populationUpdate.setDateOfIssue(populationDto.getDateOfIssue());
            populationUpdate.setPlaceOfIssue(populationDto.getPlaceOfIssue());
            populationUpdate.setWorkPlace(populationDto.getWorkPlace());
            populationUpdate.setCreateDate(populationDto.getCreateDate());
            //Population populationSave = new Population();
            //populationSave.setPopulationName(population.getPopulationName());
            return populationRespository.save(populationUpdate);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void alive(Long id) {
        Population population =populationRespository.getReferenceById(id);
        population.setAlive(true);
        population.setDead(false);
        populationRespository.save(population);
    }

    @Override
    public void dead(Long id) {
        Population population =populationRespository.getReferenceById(id);
        population.setAlive(false);
        population.setDead(true);
        populationRespository.save(population);
    }

    @Override
    public PopulationDto getById(Long id) {

        //Population populationgetId = populationRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid population ID: " + id));;
        Population populationgetId = populationRespository.getReferenceById(id);
        PopulationDto population = new PopulationDto();
        population.setId(populationgetId.getId());
        population.setPopulationCode(populationgetId.getPopulationCode());
        population.setResidenceBookletCode(populationgetId.getResidenceBookletCode());
        population.setPopulationName(populationgetId.getPopulationName());
        population.setPopulationNickName(populationgetId.getPopulationNickName());
        population.setDateOfBirth(populationgetId.getDateOfBirth());
        population.setGender(populationgetId.getGender());
        population.setBirthPlace(populationgetId.getBirthPlace());
        population.setEthnicity(populationgetId.getEthnicity());
        population.setReligion(populationgetId.getReligion());
        population.setJob(populationgetId.getJob());
        population.setRelationship(populationgetId.getRelationship());
        population.setDateOfIssue(populationgetId.getDateOfIssue());
        population.setPlaceOfIssue(populationgetId.getPlaceOfIssue());
        population.setWorkPlace(populationgetId.getWorkPlace());
        population.setCreateDate(populationgetId.getCreateDate());
        return population;
        //return populationRespository.findById(id).get();
    }
}
