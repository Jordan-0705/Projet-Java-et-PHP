<?php
require_once 'Operation.php';
require_once 'Fournisseur.php';
require_once 'ArticleConfection.php';
require_once 'Sys.php';

class Approvisionnement extends Operation {
    private static int $nbAp = 0;
    private Fournisseur $fournisseur;
    private string $fournisseur_id;

    public function __construct(Fournisseur $fournisseur = null) {
        parent::__construct();
        self::$nbAp++;
        $this->article = new ArticleConfection();
        $this->id = "AP-" . self::$nbAp;
        $this->nature = "Approvisionnement";
    }

    public function getFournisseur(): Fournisseur {
        return $this->fournisseur;
    }

    public function getFournisseurId(): string {
        return $this->fournisseur_id;
    }

    public function setFournisseur(Fournisseur $fournisseur): void {
        $this->fournisseur = $fournisseur;
        $this->fournisseur_id = $fournisseur->getId();
    }
    
    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID                       : " . $this->id . "\n" .
            "ID du fournisseur        : " . $this->fournisseur->getId() . "\n" .
            "Telephone du fournisseur : " . $this->fournisseur->getTelephone() . "\n" .
            "Nom Article              : " . Sys::capitalize($this->article->getNomArticle()) . "\n" .
            "Prix                     : " . $this->article->getPrix() . " Fcfa\n" .
            "Quantite                 : " . $this->article->getQuantite() . "\n" .
            "Montant                  : " . $this->article->getMontant() . " Fcfa\n" .
            "Nature                   : " . $this->nature . "\n" .
            "Date                     : " . $this->date;
    }
}
