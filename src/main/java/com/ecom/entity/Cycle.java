package com.ecom.entity;
import  com.ecom.entity.Formateur;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.ecom.entity.InscriptionDetail;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String numSalle;
    private String numAction;
    private String themeFormation;

    private String modeFormation;
    private String lieu;
    private String gouv ;
    private String periodeDebut;
    private String periodeFin;
    private String horaireDebut ;
    private String horaireFin;
    private String pauseDebut ;
    private String pauseFin;
    private boolean droitTirageI;
    private boolean droitTirageC;
    private boolean credit;

    @OneToOne
    private Formateur formateur;
    @OneToOne
    private InscriptionDetail inscriptionDetail ;

    public Cycle() {
        super();

    }

}
