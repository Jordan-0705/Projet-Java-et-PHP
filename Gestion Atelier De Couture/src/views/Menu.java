package views;

import java.util.Scanner;

import services.Test;
import services.Sys;

public class Menu {
    public static int menu() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Menu Principal =========\n");
            System.out.println("1 - Responsable de stock");
            System.out.println("2 - Responsable de production");
            System.out.println("3 - Vendeur");
            System.out.println("4 - Gestionnaire");
            System.out.println("5 - Quitter\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 5);
        return Integer.parseInt(mot);
    }

    public static int menuRs() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Menu Responsable de stock =========\n");
            System.out.println("1 - Ajouter un fournisseur");
            System.out.println("2 - Lister les fournisseurs");
            System.out.println("3 - Enregistrer un approvisionnement d'un fournisseur");
            System.out.println("4 - Rechercher des approvisionnements");
            System.out.println("5 - Lister les approvisionnements");
            System.out.println("6 - Lister les articles de confection");
            System.out.println("7 - Quitter\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 7);
        return Integer.parseInt(mot);
    }

    public static int menuRp() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Menu Responsable de production =========\n");
            System.out.println("1 - Enregistrer une production");
            System.out.println("2 - Rechercher des productions");
            System.out.println("3 - Lister les productions");
            System.out.println("4 - Lister les articles de vente");
            System.out.println("5 - Quitter\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 5);
        return Integer.parseInt(mot);
    }

    public static int menuV() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Menu Vendeur =========\n");
            System.out.println("1 - Ajouter un client");
            System.out.println("2 - Lister les clients");
            System.out.println("3 - Enregistrer une vente pour un client");
            System.out.println("4 - Rechercher des ventes");
            System.out.println("5 - Lister les ventes");
            System.out.println("6 - Lister les articles de vente");
            System.out.println("7 - Quitter\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 7);
        return Integer.parseInt(mot);
    }

    public static int menuG() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Menu Gestionnaire =========\n");
            System.out.println("1 - Partie Stock");
            System.out.println("2 - Partie Production");
            System.out.println("3 - Partie Vente");
            System.out.println("4 - Quitter\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 5);
        return Integer.parseInt(mot);
    }

    public static int menuRechAppro() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Recherche approvisionnement =========\n");
            System.out.println("1 - Lister les approvisionnements d'une date");
            System.out.println("2 - Lister les approvisionnements d'un article de confection");
            System.out.println("3 - Lister les approvisionnements d'un fournisseur");
            System.out.println("4 - Retourner au menu Responsable de stock\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 4);
        return Integer.parseInt(mot);
    }

    public static int menuRechVente() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Recherche vente =========\n");
            System.out.println("1 - Lister les ventes d'une date");
            System.out.println("2 - Lister les ventes d'un article de vente");
            System.out.println("3 - Lister les ventes faites à un client");
            System.out.println("4 - Retourner au menu Responsable de stock\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 4);
        return Integer.parseInt(mot);
    } 

    public static int menuRechProduction() {
        String mot;
        Scanner scanner = new Scanner(System.in);
        do {
            Sys.cls();
            System.out.println("========= Recherche production =========\n");
            System.out.println("1 - Lister les productions d'une date");
            System.out.println("2 - Lister les productions d'un article de vente");
            System.out.println("3 - Retourner au menu Responsable de production\n");
            System.out.print("Veuillez faire votre choix : ");
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot) || Integer.parseInt(mot) < 1 || Integer.parseInt(mot) > 3);
        return Integer.parseInt(mot);
    }

}
