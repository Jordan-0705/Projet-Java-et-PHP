<?php

require_once __DIR__ . '/../config/connexion.php';
require_once __DIR__ . '/../models/ArticleConfection.php';

class ArticleConfectionRepository {
    private PDO $pdo;

    public function __construct() {
        $this->pdo = Connexion::getConnexion();
    }

    public function findAll(): array {
        $stmt = $this->pdo->query("SELECT * FROM articleconfection");
        return $stmt->fetchAll();
    }

    

}