package net.javaguides.ems.service.impl;

import net.javaguides.ems.entity.Chercheur;
import net.javaguides.ems.repository.ChercheurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoireService {

    @Autowired
    private ChercheurRepository chercheurRepository;

    // Récupérer les chercheurs d'un laboratoire
    public List<Chercheur> getResearchersInLaboratory(Long labno) {
        return chercheurRepository.findByLaboratoire_Labno(labno);
    }
}
