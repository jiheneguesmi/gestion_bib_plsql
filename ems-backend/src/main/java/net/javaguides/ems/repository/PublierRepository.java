package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Publier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublierRepository extends JpaRepository<Publier, Long> {

    List<Publier> findByChercheur_Chno(Integer chno);

    List<Publier> findByPublication_Pubno(Long pubno);
}
