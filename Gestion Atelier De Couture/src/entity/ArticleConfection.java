package entity;

import java.util.ArrayList;

public class ArticleConfection extends Article {

    private static int nbAc;
    private static ArrayList<Approvisionnement> approvisionnements = new ArrayList<>();

    public ArticleConfection(String nomArticle, double prix, int quantite) {
        nbAc++;
        this.id = "AC-" + nbAc;
        this.nomArticle = nomArticle;
        this.prix = prix;
        this.quantiteStock = quantite;
        this.montantStock = prix * quantite;
        this.type = "Article Confection";
    }

    public ArticleConfection() {
        super();    
    }
    
    public static ArrayList<Approvisionnement> getApprovisionnements() {
        return approvisionnements;
    }

    public static void addApprovisionnement(Approvisionnement approvisionnement) {
        approvisionnements.add(approvisionnement);
    }

}
