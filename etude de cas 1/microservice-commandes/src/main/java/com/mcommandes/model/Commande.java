package com.mcommandes.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    private Date dateCommande;

    private Integer quantite;

    private Float montant;

    public Commande() {
    }

    public Commande(int id, String description, Date dateCommande, Integer quantite, Float montant) {
        this.id = id;
        this.description = description;
        this.dateCommande = dateCommande;
        this.quantite = quantite;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", Description=" + description +
                ", dateCommande=" + dateCommande +
                ", quantite=" + quantite +
                ", montant=" + montant +
                '}';
    }
}
