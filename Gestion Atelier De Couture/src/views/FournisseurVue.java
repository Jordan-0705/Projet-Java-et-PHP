package views;

import java.util.Scanner;

import entity.Fournisseur;

public class FournisseurVue extends Vue {

    public static Fournisseur saisieFournisseur(){

        Fournisseur fournisseur = new Fournisseur();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisie des informations du fournisseur :\n");

        fournisseur.setNom(saisieChaine("Saisir le nom du fournisseur : "));
        fournisseur.setPrenom(saisieChaine("Saisir le prenom du fournisseur : "));
        fournisseur.setTelephone(saisieTel("Saisir le numero de telephone du fournisseur : "));
        fournisseur.setFix(saisieFix("Saisir le numero de fixe du fournisseur : "));
        fournisseur.setAdresse(saisieChaine("Saisir l'adresse du fournisseur : "));

        return fournisseur;
    }
}
