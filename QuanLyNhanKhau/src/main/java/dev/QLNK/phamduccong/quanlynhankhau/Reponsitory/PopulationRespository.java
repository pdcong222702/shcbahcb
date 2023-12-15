package dev.QLNK.phamduccong.quanlynhankhau.Reponsitory;

import dev.QLNK.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PopulationRespository extends JpaRepository<Population,Long> {
    @Query("update Population p " +
            "set p.populationName=?1 where p.id=?2")
    Population eitPopulationById(String name,Long id);

}
