package net.javaguides.ems.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PublierId implements Serializable {
    private Long chno; // This will store the ID of the Chercheur
    private String pubno; // This will store the ID of the Publication

    // Default constructor
    public PublierId() {}

    // Constructor with parameters
    public PublierId(Long chno, String pubno) {
        this.chno = chno;
        this.pubno = pubno;
    }

    // Getters and Setters
    public Long getChno() {
        return chno;
    }

    public void setChno(Long chno) {
        this.chno = chno;
    }

    public String getPubno() {
        return pubno;
    }

    public void setPubno(String pubno) {
        this.pubno = pubno;
    }

    // Override equals and hashCode so that JPA knows how to compare two keys
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublierId publierId = (PublierId) o;
        return Objects.equals(chno, publierId.chno) &&
                Objects.equals(pubno, publierId.pubno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chno, pubno);
    }
}
