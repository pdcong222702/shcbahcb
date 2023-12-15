package dev.QLNK.vuphatdat.quanlynhankhau.Repository;

import dev.QLNK.Entity.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationRepository  extends JpaRepository<Population,String> {
}
