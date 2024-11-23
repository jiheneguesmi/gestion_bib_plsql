package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication,Long> {

}
