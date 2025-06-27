<?php
require_once __DIR__ . '/../repository/FournisseurRepository.php';

class FournisseurService {
    private FournisseurRepository $repo;

    public function __construct() {
        $this->repo = new FournisseurRepository();
    }

    public function addFournisseur(Fournisseur $fournisseur): bool {
        return $this->repo->save($fournisseur);
    }

    public function getAllFournisseurs(): array {
        return $this->repo->findAll();
    }

}
