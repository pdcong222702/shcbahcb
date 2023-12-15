package dev.QLNK.phamduccong.quanlynhankhau.Controller;

import dev.QLNK.phamduccong.quanlynhankhau.Dto.PopulationDto;
import dev.QLNK.phamduccong.quanlynhankhau.Service.PopulationService;
import dev.QLNK.Entity.Population;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PopulationController {
    @Autowired
    private PopulationService populationService;

    @GetMapping("/populations")
    public String populations(Model model){
        List<Population> populations = populationService.selectAll();
        model.addAttribute("populations",populations);
        model.addAttribute("size",populations.size());
        model.addAttribute("populationNew",new PopulationDto());
        //model.addAttribute("populationUpdate",new Population());
        return "population";
    }

    @PostMapping("/save-population")
    public String add(@ModelAttribute("populationNew")PopulationDto population,@RequestParam("image")MultipartFile file, RedirectAttributes attributes){
        try {
                populationService.save(file,population);
                attributes.addFlashAttribute("success","Thêm thành công nhân khẩu");
            /*if(populationUpdate.getId()!=null){
                populationUpdate=populationService.getById(population.getId());
                populationService.update(populationUpdate);
            }*/
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error","Add error");
        }
        return "redirect:/populations";
    }

    @GetMapping("/update-population/{id}")
    public String showUpdateForm(@PathVariable("id")Long id,Model model){
        PopulationDto populationDto = populationService.getById(id);
        model.addAttribute("populationUpdate",populationDto);
        return "update_population";
    }

    @PostMapping("/update-population/{id}")
    public String updatePopulaton(@ModelAttribute("populationUpdate") PopulationDto populationDto,RedirectAttributes attributes){
        try{
            populationService.update(populationDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/populations";
    }

    @RequestMapping(value = "/alive-population/{id}",method = {RequestMethod.PUT, RequestMethod.GET})
    public String alivePopulation(@PathVariable("id")Long id){
        try {
            populationService.alive(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/populations";
    }

    @RequestMapping(value = "/dead-population/{id}",method = {RequestMethod.PUT, RequestMethod.GET})
    public String deadPopulation(@PathVariable("id")Long id){
        try {
            populationService.dead(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/populations";
    }

}
