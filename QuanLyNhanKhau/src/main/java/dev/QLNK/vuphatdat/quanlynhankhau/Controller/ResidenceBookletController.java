package dev.QLNK.vuphatdat.quanlynhankhau.Controller;


import dev.QLNK.Entity.ResidenceBooklet;
import dev.QLNK.vuphatdat.quanlynhankhau.Service.PopulationService;
import dev.QLNK.vuphatdat.quanlynhankhau.Service.ResidenceBookletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ResidenceBookletController {

    private final ResidenceBookletService residenceBookletService;
    private final PopulationService populationService;


    @GetMapping("/home")
    public String createResidenceBooklet(Model model){
        model.addAttribute("residence_booklet" , new ResidenceBooklet());

        return "house-hold";
    }

    @PostMapping("/save_residence_booklet")
    public String saveResidenceBooklet(@ModelAttribute ResidenceBooklet residenceBooklet

    ){
         residenceBookletService.saveResidenceBooklet(residenceBooklet);
         return "house-hold";
    }


}
