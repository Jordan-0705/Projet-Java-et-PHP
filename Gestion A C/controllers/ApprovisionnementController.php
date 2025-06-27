<?php

require_once '../service/ApprovisionnementService.php';

$s = new ApprovisionnementService();
$appros = $s->getAllApprovisionnements(); // ⚠️ variable bien définie

require_once '../views/approvisionnements.html.php'; // <-- Ici

require_once '../repository/ApprovisionnementRepository.php';

class ApprovisionnementController {

    public function list() {
    $repo = new ApprovisionnementRepository();
    $service = new ApprovisionnementService();

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $fournisseurId = (int) $_POST['fournisseur_id'];
        $fournisseurRepo = new FournisseurRepository();
        $fournisseur = $fournisseurRepo->findById($fournisseurId);

        if (!$fournisseur) {
            echo "<p style='color:red;'>Fournisseur non trouvé.</p>";
            exit;
        }

        $appro = new Approvisionnement();
        $appro->setFournisseur($fournisseur);
        $appro->getArticle()->setNomArticle($_POST['nomArticle']);
        $appro->getArticle()->setPrix((float) $_POST['prix']);
        $appro->getArticle()->setQuantite((int) $_POST['quantite']);
        $appro->getArticle()->setMontant(
            $appro->getArticle()->getPrix() * $appro->getArticle()->getQuantite()
        );
        $appro->setDate($_POST['date']);

        var_dump($appro);

        if ($service->addApprovisionnement($appro)) {
            header('Location: ' . $_SERVER['PHP_SELF']);
            exit;
        } else {
            echo "<p style='color:red;'>Erreur lors de l'ajout.</p>";
        }
    }

    $appros = $repo->findAll();
    require __DIR__ . '/../views/approvisionnements.html.php';
    }
}

