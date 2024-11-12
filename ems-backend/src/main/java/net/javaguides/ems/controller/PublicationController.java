package net.javaguides.ems.controller;

import net.javaguides.ems.entity.Publication;

import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.service.impl.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    // Récupérer les auteurs d'une publication
    @GetMapping("/{pubno}/authors")
    public List<Publier> getAuthorsByPublication(@PathVariable String pubno) {
        return publicationService.getAuthorsByPublication(pubno);
    }

    // Récupérer une publication par son ID
    @GetMapping("/{pubno}")
    public Publication getPublicationById(@PathVariable String pubno) {
        return publicationService.getPublicationById(pubno);
    }
}

