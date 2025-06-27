<?php
require_once 'Operation.php';
require_once 'ArticleVente.php';
require_once 'Client.php';
require_once 'Sys.php';

class Vente extends Operation {
    private static int $nbV = 0;
    private Client $client;

    public function __construct() {
        parent::__construct();
        self::$nbV++;
        $this->article = new ArticleVente();
        $this->id = "V-" . self::$nbV;
        $this->nature = "Vente";
    }

    public static function getNbV(): int {
        return self::$nbV;
    }

    public static function setNbV(int $nbV): void {
        self::$nbV = $nbV;
    }

    public function getClient(): Client {
        return $this->client;
    }

    public function setClient(Client $client): void {
        $this->client = $client;
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID                  : " . $this->id . "\n" .
            "ID du client        : " . $this->client->getId() . "\n" .
            "Telephone du client : " . $this->client->getTelephone() . "\n" .
            "Nom Article         : " . Sys::capitalize($this->article->getNomArticle()) . "\n" .
            "Prix                : " . $this->article->getPrix() . " Fcfa\n" .
            "Quantite            : " . $this->article->getQuantite() . "\n" .
            "Montant             : " . $this->article->getMontant() . " Fcfa\n" .
            "Nature              : " . $this->nature . "\n" .
            "Date                : " . $this->date;
    }
}
