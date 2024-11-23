package net.javaguides.ems.service.impl;

import net.javaguides.ems.entity.Publication;
import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.repository.PublierRepository;
import net.javaguides.ems.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private PublierRepository publierRepository;

    // Récupérer les auteurs (chercheurs) liés à une publication
    public List<Publier> getAuthorsByPublication(Long pubno) {
        List<Publier> authors = publierRepository.findByPublication_Pubno(Long.valueOf(pubno));
        if (authors.isEmpty()) {
            throw new IllegalArgumentException("Aucun auteur trouvé pour la publication " + pubno);
        }
        return authors;
    }

    // Récupérer une publication par son ID
    public Publication getPublicationById(Long pubno) {
        Optional<Publication> publication = publicationRepository.findById(pubno);
        return publication.orElseThrow(() ->
                new IllegalArgumentException("Publication non trouvée avec l'ID " + pubno)
        );
    }
}
