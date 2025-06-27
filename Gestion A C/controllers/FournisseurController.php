<?php

require_once '../service/FournisseurService.php';

$service = new FournisseurService();

$fournisseurs = $service->getAllFournisseurs(); // ⚠️ variable bien définie

require_once '../views/fournisseurs.html.php';

require_once '../repository/FournisseurRepository.php';

class FournisseurController {

    public function list() {
        $repo = new FournisseurRepository();
        $fournisseurs = $repo->findAll();
        require 'views/fournisseurs.html.php';
    }

    public function add() {
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $nom = trim($_POST['nom']);
        $prenom = trim($_POST['prenom']);
        $telephone = trim($_POST['telephone']);
        $fix = trim($_POST['fix']);
        $adresse = trim($_POST['adresse']);

        // Simple validation
        if (!$nom || !$prenom || !$telephone || !$adresse) {
            $error = "Veuillez remplir tous les champs obligatoires.";
            require 'views/fournisseur_add.html.php';
            return;
        }

        $fournisseur = new Fournisseur();
        $fournisseur->setNom($nom);
        $fournisseur->setPrenom($prenom);
        $fournisseur->setTelephone($telephone);
        $fournisseur->setFix($fix);
        $fournisseur->setAdresse($adresse);

        $repo = new FournisseurRepository();
        $repo->save($fournisseur);

        header('Location: index.php?page=fournisseurs&action=list');
        exit;
    } else {
        require 'views/fournisseur_add.html.php';
    }
}
}
