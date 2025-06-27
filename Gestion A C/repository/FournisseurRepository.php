<?php

require_once __DIR__ . '/../config/connexion.php';
require_once __DIR__ . '/../models/Fournisseur.php';

class FournisseurRepository {
    private PDO $pdo;

    public function __construct() {
        $this->pdo = Connexion::getConnexion();
    }

    public function findAll(): array {
        $stmt = $this->pdo->query("SELECT * FROM fournisseur");
        return $stmt->fetchAll();
    }


    public function save(Fournisseur $fournisseur): bool {
        $sql = "INSERT INTO fournisseur (id, nom, prenom, telephone, adresse, fix) 
                VALUES (:id, :nom, :prenom, :telephone, :adresse, :fix)";
        $stmt = $this->pdo->prepare($sql);
        return $stmt->execute([
            'id' => $fournisseur->getId(),
            'nom' => $fournisseur->getNom(),
            'prenom' => $fournisseur->getPrenom(),
            'telephone' => $fournisseur->getTelephone(),
            'adresse' => $fournisseur->getAdresse(),
            'fix' => $fournisseur->getFix()
        ]);
    }

    public function findById(string $id): ?Fournisseur {
        $stmt = $this->pdo->prepare("SELECT * FROM `fournisseur` WHERE id = :id");
        $stmt->execute(['id' => $id]);
        $row = $stmt->fetch(PDO::FETCH_ASSOC);

        if ($row) {
            $f = new Fournisseur();
            $f->setId($row['id']);
            $f->setNom($row['nom']);
            $f->setPrenom($row['prenom']);
            $f->setTelephone($row['telephone']);
            $f->setFix($row['fix']);
            $f->setAdresse($row['adresse']);
            return $f;
        }

        return null;
    }

    public function deleteById(string $id): bool {
        $stmt = $this->pdo->prepare("DELETE FROM `fournisseur` WHERE id = :id");
        return $stmt->execute(['id' => $id]);
    }
}
