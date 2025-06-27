<?php

require_once '../service/ArticleConfectionService.php';

$s = new ArticleConfectionService();
$articleConfections = $s->getAllArticleConfections(); // ⚠️ variable bien définie

require_once '../views/articleConfections.html.php'; // <-- Ici

require_once '../repository/ArticleConfectionRepository.php';

class ArticleConfectionController {

    public function list() {
        $repo = new ArticleConfectionRepository();
        $appros = $repo->findAll();
        require 'views/articleConfections.html.php';
    }

}