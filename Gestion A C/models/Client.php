<?php
require_once 'Personne.php';
require_once 'Vente.php';
require_once 'Sys.php';

class Client extends Personne {
    private static int $nbCl = 0;
    private array $ventes = [];

    public function __construct() {
        parent::__construct();
        self::$nbCl++;
        $this->id = "CL-" . self::$nbCl;
    }

    public function getVentes(): array {
        return $this->ventes;
    }

    public function addVente(Vente $vente): void {
        $this->ventes[] = $vente;
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID        : " . $this->id . "\n" .
            "Nom       : " . Sys::capitalize($this->nom) . "\n" .
            "Prenom    : " . Sys::capitalize($this->prenom) . "\n" .
            "Telephone : " . $this->telephone . "\n" .
            "Adresse   : " . Sys::capitalize($this->adresse);
    }
}
