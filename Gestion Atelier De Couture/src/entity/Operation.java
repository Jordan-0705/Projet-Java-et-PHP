package entity;

import java.time.LocalDate;

import services.Sys;

public class Operation {

    protected String id;
    protected Article article;
    protected String nature;
    protected String date = Sys.date(LocalDate.now()).toString();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void copy(Operation o) {
        this.article = o.getArticle();
        this.nature = o.getNature();
        this.date = o.getDate();

    }

    public boolean equals(Operation o) {
        return this.article.equals(o.getArticle());
    }

    public String toString() {
        return "\n---------------------------------------\n" +
                "ID          : " + id + "\n" +
                "Nom Article : " + Sys.capitalize(article.getNomArticle()) + "\n" +
                "Prix        : " + article.getPrix() + " Fcfa" + "\n" +
                "Quantite    : " + article.getQuantite() + "\n" +
                "Montant     : " + article.getMontant() + " Fcfa" + "\n" +
                "Nature      : " + nature + "\n"+
                "Date        : " + date;
    }
}
