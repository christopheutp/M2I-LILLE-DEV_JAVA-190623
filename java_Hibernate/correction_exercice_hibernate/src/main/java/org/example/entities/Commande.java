package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    private double total;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "commande_produit",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits;




    @OneToOne
    private Adresse adresse;
    public Commande() {
        dateCommande = new Date();
        produits = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public double getTotal() {
        double total = 0;
        for(Produit p : getProduits()) {
            total += p.getPrix();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public void ajoutProduit(Produit p){
        this.produits.add(p);
    }
}
