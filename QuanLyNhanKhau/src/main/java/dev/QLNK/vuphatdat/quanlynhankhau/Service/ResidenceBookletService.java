package dev.QLNK.vuphatdat.quanlynhankhau.Service;

import dev.QLNK.Entity.ResidenceBooklet;

import java.util.List;

public interface ResidenceBookletService {
    List<ResidenceBooklet> getAllResidenecBooklet();
    ResidenceBooklet saveResidenceBooklet(ResidenceBooklet residenceBooklet);

}
