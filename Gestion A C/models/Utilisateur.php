<?php
require_once 'Personne.php';

class Utilisateur extends Personne {
    protected float $salaire;

    public function getSalaire(): float {
        return $this->salaire;
    }

    public function setSalaire(float $salaire): void {
        $this->salaire = $salaire;
    }
}
