package services;

import java.util.ArrayList;

import entity.Approvisionnement;

public class ApprovisionnementService {

    private static ArrayList<Approvisionnement> approvisionnements = new ArrayList<>();

    public static void addApprovisionnement(Approvisionnement approvisionnement) {
        approvisionnements.add(approvisionnement);
    }

    public static void afficherApprovisionnements() {
        if (approvisionnements.isEmpty()) {
            System.out.println("Aucun approvisionnement enregistré.");
        } else {
            for (Approvisionnement approvisionnement : approvisionnements) {
                System.out.println(approvisionnement);
            }
        }
    }

    public static Approvisionnement getApprovisionnementByDate(String date) {
        for (Approvisionnement approvisionnement : approvisionnements) {
            if (approvisionnement.getDate().equals(date)) {
                return approvisionnement;
            }
        }
        return null;
    }

    public static Approvisionnement getApprovisionnementByArticle(String nomArticle) {
        for (Approvisionnement approvisionnement : approvisionnements) {
            if (approvisionnement.getArticle().getNomArticle().equalsIgnoreCase(nomArticle)) {
                return approvisionnement;
            }
        }
        return null;
    }

    public static ArrayList<Approvisionnement> getApprovisionnements(){
        return approvisionnements;
    }

    
}
