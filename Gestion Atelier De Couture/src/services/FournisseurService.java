package services;

import entity.Fournisseur;
import java.util.ArrayList;

public class FournisseurService {

    public static ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

    public static void addFournisseur(Fournisseur fournisseur) {
        fournisseurs.add(fournisseur);
    }

    public static  void afficherFournisseurs() {
        if(fournisseurs.isEmpty()) {
            System.out.println("Aucun fournisseur enregistré.");
        }else {
            for (Fournisseur fournisseur : fournisseurs) {
                System.out.println(fournisseur);
            }
        }
    }

    public static ArrayList<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public static Fournisseur getFournisseurByTel(String tel) {
        if (fournisseurs.isEmpty()) {
            System.out.println("Aucun fournisseur enregistré.");
            return null;
        }
        for (Fournisseur fournisseur : fournisseurs) {
            if (fournisseur.getTelephone().equals(tel)) {
                return fournisseur;
            }
        }
        return null;
    }
}
