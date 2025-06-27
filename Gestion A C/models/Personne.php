<?php
require_once 'Sys.php';

class Personne {
    protected string $id;
    protected string $nom;
    protected string $prenom;
    protected string $telephone;
    protected string $adresse;

    public function __construct() {
        // Aucun traitement spécifique
    }

    public function getId(): string {
        return $this->id;
    }

    public function setId(string $id): void {
        $this->id = $id;
    }

    public function getNom(): string {
        return $this->nom;
    }

    public function setNom(string $nom): void {
        $this->nom = $nom;
    }

    public function getPrenom(): string {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): void {
        $this->prenom = $prenom;
    }

    public function getTelephone(): string {
        return $this->telephone;
    }

    public function setTelephone(string $telephone): void {
        $this->telephone = $telephone;
    }

    public function getAdresse(): string {
        return $this->adresse;
    }

    public function setAdresse(string $adresse): void {
        $this->adresse = $adresse;
    }

    public function copy(Personne $p): void {
        $this->nom = $p->getNom();
        $this->prenom = $p->getPrenom();
        $this->telephone = $p->getTelephone();
        $this->adresse = $p->getAdresse();
    }

    public function equals(Personne $p): bool {
        return $this->telephone === $p->getTelephone();
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "Nom       : " . Sys::capitalize($this->nom) . "\n" .
            "Prenom    : " . Sys::capitalize($this->prenom) . "\n" .
            "Telephone : " . $this->telephone . "\n" .
            "Adresse   : " . Sys::capitalize($this->adresse);
    }
}
