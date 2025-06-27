<?php
require_once 'Operation.php';
require_once 'ArticleVente.php';

class Production extends Operation {
    private static int $nbPro = 0;

    public function __construct() {
        parent::__construct();
        self::$nbPro++;
        $this->article = new ArticleVente();
        $this->id = "PRO-" . self::$nbPro;
        $this->nature = "Production";
    }
}
