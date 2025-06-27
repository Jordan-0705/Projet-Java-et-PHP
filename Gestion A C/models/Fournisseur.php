<?php
require_once 'Personne.php';
require_once 'Approvisionnement.php';
require_once 'Sys.php';

class Fournisseur extends Personne {
    private static int $nbF = 0;
    private string $fix;
    private array $approvisionnements = [];

    public function __construct() {
        parent::__construct();
        self::$nbF++;
        $this->id = "F-" . self::$nbF;
    }

    public function getFix(): string {
        return $this->fix;
    }

    public function setFix(string $fix): void {
        $this->fix = $fix;
    }

    public function getApprovisionnements(): array {
        return $this->approvisionnements;
    }

    public function addApprovisionnement(Approvisionnement $approvisionnement): void {
        $this->approvisionnements[] = $approvisionnement;
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID        : " . $this->id . "\n" .
            "Nom       : " . Sys::capitalize($this->nom) . "\n" .
            "Prenom    : " . Sys::capitalize($this->prenom) . "\n" .
            "Telephone : " . $this->telephone . "\n" .
            "Fix       : " . $this->fix . "\n" .
            "Adresse   : " . Sys::capitalize($this->adresse);
    }
}
