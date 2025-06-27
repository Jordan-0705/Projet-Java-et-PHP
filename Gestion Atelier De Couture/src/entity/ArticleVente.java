package entity;

import java.util.ArrayList;

public class ArticleVente extends Article {

    private static int nbAv;
    private static ArrayList<Production> productions = new ArrayList<>();
    private static ArrayList<Vente> ventes = new ArrayList<>();

    public ArticleVente(String nomArticle, double prix, int quantite) {
        super();
        nbAv++;
        this.id = "AV-" + nbAv;
        this.nomArticle = nomArticle;
        this.prix = prix;
        this.quantiteStock = quantite;
        this.montantStock = prix * quantite;
        this.type = "Article Vente";
    }
    
    public ArticleVente() {
        super();
    }

    public static ArrayList<Production> getProductions() {
        return productions;
    }

    public static void addProduction(Production production) {
        productions.add(production);
    }

    public static ArrayList<Vente> getVentes() {
        return ventes;
    }

    public static void addVente(Vente vente) {
        ventes.add(vente);
    }

}
