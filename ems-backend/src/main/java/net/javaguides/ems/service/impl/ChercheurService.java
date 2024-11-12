package net.javaguides.ems.service.impl;

import net.javaguides.ems.entity.Chercheur;
import net.javaguides.ems.entity.Publier;
import net.javaguides.ems.repository.PublierRepository;
import net.javaguides.ems.repository.ChercheurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChercheurService {

    @Autowired
    private ChercheurRepository chercheurRepository;

    @Autowired
    private PublierRepository publierRepository;

    // Récupérer les publications d'un chercheur
    public List<Publier> getPublicationsByChercheur(Integer chno) {
        return publierRepository.findByChercheur_Chno(chno);  // Utilise un repository Publier pour récupérer les publications
    }

    // Récupérer les chercheurs associés à un laboratoire
    public List<Chercheur> getResearchersInLaboratory(Long labno) {
        return chercheurRepository.findByLaboratoire_Labno(labno);  // Récupérer les chercheurs par laboratoire
    }
}
