package views;

import java.util.Scanner;

import entity.ArticleVente;
import entity.Client;
import entity.Vente;
import services.ArticleVenteService;
import services.ClientService;
import services.Sys;
import services.Test;
import services.VenteService;

public class VenteVue extends Vue {
    
    public static Vente saisieVente() {

        String nom;
        double prix;
        int quantite;

        Vente vente = new Vente();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisie des informations de la vente :\n");

        vente.getArticle().setNomArticle(saisieChaine("Entrez le nom de l'article à vendre : "));
        nom = vente.getArticle().getNomArticle();
        vente.getArticle().setPrix(saisieDouble("Entrez le prix de l'article à vendre : "));
        prix = vente.getArticle().getPrix();
        vente.getArticle().setQuantite(saisieEntier("Entrez la quantité de l'article à vendre : "));
        quantite = vente.getArticle().getQuantite();

        vente.getArticle().setMontant(vente.getArticle().getPrix() * vente.getArticle().getQuantite());

        int vendu = ArticleVenteService.majArticleVenteMoins(nom, prix, quantite);
        if (vendu == 1) {           
            VenteService.addVente(vente);
            ArticleVente.addVente(vente);
        }else{
            Vente.setNbV(Vente.getNbV() - 1);
        }

        return vente;
    }

    public static void enregistrerVenteClient() {
        Client client;
        String mot;
        Vente vente;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le téléphone du client : ");
        mot = scanner.nextLine();
        client = ClientService.getClientByTel(mot);
        if (client != null) {
            System.out.println("Client trouvé : " + Sys.capitalize(client.getPrenom()) + " " + Sys.capitalize(client.getNom() + " (" + client.getTelephone() + ")"));
                vente = VenteVue.saisieVente();
                vente.setClient(client);
                for (Client cli : ClientService.getClients()) {
                    if (cli.equals(client)) {
                        cli.addVente(vente);
                    }
                }
            } else {
            System.out.println("Aucun client trouvé avec ce téléphone.");
        }
    }

    public static void afficherVentesByClient(){
        Client client;
        String mot;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le téléphone du client : ");
        mot = scanner.nextLine();
        client = ClientService.getClientByTel(mot);
        if (client != null) {
            System.out.println("Client trouvé : ");
            for (Client cli : ClientService.getClients()) {
                if (cli.equals(client)) {
                    if (cli.getVentes().isEmpty()) {
                        System.out.println("Aucune vente enregistrée pour ce client.");
                    } else {
                        System.out.println("Ventes faites à " + cli.getNom() + " :");
                        for (Vente v : cli.getVentes()) {
                        System.out.println(v);
                        }
                    }
                                            
                }
            }
        } else {
            System.out.println("Aucun client trouvé avec ce téléphone.");
        }
    }

    public static void afficherVentesByDate() {
        String date;
        int j, m, a;
        Vente vente;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez la date de la vente (JJ-MM-AAAA) :");
        j = saisieEntier("Entrez le jour (JJ) : ");
        m = saisieEntier("Entrez le mois (MM) : ");
        a = saisieEntier("Entrez l'année (AAAA) : ");
        date = String.format("%02d-%02d-%04d", j, m, a);

        if (!Test.isDateValide(date)) {
            System.out.println("Date invalide. Veuillez entrer une date au format JJ-MM-AAAA.");
            return;
        }

        vente = VenteService.getVenteByDate(date);
        if (vente != null) {
            System.out.println("Vente trouvée pour la date " + date + " :");
            for (Vente v : VenteService.getVentes()) {
                if (v.getDate().equals(date)) {
                    System.out.println(v);
                }
            }
        } else {
            System.out.println("Aucune vente trouvée pour cette date.");
        }
    }

    public static void afficherVentesByArticle() {
        String mot;
        Vente vente;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de l'article : ");
        mot = scanner.nextLine();

        vente = VenteService.getVenteByArticle(mot);

        if (vente != null) {
            System.out.println("Vente trouvée : " + vente.getArticle().getNomArticle() + " (" + vente.getArticle().getPrix() + " Fcfa)");
            System.out.println("Quantité vendue : " + vente.getArticle().getQuantite());
            System.out.println("Montant total : " + vente.getArticle().getMontant());

            for (Vente v : VenteService.getVentes()) {
                if (v.getArticle().getNomArticle().equalsIgnoreCase(mot)) {
                    System.out.println(v);
                }
            }
        } else {
            System.out.println("Aucune vente trouvée pour cet article.");
        }
    }


}
