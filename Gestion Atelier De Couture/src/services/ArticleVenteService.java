package services;

import java.util.ArrayList;

import entity.ArticleVente;

public class ArticleVenteService {
    
    private static ArrayList<ArticleVente> articleVentes = new ArrayList<>();

    public static ArrayList<ArticleVente> getArticleVentes() {
        return articleVentes;
    }

    public static void addArticle(ArticleVente article) {
        articleVentes.add(article);
    }

    public static void afficherArticles() {
        if (articleVentes.isEmpty()) {
            System.out.println("Aucun article de vente enregistré.");
        } else {
            for (ArticleVente article : articleVentes) {
                System.out.println(article);
            }
        }
    }

    public static void majArticleVentePlus(String nom, double prix, int quantite) {
        boolean existe = false;
        for (ArticleVente v : articleVentes) {
            if (v.getNomArticle().toLowerCase().equals(nom.toLowerCase()) && v.getPrix() == prix) {
                System.out.println("Cet article existe déjà dans la production.");
                v.setQuantite(v.getQuantite() + quantite);
                v.setMontant(v.getMontant() + (prix * quantite));
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            ArticleVente articleVente = new ArticleVente(nom, prix, quantite);
            addArticle(articleVente);
            System.out.println("Nouvel article ajouté à la production.");
        }
    }

    public static int majArticleVenteMoins(String nom, double prix, int quantite){
        int vendu = 0;
        for (ArticleVente v : articleVentes) {
            if (v.getNomArticle().toLowerCase().equals(nom.toLowerCase()) && v.getPrix() == prix) {
                if (v.getQuantite() >= quantite) {
                    v.setQuantite(v.getQuantite() - quantite);
                    v.setMontant(v.getMontant() - (prix * quantite));
                    System.out.println("Cette vente a été effectuée avec succès.");
                    vendu = 1;
                    break;
                } else {
                    System.out.println("Quantité en stock de " + Sys.capitalize(nom) + " insuffisante pour cette vente.");
                    vendu = 2;
                    break;
                }
                
            }
        }
        
        if (vendu == 0) {
            System.out.println("Aucun article de vente trouvé dans le stock avec ce nom et ce prix.");
        }
        return vendu;
    }

}
