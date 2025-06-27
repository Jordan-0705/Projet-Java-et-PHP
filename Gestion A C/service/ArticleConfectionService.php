<?php
require_once __DIR__ . '/../repository/ArticleConfectionRepository.php';

class ArticleConfectionService {
    private ArticleConfectionRepository $repo;

    public function __construct() {
        $this->repo = new ArticleConfectionRepository();
    }

    public function ArticleConfection(ArticleConfection $ac): bool {
        return $this->repo->save($ac);
    }

    public function getAllArticleConfections(): array {
        return $this->repo->findAll();
    }

}