<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../public/css/styles.css">
    <title>Document</title>
    <style>
        #overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw; 
    height: 100vh;
    background: rgba(0, 0, 0, 0.5); 
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1000;
}

#appro-form {
    background-color: #f9f9f9;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.3);
    width: 400px;
    z-index: 1001;
}

#appro-form label {
    display: block;
    margin-bottom: 10px;
    font-weight: 600;
    color: #333;
}

#appro-form input,
#appro-form select {
    width: 100%;
    padding: 8px 10px;
    border: 1px solid #ccc;
    border-radius: 6px;
    box-sizing: border-box;
    font-size: 14px;
    margin-top: 4px;
}

#appro-form button {
    margin-top: 10px;
    padding: 10px 16px;
    border-radius: 6px;
    font-size: 14px;
    cursor: pointer;
}

#appro-form button[type="submit"] {
    background-color: #C37F00;
    color: white;
    border: none;
    margin-right: 10px;
}

#appro-form button[type="submit"]:hover {
    background-color: #a36a00;
}

#cancel-form {
    background-color: #ccc;
    border: none;
    color: #333;
}

#cancel-form:hover {
    background-color: #aaa;
}

    </style>
</head>
<body>
    <?php require_once "partial/_menu.html.php" ?>
    <?php
        require_once '../repository/FournisseurRepository.php';
        $repo = new FournisseurRepository();
        $fournisseurs = $repo->findAll();
    ?>
    <main class="content">
        <header class="header">
                <div class="search-bar">
                    <input type="text" placeholder="Rechercher ...">
                    <span>🔍</span>
                </div>
                <div class="user">
                    <span>👤</span> <p>User Name</p>
                </div>
            </header>
        <section id="debts" class="page active">
                        <button id="show-form" class="add-btn">Nouvel Approvisionnement</button>
                        <div id="overlay" style="display:none;">
                            <div id="appro-form">
                                <form method="post" action="index.php?page=approvisionnements">
                                    <label>Nom article : <input type="text" name="nomArticle" required></label><br>
                                    <label>Prix : <input type="number" name="prix" required></label><br>
                                    <label>Quantité : <input type="number" name="quantite" required></label><br>
                                    <label>Date : <input type="date" name="date" required></label><br>
                                    <label>Fournisseur :
                                        <select name="fournisseur_id" required>
                                            <?php foreach ($fournisseurs as $f) : ?>
                                                <option value="<?= $f['id'] ?>"><?= htmlspecialchars($f['nom']) ?></option>
                                            <?php endforeach; ?>
                                        </select>
                                    </label><br><br>
                                    <button type="submit">Enregistrer</button>
                                    <button type="button" id="cancel-form">Annuler</button>
                                </form>
                            </div>
                        </div>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Article</th>
                                    <th>Prix</th>
                                    <th>Quantité</th>
                                    <th>Montant</th>
                                    <th>Date</th>
                                    <th>Fournisseur</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php if (!empty($appros)) : ?>
                                    <?php foreach ($appros as $a) : ?>
                                        <tr>
                                            <td><?= htmlspecialchars($a['id']) ?></td>
                                            <td><?= htmlspecialchars($a['nomArticle']) ?></td>
                                            <td><?= htmlspecialchars($a['prix']) ?></td>
                                            <td><?= htmlspecialchars($a['quantite']) ?></td>
                                            <td><?= htmlspecialchars($a['montant']) ?></td>
                                            <td><?= htmlspecialchars($a['date']) ?></td>
                                            <td><?= htmlspecialchars($a['fournisseur_id']) ?></td>
                                            <td>
                                                <button class="btn modify">Modifier</button>
                                                <button class="btn view-debt">Voir appro</button>
                                                <button class="btn delete">Supprimer</button>
                                            </td>
                                        </tr>
                                    <?php endforeach; ?>
                                <?php else : ?>
                                    <tr>
                                        <td colspan="5">Aucun approvisionnement trouvé.</td>
                                    </tr>
                                <?php endif; ?>
                            </tbody>
                        </table>
                    </section>
                    <script>
                        const showBtn = document.getElementById("show-form");
                        const overlay = document.getElementById("overlay");
                        const form = overlay.querySelector("form");
                        const cancelBtn = document.getElementById("cancel-form");

                        showBtn.addEventListener("click", () => {
                            overlay.style.display = "flex";
                        });

                        cancelBtn.addEventListener("click", () => {
                            overlay.style.display = "none";
                        });

                        form.addEventListener("submit", () => {
                            overlay.style.display = "none";
                        });

                    </script>
</main>
</body>
</html>