package dev.QLNK.vuphatdat.quanlynhankhau.Service.Impl;


import dev.QLNK.Entity.ResidenceBooklet;
import dev.QLNK.vuphatdat.quanlynhankhau.Repository.ResidenceBookletRepository;
import dev.QLNK.vuphatdat.quanlynhankhau.Service.ResidenceBookletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidenceBookletServiceImpl implements ResidenceBookletService {
    private final ResidenceBookletRepository residenceBookletRepository;


    @Override
    public List<ResidenceBooklet> getAllResidenecBooklet() {
        return residenceBookletRepository.findAll();
    }

    @Override
    public ResidenceBooklet saveResidenceBooklet(ResidenceBooklet residenceBooklet) {
        return this.residenceBookletRepository.save(residenceBooklet);
    }
}
