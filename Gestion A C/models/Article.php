<?php
require_once 'Sys.php';

class Article {
    protected string $id;
    protected string $nomArticle;
    protected float $prix;
    protected int $quantiteStock;
    protected float $montantStock;
    protected string $type;

    // Getters et Setters
    public function getId(): string {
        return $this->id;
    }

    public function setId(string $id): void {
        $this->id = $id;
    }

    public function getNomArticle(): string {
        return $this->nomArticle;
    }

    public function setNomArticle(string $nomArticle): void {
        $this->nomArticle = $nomArticle;
    }

    public function getPrix(): float {
        return $this->prix;
    }

    public function setPrix(float $prix): void {
        $this->prix = $prix;
    }

    public function getQuantite(): int {
        return $this->quantiteStock;
    }

    public function setQuantite(int $quantite): void {
        $this->quantiteStock = $quantite;
    }

    public function getMontant(): float {
        return $this->montantStock;
    }

    public function setMontant(float $montant): void {
        $this->montantStock = $montant;
    }

    public function getType(): string {
        return $this->type;
    }

    public function setType(string $type): void {
        $this->type = $type;
    }

    // Copie les données d’un autre article
    public function copy(Article $a): void {
        $this->id = $a->getId();
        $this->nomArticle = $a->getNomArticle();
        $this->prix = $a->getPrix();
        $this->quantiteStock = $a->getQuantite();
        $this->montantStock = $a->getMontant();
        $this->type = $a->getType();
    }

    // Comparaison d’articles
    public function equals(Article $a): bool {
        return $this->nomArticle === $a->getNomArticle() &&
               $this->prix === $a->getPrix();
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID          : " . $this->id . "\n" .
            "Nom Article : " . Sys::capitalize($this->nomArticle) . "\n" .
            "Prix        : " . $this->prix . " Fcfa\n" .
            "Quantite    : " . $this->quantiteStock . "\n" .
            "Montant     : " . $this->montantStock . " Fcfa\n" .
            "Type        : " . $this->type;
    }
}
