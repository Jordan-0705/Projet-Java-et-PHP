<?php
require_once __DIR__ . '/../repository/ApprovisionnementRepository.php';

class ApprovisionnementService {
    private ApprovisionnementRepository $repo;

    public function __construct() {
        $this->repo = new ApprovisionnementRepository();
    }

    public function addApprovisionnement(Approvisionnement $appro): bool {
        return $this->repo->save($appro);
    }

    public function getAllApprovisionnements(): array {
        return $this->repo->findAll();
    }

}