package net.javaguides.ems.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Publier {

    @EmbeddedId
    private PublierId id; // This is the composite primary key

    // Relation to Chercheur
    @ManyToOne
    @JoinColumn(name = "chno", insertable = false, updatable = false)
    private Chercheur chercheur;

    // Relation to Publication
    @ManyToOne
    @JoinColumn(name = "pubno", insertable = false, updatable = false)
    private Publication publication;

    private int rang; // The rank of the author (1 for main author, 2 for secondary author, etc.)

    // Getters and Setters
    public PublierId getId() {
        return id;
    }

    public void setId(PublierId id) {
        this.id = id;
    }

    public Chercheur getChercheur() {
        return chercheur;
    }

    public void setChercheur(Chercheur chercheur) {
        this.chercheur = chercheur;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
