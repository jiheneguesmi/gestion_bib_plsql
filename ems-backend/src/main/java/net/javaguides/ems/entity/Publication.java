package net.javaguides.ems.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Publication {

    @Id
    private String pubno; // Clé primaire pour Publication

    private String titre; // Titre de la publication
    private String theme; // Thème de la recherche
    private String type; // Type de publication (AS, PC, etc.)
    private int volume; // Volume (nombre de pages)
    private Date date; // Date de publication
    private String apparition; // Apparition (nom de la conférence, colloque, etc.)
    private String editeur; // Nom de l'éditeur

    // Getters et Setters

    public String getPubno() {
        return pubno;
    }

    public void setPubno(String pubno) {
        this.pubno = pubno;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApparition() {
        return apparition;
    }

    public void setApparition(String apparition) {
        this.apparition = apparition;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
}
