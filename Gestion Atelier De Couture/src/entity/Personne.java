package entity;

import services.Sys;

public class Personne {

    protected String id;
    protected String nom;
    protected String prenom;
    protected String telephone;
    protected String adresse;

    public Personne() {
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void copy(Personne p) {
        this.nom = p.getNom();
        this.prenom = p.getPrenom();
        this.telephone = p.getTelephone();
        this.adresse = p.getAdresse();

    }

    public boolean equals(Personne p) {
        return this.telephone.equals(p.getTelephone());
    }

    public String toString() {
        return "\n---------------------------------------\n" +
                 "Nom       : " + Sys.capitalize(nom) + "\n" +
                 "Prenom    : " + Sys.capitalize(prenom) + "\n" +
                 "Telephone : " + telephone + "\n" +
                 "Adresse   : " + Sys.capitalize(adresse);
    }
    
}
