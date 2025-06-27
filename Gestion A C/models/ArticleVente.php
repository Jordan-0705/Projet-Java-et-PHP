<?php
require_once 'Article.php';
require_once 'Production.php';
require_once 'Vente.php';

class ArticleVente extends Article {
    private static int $nbAv = 0;
    private static array $productions = [];
    private static array $ventes = [];

    // Constructeur avec ou sans paramètres
    public function __construct(string $nomArticle = "", float $prix = 0, int $quantite = 0) {
        parent::__construct();
        if ($nomArticle !== "" && $prix !== 0 && $quantite !== 0) {
            self::$nbAv++;
            $this->id = "AV-" . self::$nbAv;
            $this->nomArticle = $nomArticle;
            $this->prix = $prix;
            $this->quantiteStock = $quantite;
            $this->montantStock = $prix * $quantite;
            $this->type = "Article Vente";
        }
    }

    // Liste des productions
    public static function getProductions(): array {
        return self::$productions;
    }

    public static function addProduction(Production $production): void {
        self::$productions[] = $production;
    }

    // Liste des ventes
    public static function getVentes(): array {
        return self::$ventes;
    }

    public static function addVente(Vente $vente): void {
        self::$ventes[] = $vente;
    }
}
