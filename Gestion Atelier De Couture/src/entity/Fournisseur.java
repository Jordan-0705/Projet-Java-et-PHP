package entity;

import java.util.ArrayList;

import services.Sys;

public class Fournisseur extends Personne {

    private String fix;
    private static int nbF;
    private ArrayList<Approvisionnement> approvisionnements = new ArrayList<>();

    public Fournisseur() {
        super();
        nbF++;
        this.id = "F-" + nbF;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getFix() {
        return fix;
    }

    public ArrayList<Approvisionnement> getApprovisionnements() {
        return approvisionnements;
    }

    public void addApprovisionnement(Approvisionnement approvisionnement) {
        this.approvisionnements.add(approvisionnement);
    }
 
    public String toString(){
        return "\n---------------------------------------\n" +
                "ID        : " + id + "\n" +
                "Nom       : " + Sys.capitalize(nom) + "\n" +
                "Prenom    : " + Sys.capitalize(prenom) + "\n" +
                "Telephone : " + telephone + "\n" +
                "Fix       : " + fix + "\n" +
                "Adresse   : " + Sys.capitalize(adresse);
    }
}
