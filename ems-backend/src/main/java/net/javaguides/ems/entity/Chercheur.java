package net.javaguides.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Chercheur")

public class Chercheur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer chno;
    private String chnom;
    private String grade;
    private String statut;
    private Date daterecrut;
    private double salaire;
    private double prime;
    private String email;
    @ManyToOne
    @JoinColumn(name = "labno")
    private Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn(name = "facno")
    private Faculte faculte;



}

