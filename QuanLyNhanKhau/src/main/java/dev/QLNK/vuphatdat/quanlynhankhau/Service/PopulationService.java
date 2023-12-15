package dev.QLNK.vuphatdat.quanlynhankhau.Service;

import dev.QLNK.Entity.Population;

import java.util.ArrayList;

public interface PopulationService {
    ArrayList<Population> getAllPopulations();
    Population savePopulation(Population population);
}
