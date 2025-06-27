package services;

import java.util.ArrayList;

import entity.Vente;

public class VenteService {
    
    private static ArrayList<Vente> ventes = new ArrayList<>();

    public static void addVente(Vente vente) {
        ventes.add(vente);
    }

    public static void afficherVentes() {
        if (ventes.isEmpty()) {
            System.out.println("Aucune vente enregistrée.");
        } else {
            for (Vente vente : ventes) {
                System.out.println(vente);
            }
        }
    }

    public static ArrayList<Vente> getVentes() {
        return ventes;
    }

    public static Vente getVenteByDate(String date) {
        for (Vente vente : ventes) {
            if (vente.getDate().equals(date)) {
                return vente;
            }
        }
        return null;
    }

     public static Vente getVenteByArticle(String nomArticle) {
        for (Vente vente : ventes) {
            if (vente.getArticle().getNomArticle().equalsIgnoreCase(nomArticle)) {
                return vente;
            }
        }
        return null;
    }

}
