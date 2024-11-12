package net.javaguides.ems.controller;

import net.javaguides.ems.entity.Chercheur;
// Assurez-vous d'importer la classe
import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.service.impl.ChercheurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chercheurs")
public class ChercheurController {

    @Autowired
    private ChercheurService chercheurService;

    // Récupérer les publications d'un chercheur
    @GetMapping("/{chno}/publications")
    public List<Publier> getPublicationsByChercheur(@PathVariable Integer chno) {
        return chercheurService.getPublicationsByChercheur(chno);
    }

    // Récupérer les chercheurs dans un laboratoire
    @GetMapping("/laboratoire/{labno}/chercheurs")
    public List<Chercheur> getResearchersInLaboratory(@PathVariable Long labno) {
        return chercheurService.getResearchersInLaboratory(labno);
    }
}
