<?php
define("WEB_ROOT","http://localhost:80/Gestion%20A%20C/public");

$page=isset($_GET["page"])?$_GET["page"]:"dashboard";
if ($page=="fournisseurs") {
    require_once"../controllers/FournisseurController.php";
   // require_once"../views/clients.html.php";
}elseif ($page=="articles"){
    require_once"../controllers/ArticleConfectionController.php";
}elseif ($page=="index"){
    require_once"../views/dashboard.html.php";
}elseif ($page=="approvisionnements"){
    require_once"../controllers/ApprovisionnementController.php";
}else{
    require_once"../controllers/FournisseurController.php";
    // ../views/notFound.html.php
}

?>