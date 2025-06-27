package views;

import java.util.Scanner;

import entity.Approvisionnement;
import entity.ArticleConfection;
import entity.Fournisseur;
import services.ApprovisionnementService;
import services.ArticleConfectionService;
import services.FournisseurService;
import services.Sys;
import services.Test;

public class ApprovisionnementVue extends Vue {
    
    public static Approvisionnement saisieApprovisionnement() {

        String nom;
        double prix;
        int quantite;

        Approvisionnement approvisionnement = new Approvisionnement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisie des informations de l'approvisionnement :\n");

        approvisionnement.getArticle().setNomArticle(saisieChaine("Entrez le nom de l'article à approvisionner : "));
        nom= approvisionnement.getArticle().getNomArticle();
        approvisionnement.getArticle().setPrix(saisieDouble("Entrez le prix de l'article à approvisionner : "));
        prix = approvisionnement.getArticle().getPrix();
        approvisionnement.getArticle().setQuantite(saisieEntier("Entrez la quantité de l'article à approvisionner : "));
        quantite = approvisionnement.getArticle().getQuantite();

        approvisionnement.getArticle().setMontant(approvisionnement.getArticle().getPrix() * approvisionnement.getArticle().getQuantite());

        ArticleConfection.addApprovisionnement(approvisionnement);

        ArticleConfectionService.majArticleConfection(nom, prix, quantite);

        return approvisionnement;
    }

    public static void enregistrerApprovisionnement() {
        Fournisseur fournisseur;
        Approvisionnement approvisionnement;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le téléphone du fournisseur : ");
        String tel = scanner.nextLine();
        fournisseur = FournisseurService.getFournisseurByTel(tel);
        if (fournisseur != null) {
            System.out.println("Fournisseur trouvé : " + fournisseur.getPrenom() + " " + fournisseur.getNom() + " (" + fournisseur.getTelephone() + ")");                               
            approvisionnement = ApprovisionnementVue.saisieApprovisionnement();
            approvisionnement.setFournisseur(fournisseur);
            ApprovisionnementService.addApprovisionnement(approvisionnement);
            for (Fournisseur four : FournisseurService.getFournisseurs()) {
                if (four.equals(fournisseur)) {
                    four.addApprovisionnement(approvisionnement);
                }
            }
        } else {
            System.out.println("Aucun fournisseur trouvé avec ce téléphone.");
        }
    }

    public static void afficherApprovisionnementsByArticle() {
        String mot;
        Approvisionnement approvisionnement;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nListe des approvisionnements d'un article\n");
        System.out.print("Entrez le nom de l'article : ");
        mot = scanner.nextLine();
        approvisionnement = ApprovisionnementService.getApprovisionnementByArticle(mot);
        if (approvisionnement != null) {
            System.out.println("Approvisionnement trouvé : " + approvisionnement.getArticle().getNomArticle() + " (" + approvisionnement.getArticle().getPrix() + " Fcfa)");
            System.out.println("Quantité : " + approvisionnement.getArticle().getQuantite());
            System.out.println("Montant : " + approvisionnement.getArticle().getMontant());
            for (Approvisionnement app : ApprovisionnementService.getApprovisionnements()) {
                if (app.getArticle().getNomArticle().equalsIgnoreCase(mot)) {
                    System.out.println(app);
                }
            }
        } else {
            System.out.println("Aucun approvisionnement trouvé pour cet article.");
        }
    }

    public static void afficherApprovisionnementsByFournisseur() {
        String mot;
        Fournisseur fournisseur;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le téléphone du fournisseur : ");
        mot = scanner.nextLine();
        fournisseur = FournisseurService.getFournisseurByTel(mot);
        if (fournisseur != null) {
            System.out.println("Fournisseur trouvé : " + Sys.capitalize(fournisseur.getPrenom()) + " " + Sys.capitalize(fournisseur.getNom()) + " (" + fournisseur.getTelephone() + ")");
            for (Fournisseur four : FournisseurService.getFournisseurs()) {
                if (four.equals(fournisseur)) {
                    for (Approvisionnement app : four.getApprovisionnements()) {
                        System.out.println(app);
                    }
                }
            }
        } else {
        System.out.println("Aucun fournisseur trouvé avec ce téléphone.");
        }
    }

    public static void afficherApprovisionnementsByDate() {
        String date;
        int j,m,a;
        Approvisionnement approvisionnement;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de l'approvisionnement (JJ-MM-AAAA) :");
        j = saisieEntier("Entrez le jour (JJ) : ");
        m = saisieEntier("Entrez le mois (MM) : ");
        a = saisieEntier("Entrez l'année (AAAA) : ");
        date = String.format("%02d-%02d-%04d", j, m, a);
        if (!Test.isDateValide(date)) {
            System.out.println("Date invalide. Veuillez entrer une date au format JJ-MM-AAAA.");
            return;
        }
        approvisionnement = ApprovisionnementService.getApprovisionnementByDate(date);
        if (approvisionnement != null) {
            System.out.println("Approvisionnement trouvé pour la date " + date + " :");
            for (Approvisionnement app : ApprovisionnementService.getApprovisionnements()) {
                if (app.getDate().equals(date)) {
                    System.out.println(app);
                }
            }
        } else {
            System.out.println("Aucun approvisionnement trouvé pour cette date.");
        }
    }
}
