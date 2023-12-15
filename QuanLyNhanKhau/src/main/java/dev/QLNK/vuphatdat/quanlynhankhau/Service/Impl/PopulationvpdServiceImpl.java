package dev.QLNK.vuphatdat.quanlynhankhau.Service.Impl;

import dev.QLNK.Entity.Population;
import dev.QLNK.vuphatdat.quanlynhankhau.Repository.PopulationRepository;
import dev.QLNK.vuphatdat.quanlynhankhau.Service.PopulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class PopulationvpdServiceImpl implements PopulationService {
    private final PopulationRepository populationRepository;

    @Override
    public ArrayList<Population> getAllPopulations() {
        return (ArrayList<Population>) populationRepository.findAll();
    }

    @Override
    public Population savePopulation(Population population) {
        return this.populationRepository.save(population);
    }
}
