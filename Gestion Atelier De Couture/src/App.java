import java.util.Scanner;

import entity.Client;
import entity.Fournisseur;
import entity.Production;
import services.ApprovisionnementService;
import services.ArticleConfectionService;
import services.ArticleVenteService;
import services.ClientService;
import services.FournisseurService;
import services.ProductionService;
import services.Sys;
import services.VenteService;
import views.ApprovisionnementVue;
import views.ClientVue;
import views.FournisseurVue;
import views.Menu;
import views.ProductionVue;
import views.VenteVue;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Fournisseur fournisseur;
        Production production;
        Client client;

        int ch;
        int chx;
        
        do {
            ch = Menu.menu();
            switch (ch) {
                case 1:
                    System.out.println("\nResponsable de stock");
                    do {
                        ch = Menu.menuRs();
                        switch (ch) {
                        case 1:
                            System.out.println("\nAjouter un fournisseur\n");
                            fournisseur = FournisseurVue.saisieFournisseur();
                            FournisseurService.addFournisseur(fournisseur);
                            Sys.pause();
                            break;
                        case 2:
                            System.out.println("\nListe des fournisseurs :\n");
                            FournisseurService.afficherFournisseurs();
                            Sys.pause();
                            break;
                        case 3:
                            System.out.println("\nEnregistrer un approvisionnement d'un fournisseur\n");
                            ApprovisionnementVue.enregistrerApprovisionnement();
                            Sys.pause();
                            break;
                        case 4:
                            System.out.println("\nRechercher des approvisionnements\n");
                            do {
                                ch = Menu.menuRechAppro();
                                switch (ch) {
                                    case 1:
                                        System.out.println("\nListe des approvisionnements d'une date\n");
                                        ApprovisionnementVue.afficherApprovisionnementsByDate();
                                        Sys.pause();
                                        break;
                                    case 2:
                                        System.out.println("\nListe des approvisionnements d'un article\n");
                                        ApprovisionnementVue.afficherApprovisionnementsByArticle();
                                        Sys.pause();
                                        break;
                                    case 3:
                                        System.out.println("\nListe des approvisionnements d'un fournisseur\n");
                                        ApprovisionnementVue.afficherApprovisionnementsByFournisseur();
                                        Sys.pause();
                                        break;
                                    case 4:
                                        System.out.println("\nQuitter le menu Recherche approvisionnement");
                                        Sys.pause();
                                        break;
                                    default:
                                        System.out.println("\nChoix invalide, veuillez réessayer.");
                                        Sys.pause();
                                    }
                            } while (ch != 4);
                            break;
                        case 5:
                            System.out.println("\nListe des approvisionnements :\n");
                            ApprovisionnementService.afficherApprovisionnements();
                            Sys.pause();
                            break;
                        case 6:
                            System.out.println("\nListe des articles de confection :\n");
                            ArticleConfectionService.afficherArticles();
                            Sys.pause();
                            break;
                        case 7:
                            System.out.println("\nQuitter le menu Responsable de stock");
                            Sys.pause();
                            break;
                        default:
                            System.out.println("\nChoix invalide, veuillez réessayer.");
                            Sys.pause();
                    }
                    } while (ch != 7);
                    break;
                case 2:
                    System.out.println("\nResponsable de production");
                    do {
                        ch = Menu.menuRp();
                        switch (ch) {
                            case 1:
                                System.out.println("\nEnregistrer une production\n");
                                production = ProductionVue.saisieProduction();
                                ProductionService.addProduction(production);
                                Sys.pause();
                                break;
                            case 2:
                                do {
                                    chx = Menu.menuRechProduction();
                                    switch (chx) {
                                        case 1:
                                            System.out.println("\nListe des productions d'une date\n");
                                            ProductionVue.afficherProductionsByDate();
                                            Sys.pause();
                                            break;
                                        case 2:
                                            System.out.println("\nListe des productions d'un article\n");
                                            ProductionVue.afficherProductionsByArticle();
                                            Sys.pause();
                                            break;
                                        case 3:
                                            System.out.println("\nQuitter le menu Recherche production");
                                            Sys.pause();
                                            break;
                                        default:
                                            System.out.println("\nChoix invalide, veuillez réessayer.");
                                            Sys.pause();
                                    }
                                } while (chx != 3);
                                break;
                            case 3:
                                System.out.println("\nListe des productions :\n");
                                ProductionService.afficherProductions();
                                Sys.pause();
                                break;
                            case 4:
                                System.out.println("\nListe des articles de vente :\n");
                                ArticleVenteService.afficherArticles();
                                Sys.pause();
                                break;
                            case 5:
                                System.out.println("\nQuitter le menu Responsable de production");
                                Sys.pause();
                                break;
                            default:
                                System.out.println("\nChoix invalide, veuillez réessayer.");
                                Sys.pause();
                        }
                    } while (ch != 5);
                    break;
                case 3:
                    System.out.println("\nVendeur");
                    do {
                        ch = Menu.menuV();
                        switch (ch) {
                            case 1:
                                System.out.println("\nAjouter un client\n");
                                client = ClientVue.saisieClient();
                                ClientService.addClient(client);
                                Sys.pause();
                                break;
                            case 2:
                                System.out.println("\nListe les clients :");
                                ClientService.afficherClients();
                                Sys.pause();
                                break;
                            case 3:
                                System.out.println("\nEnregistrer une vente pour un client\n");
                                VenteVue.enregistrerVenteClient();
                                Sys.pause();
                                break;
                            case 4:
                                System.out.println("\nRecherche des ventes\n");
                                do {
                                    chx = Menu.menuRechVente();
                                    switch (chx) {
                                        case 1:
                                            System.out.println("\nListe des ventes d'une date\n");
                                            VenteVue.afficherVentesByDate();
                                            Sys.pause();
                                            break;
                                        case 2:
                                            System.out.println("\nListe des ventes d'un article\n");
                                            VenteVue.afficherVentesByArticle();
                                            Sys.pause();
                                            break;
                                        case 3:
                                            System.out.println("\nListe des ventes d'un client\n");
                                            VenteVue.afficherVentesByClient();
                                            Sys.pause();
                                            break;
                                        case 4:
                                            System.out.println("\nQuitter le menu Recherche vente");
                                            Sys.pause();
                                            break;
                                        default:
                                            System.out.println("\nChoix invalide, veuillez réessayer.");
                                            Sys.pause();
                                    }
                                } while (chx != 4);
                                break;
                            case 5:
                                System.out.println("\nListe des ventes :\n");
                                VenteService.afficherVentes();
                                Sys.pause();
                                break;
                            case 6:
                                System.out.println("\nListe des articles de vente :\n");
                                ArticleVenteService.afficherArticles();
                                Sys.pause();
                                break;
                            case 7:
                                System.out.println("\nQuitter le menu Vendeur");
                                Sys.pause();
                                break;
                            default:
                                System.out.println("\nChoix invalide, veuillez réessayer.");
                                Sys.pause();
                        }
                    } while (ch != 7);
                    break;
                case 4:
                    System.out.println("\nGestionnaire");
                    do {
                        ch = Menu.menuG();
                        switch (ch) {
                            case 1:
                                System.out.println("\nResponsable de stock");
                                do {
                                    ch = Menu.menuRs();
                                    switch (ch) {
                                    case 1:
                                        System.out.println("\nAjouter un fournisseur\n");
                                        fournisseur = FournisseurVue.saisieFournisseur();
                                        FournisseurService.addFournisseur(fournisseur);
                                        Sys.pause();
                                        break;
                                    case 2:
                                        System.out.println("\nListe des fournisseurs :\n");
                                        FournisseurService.afficherFournisseurs();
                                        Sys.pause();
                                        break;
                                    case 3:
                                        System.out.println("\nEnregistrer un approvisionnement d'un fournisseur\n");
                                        ApprovisionnementVue.enregistrerApprovisionnement();
                                        Sys.pause();
                                        break;
                                    case 4:
                                        System.out.println("\nRechercher des approvisionnements\n");
                                        do {
                                            ch = Menu.menuRechAppro();
                                            switch (ch) {
                                                case 1:
                                                    System.out.println("\nListe des approvisionnements d'une date\n");
                                                    ApprovisionnementVue.afficherApprovisionnementsByDate();
                                                    Sys.pause();
                                                    break;
                                                case 2:
                                                    System.out.println("\nListe des approvisionnements d'un article\n");
                                                    ApprovisionnementVue.afficherApprovisionnementsByArticle();
                                                    Sys.pause();
                                                    break;
                                                case 3:
                                                    System.out.println("\nListe des approvisionnements d'un fournisseur\n");
                                                    ApprovisionnementVue.afficherApprovisionnementsByFournisseur();
                                                    Sys.pause();
                                                    break;
                                                case 4:
                                                    System.out.println("\nQuitter le menu Recherche approvisionnement");
                                                    Sys.pause();
                                                    break;
                                                default:
                                                    System.out.println("\nChoix invalide, veuillez réessayer.");
                                                    Sys.pause();
                                                }
                                        } while (ch != 4);
                                        break;
                                    case 5:
                                        System.out.println("\nListe des approvisionnements :\n");
                                        ApprovisionnementService.afficherApprovisionnements();
                                        Sys.pause();
                                        break;
                                    case 6:
                                        System.out.println("\nListe des articles de confection :\n");
                                        ArticleConfectionService.afficherArticles();
                                        Sys.pause();
                                        break;
                                    case 7:
                                        System.out.println("\nQuitter le menu Responsable de stock");
                                        Sys.pause();
                                        break;
                                    default:
                                        System.out.println("\nChoix invalide, veuillez réessayer.");
                                        Sys.pause();
                                }
                                } while (ch != 7);
                                break;
                            case 2:
                                System.out.println("\nResponsable de production");
                                do {
                                    chx = Menu.menuRp();
                                    switch (chx) {
                                        case 1:
                                            System.out.println("\nEnregistrer une production\n");
                                            production = ProductionVue.saisieProduction();
                                            ProductionService.addProduction(production);
                                            Sys.pause();
                                            break;
                                        case 2:
                                            System.out.println("\nListe des productions :\n");
                                            ProductionService.afficherProductions();
                                            Sys.pause();
                                            break;
                                        case 3:
                                            System.out.println("\nListe des articles de vente :\n");
                                            ArticleVenteService.afficherArticles();
                                            Sys.pause();
                                            break;
                                        case 4:
                                            System.out.println("\nQuitter le menu Responsable de production");
                                            Sys.pause();
                                            break;
                                        default:
                                            System.out.println("\nChoix invalide, veuillez réessayer.");
                                            Sys.pause();
                                    }
                                } while (chx != 4);
                                break;
                            case 3:
                                System.out.println("\nVendeur");
                                do {
                                    ch = Menu.menuV();
                                    switch (ch) {
                                        case 1:
                                            System.out.println("\nAjouter un client\n");
                                            client = ClientVue.saisieClient();
                                            ClientService.addClient(client);
                                            Sys.pause();
                                            break;
                                        case 2:
                                            System.out.println("\nListe les clients :");
                                            ClientService.afficherClients();
                                            Sys.pause();
                                            break;
                                        case 3:
                                            System.out.println("\nEnregistrer une vente pour un client\n");
                                            VenteVue.enregistrerVenteClient();
                                            Sys.pause();
                                            break;
                                        case 4:
                                            System.out.println("\nRecherche des ventes\n");
                                            do {
                                                chx = Menu.menuRechVente();
                                                switch (chx) {
                                                    case 1:
                                                        System.out.println("\nListe des ventes d'une date\n");
                                                        VenteVue.afficherVentesByDate();
                                                        Sys.pause();
                                                        break;
                                                    case 2:
                                                        System.out.println("\nListe des ventes d'un article\n");
                                                        VenteVue.afficherVentesByArticle();
                                                        Sys.pause();
                                                        break;
                                                    case 3:
                                                        System.out.println("\nListe des ventes d'un client\n");
                                                        VenteVue.afficherVentesByClient();
                                                        Sys.pause();
                                                        break;
                                                    case 4:
                                                        System.out.println("\nQuitter le menu Recherche vente");
                                                        Sys.pause();
                                                        break;
                                                    default:
                                                        System.out.println("\nChoix invalide, veuillez réessayer.");
                                                        Sys.pause();
                                                }
                                            } while (chx != 4);
                                            break;
                                        case 5:
                                            System.out.println("\nListe des ventes :\n");
                                            VenteService.afficherVentes();
                                            Sys.pause();
                                            break;
                                        case 6:
                                            System.out.println("\nListe des articles de vente :\n");
                                            ArticleVenteService.afficherArticles();
                                            Sys.pause();
                                            break;
                                        case 7:
                                            System.out.println("\nQuitter le menu Vendeur");
                                            Sys.pause();
                                            break;
                                        default:
                                            System.out.println("\nChoix invalide, veuillez réessayer.");
                                            Sys.pause();
                                    }
                                } while (ch != 7);
                                break;
                            case 4:
                                System.out.println("\nQuitter le menu Gestionnaire");
                                Sys.pause();
                                break;
                            default:
                                System.out.println("\nChoix invalide, veuillez réessayer.");
                                Sys.pause();
                        }
                    } while (ch != 4);
                    break;
                case 5:
                    System.out.println("\nQuitter");
                    Sys.pause();
                    break;
                default:
                    System.out.println("\nChoix invalide, veuillez réessayer.");
                    Sys.pause();
            }
        } while (ch != 5);
        scanner.close();
    }
}
