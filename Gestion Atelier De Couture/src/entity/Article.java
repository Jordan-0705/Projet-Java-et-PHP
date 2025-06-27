package entity;

import services.Sys;

public class Article {

    protected String id;
    protected String nomArticle;
    protected double prix;
    protected int quantiteStock;
    protected double montantStock;
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantiteStock;
    }

    public void setQuantite(int quantite) {
        this.quantiteStock = quantite;
    }

    public double getMontant() {
        return montantStock;
    }

    public void setMontant(double montant) {
        this.montantStock = montant;
    }
    public void copy(Article a) {
        this.id = a.getId();
        this.nomArticle = a.getNomArticle();
        this.prix = a.getPrix();
        this.quantiteStock = a.getQuantite();
        this.montantStock = a.getMontant();
        this.type = a.getType();
    }

    public boolean equals(Article a) {
        return this.nomArticle.equals(a.getNomArticle()) && 
               this.prix == a.getPrix();
    }

    public String toString() {
        return "\n---------------------------------------\n" +
                "ID          : " + id + "\n" +
                "Nom Article : " + Sys.capitalize(nomArticle) + "\n" +
                "Prix        : " + prix + " Fcfa" +"\n" +
                "Quantite    : " + quantiteStock + "\n" +
                "Montant     : " + montantStock + " Fcfa" + "\n" +
                "Type        : " + type;
    }
    
}
