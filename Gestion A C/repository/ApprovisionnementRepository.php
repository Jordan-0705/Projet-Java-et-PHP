<?php

require_once __DIR__ . '/../config/connexion.php';
require_once __DIR__ . '/../models/Approvisionnement.php';

class ApprovisionnementRepository {
    private PDO $pdo;

    public function __construct() {
        $this->pdo = Connexion::getConnexion();
    }

    public function findAll(): array {
        $stmt = $this->pdo->query("SELECT * FROM approvisionnement");
        return $stmt->fetchAll();
    }

    public function save(Approvisionnement $appro): bool {
        $sql = "INSERT INTO approvisionnement (nomArticle, prix, quantite, montant, date, fournisseur_id)
                VALUES (:nomArticle, :prix, :quantite, :montant, :date, :fournisseur_id)";
        
        $stmt = $this->pdo->prepare($sql);

        $result = $stmt->execute([
            'nomArticle' => $appro->getNomArticle(),
            'prix' => $appro->getPrix(),
            'quantite' => $appro->getQuantite(),
            'montant' => $appro->getMontant(),
            'date' => $appro->getDate(),
            'fournisseur_id' => $appro->getFournisseurId()
        ]);

        if (!$result) {
            var_dump($stmt->errorInfo());
        }

        return $result;
    }
}

