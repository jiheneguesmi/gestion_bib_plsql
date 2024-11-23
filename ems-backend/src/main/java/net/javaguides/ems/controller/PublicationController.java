package net.javaguides.ems.controller;

import net.javaguides.ems.entity.Publication;
import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.service.impl.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    // Endpoint pour récupérer les auteurs liés à une publication
    @GetMapping("/{pubno}/authors")
    public ResponseEntity<List<Publier>> getAuthorsByPublication(@PathVariable Long pubno) {
        try {
            List<Publier> authors = publicationService.getAuthorsByPublication(pubno);
            return ResponseEntity.ok(authors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Endpoint pour récupérer une publication par son ID
    @GetMapping("/{pubno}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable Long pubno) {
        try {
            Publication publication = publicationService.getPublicationById(pubno);
            return ResponseEntity.ok(publication);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
