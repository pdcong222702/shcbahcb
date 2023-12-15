package dev.QLNK.phamduccong.quanlynhankhau.Service;



import dev.QLNK.Entity.Population;
import dev.QLNK.phamduccong.quanlynhankhau.Dto.PopulationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PopulationService {
    List<Population> selectAll();
    Population save(MultipartFile multipartFile,PopulationDto population);
    Population update(PopulationDto populationDto);
    void alive(Long id);
    void dead(Long id);
    PopulationDto getById(Long id);
}
