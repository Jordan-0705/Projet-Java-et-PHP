<?php
require_once 'Article.php';
require_once 'Sys.php';

class Operation {
    protected string $id;
    protected Article $article;
    protected string $nature;
    protected string $date;

    public function __construct() {
        $this->date = Sys::date(new DateTime())->format('d-m-Y');
    }

    public function getId(): string {
        return $this->id;
    }

    public function setId(string $id): void {
        $this->id = $id;
    }

    public function getDate(): string {
        return $this->date;
    }

    public function setDate(string $date): void {
        $this->date = $date;
    }

    public function getNature(): string {
        return $this->nature;
    }

    public function setNature(string $nature): void {
        $this->nature = $nature;
    }

    public function getArticle(): Article {
        return $this->article;
    }

    public function setArticle(Article $article): void {
        $this->article = $article;
    }

    public function copy(Operation $o): void {
        $this->article = $o->getArticle();
        $this->nature = $o->getNature();
        $this->date = $o->getDate();
    }

    public function equals(Operation $o): bool {
        return $this->article->equals($o->getArticle());
    }

    public function __toString(): string {
        return "\n---------------------------------------\n" .
            "ID          : " . $this->id . "\n" .
            "Nom Article : " . Sys::capitalize($this->article->getNomArticle()) . "\n" .
            "Prix        : " . $this->article->getPrix() . " Fcfa\n" .
            "Quantite    : " . $this->article->getQuantite() . "\n" .
            "Montant     : " . $this->article->getMontant() . " Fcfa\n" .
            "Nature      : " . $this->nature . "\n" .
            "Date        : " . $this->date;
    }
}
