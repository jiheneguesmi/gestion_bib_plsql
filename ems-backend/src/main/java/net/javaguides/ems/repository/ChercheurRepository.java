package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChercheurRepository extends JpaRepository<Chercheur, Long> {

    List<Chercheur> findByLaboratoire_Labno(Long labno);
}
