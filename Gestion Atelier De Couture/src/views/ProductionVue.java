package views;

import java.util.Scanner;

import entity.ArticleVente;
import entity.Production;
import services.ArticleVenteService;
import services.ProductionService;
import services.Test;

public class ProductionVue extends Vue {
    
    public static Production saisieProduction() {

        String nom;
        double prix;
        int quantite;

        Production production = new Production();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Saisie des informations de la production :\n");

        production.getArticle().setNomArticle(saisieChaine("Entrez le nom de l'article à enregistrer : "));
        nom= production.getArticle().getNomArticle();
        production.getArticle().setPrix(saisieDouble("Entrez le prix de l'article à enregistrer : "));
        prix = production.getArticle().getPrix();
        production.getArticle().setQuantite(saisieEntier("Entrez la quantité de l'article à enregistrer : "));
        quantite = production.getArticle().getQuantite();

        production.getArticle().setMontant(production.getArticle().getPrix() * production.getArticle().getQuantite());

        ArticleVente.addProduction(production);

        ArticleVenteService.majArticleVentePlus(nom, prix, quantite);
    
        return production;
    }

    public static void afficherProductionsByDate() {
        String date;
        int j, m, a;
        Production production;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de la production (JJ-MM-AAAA) :");
        j = saisieEntier("Entrez le jour (JJ) : ");
        m = saisieEntier("Entrez le mois (MM) : ");
        a = saisieEntier("Entrez l'année (AAAA) : ");
        date = String.format("%02d-%02d-%04d", j, m, a);

        if (!Test.isDateValide(date)) {
            System.out.println("Date invalide. Veuillez entrer une date au format JJ-MM-AAAA.");
            return;
        }

        production = ProductionService.getProductionByDate(date);
        if (production != null) {
            System.out.println("Production trouvée pour la date " + date + " :");
            for (Production p : ProductionService.getProductions()) {
                if (p.getDate().equals(date)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Aucune production trouvée pour cette date.");
        }
    }

    public static void afficherProductionsByArticle() {
        String mot;
        Production production;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nListe des productions d'un article\n");
        System.out.print("Entrez le nom de l'article : ");
        mot = scanner.nextLine();

        production = ProductionService.getProductionByArticle(mot);

        if (production != null) {
            System.out.println("Production trouvée : " + production.getArticle().getNomArticle() +
                    " (" + production.getArticle().getPrix() + " Fcfa)");
            System.out.println("Quantité produite : " + production.getArticle().getQuantite());
            System.out.println("Montant total : " + production.getArticle().getMontant());

            for (Production p : ProductionService.getProductions()) {
                if (p.getArticle().getNomArticle().equalsIgnoreCase(mot)) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("Aucune production trouvée pour cet article.");
        }
    }

}
