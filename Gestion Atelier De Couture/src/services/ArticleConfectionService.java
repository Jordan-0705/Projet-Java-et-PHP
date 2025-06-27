package services;

import java.util.ArrayList;

import entity.ArticleConfection;

public class ArticleConfectionService {

    private static ArrayList<ArticleConfection> articleConfections = new ArrayList<>();

    public static ArrayList<ArticleConfection> getArticleConfections() {
        return articleConfections;
    }

    public static void addArticle(ArticleConfection article) {
        articleConfections.add(article);
    }

    public static void afficherArticles() {
        if (articleConfections.isEmpty()) {
            System.out.println("Aucun article enregistré.");
        } else {
            for (ArticleConfection article : articleConfections) {
                System.out.println(article);
            }
        }
    }    

    public static void majArticleConfection(String nom, double prix, int quantite) {
        boolean existe = false;
        for(ArticleConfection ac : articleConfections){
            if(ac.getNomArticle().toLowerCase().equals(nom.toLowerCase()) && ac.getPrix() == prix) {
                System.out.println("Cet article existe déjà dans le stock.");
                ac.setQuantite(ac.getQuantite() + quantite);
                ac.setMontant(ac.getMontant() + (prix * quantite));
                existe = true;
                break;
            }
        }
        if (!existe) {
            ArticleConfection articleConfection = new ArticleConfection(nom, prix, quantite);
            addArticle(articleConfection);
            System.out.println("Nouvel article ajouté au stock.");
        }
    }
}
