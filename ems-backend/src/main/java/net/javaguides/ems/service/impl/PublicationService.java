package net.javaguides.ems.service.impl;

import net.javaguides.ems.entity.Publication;
import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.repository.PublierRepository;
import net.javaguides.ems.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private PublierRepository publierRepository;

    // Récupérer les chercheurs (auteurs) d'une publication
    public List<Publier> getAuthorsByPublication(String pubno) {
        return publierRepository.findByPublication_Pubno(pubno);
    }

    // Récupérer une publication par son ID
    public Publication getPublicationById(String pubno) {
        return publicationRepository.findById(pubno).orElse(null);
    }
}
