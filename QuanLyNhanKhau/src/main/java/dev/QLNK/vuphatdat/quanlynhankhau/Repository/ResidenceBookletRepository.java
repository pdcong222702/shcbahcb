package dev.QLNK.vuphatdat.quanlynhankhau.Repository;


import dev.QLNK.Entity.ResidenceBooklet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceBookletRepository extends JpaRepository<ResidenceBooklet, String> {
}
