package services;

import java.util.ArrayList;

import entity.Production;

public class ProductionService {
    
    private static ArrayList<Production> productions = new ArrayList<>();

    public static void addProduction(Production production) {
        productions.add(production);
    }

    public static void afficherProductions() {
        if (productions.isEmpty()) {
            System.out.println("Aucune production enregistrée.");
        } else {
            for (Production production : productions) {
                System.out.println(production);
            }
        }
    }

    public static ArrayList<Production> getProductions() {
        return productions;
    }

    public static Production getProductionByDate(String date) {
        for (Production p : productions) {
            if (p.getDate().equals(date)) {
                return p;
            }
        }
        return null;
    }

    public static Production getProductionByArticle(String nomArticle) {
    for (Production p : productions) {
        if (p.getArticle().getNomArticle().equalsIgnoreCase(nomArticle)) {
            return p;
        }
    }
    return null;
}

}
