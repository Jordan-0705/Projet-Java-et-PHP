<?php
require_once 'Article.php';
require_once 'Approvisionnement.php';

class ArticleConfection extends Article {
    private static int $nbAc = 0;
    private static array $approvisionnements = [];

    // Constructeur avec paramètres
    public function __construct(string $nomArticle = "", float $prix = 0, int $quantite = 0) {
        parent::__construct();
        if ($nomArticle !== "" && $prix !== 0 && $quantite !== 0) {
            self::$nbAc++;
            $this->id = "AC-" . self::$nbAc;
            $this->nomArticle = $nomArticle;
            $this->prix = $prix;
            $this->quantiteStock = $quantite;
            $this->montantStock = $prix * $quantite;
            $this->type = "Article Confection";
        }
    }

    // Liste statique des approvisionnements
    public static function getApprovisionnements(): array {
        return self::$approvisionnements;
    }

    public static function addApprovisionnement(Approvisionnement $approvisionnement): void {
        self::$approvisionnements[] = $approvisionnement;
    }
}
