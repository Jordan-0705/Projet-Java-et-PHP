package entity;

import java.util.ArrayList;

import services.Sys;

public class Client extends Personne {

    private static int nbCl;
    private ArrayList<Vente> ventes = new ArrayList<>();

    public Client() {
        super();
        nbCl++;
        this.id = "CL-" + nbCl;
    }

    public ArrayList<Vente> getVentes() {
        return ventes;
    }
    
    public void addVente(Vente vente) {
        this.ventes.add(vente);
    }

    public String toString(){
        return "\n---------------------------------------\n" +
                "ID        : " + id + "\n" +
                "Nom       : " + Sys.capitalize(nom) + "\n" +
                "Prenom    : " + Sys.capitalize(prenom) + "\n" +
                "Telephone : " + telephone + "\n" +
                "Adresse   : " + Sys.capitalize(adresse);
    }

}
