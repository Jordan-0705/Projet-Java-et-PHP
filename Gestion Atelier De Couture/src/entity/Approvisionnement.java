package entity;

import services.Sys;

public class Approvisionnement extends Operation {
    
    private  static int nbAp;
    private Fournisseur fournisseur;

    public Approvisionnement() {
        super();
        nbAp++;
        this.article = new ArticleConfection();  
        this.id = "AP-" + nbAp;
        this.nature = "Approvisionnement";
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String toString() {
        return "\n---------------------------------------\n" +
                "ID                       : " + id + "\n" +
                "ID du fournisseur        : " + fournisseur.getId() + "\n" +
                "Telephone du fournisseur : " + fournisseur.getTelephone() + "\n" +
                "Nom Article              : " + Sys.capitalize(article.getNomArticle()) + "\n" +
                "Prix                     : " + article.getPrix() + " Fcfa" + "\n" +
                "Quantite                 : " + article.getQuantite() + "\n" +
                "Montant                  : " + article.getMontant() + " Fcfa" + "\n" +
                "Nature                   : " + nature + "\n"+
                "Date                     : " + date;
    }
}
