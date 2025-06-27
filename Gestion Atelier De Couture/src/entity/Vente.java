package entity;

import services.Sys;

public class Vente extends Operation {

    private static int nbV;
    private Client client;

    public Vente() {
        super();
        nbV++;
        this.article = new ArticleVente();
        this.id = "V-" + nbV;
        this.nature = "Vente";
    }

    public static int getNbV() {
        return nbV;
    }

    public static void setNbV(int nbV) {
        Vente.nbV = nbV;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString() {
        return "\n---------------------------------------\n" +
                "ID                  : " + id + "\n" +
                "ID du client        : " + client.getId() + "\n" +
                "Telephone du client : " + client.getTelephone() + "\n" +
                "Nom Article         : " + Sys.capitalize(article.getNomArticle()) + "\n" +
                "Prix                : " + article.getPrix() + " Fcfa" + "\n" +
                "Quantite            : " + article.getQuantite() + "\n" +
                "Montant             : " + article.getMontant() + " Fcfa" + "\n" +
                "Nature              : " + nature + "\n"+
                "Date                : " + date;
    }

}
