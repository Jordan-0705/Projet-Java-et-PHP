<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Fournisseurs</title>
    <link rel="stylesheet" href="../public/css/styles.css">
    <style>
        #overlay {
            position: fixed;
            top: 0; left: 0;
            width: 100vw; height: 100vh;
            background: rgba(0,0,0,0.5);
            display: none;
            justify-content: center;
            align-items: center;
            z-index: 1000;
        }
        #fournisseur-form {
            background: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.3);
            width: 400px;
            z-index: 1001;
        }
        #fournisseur-form label {
            display: block;
            margin-bottom: 10px;
            font-weight: 600;
            color: #333;
        }
        #fournisseur-form input {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
            margin-top: 4px;
        }
        #fournisseur-form button {
            margin-top: 10px;
            padding: 10px 16px;
            border-radius: 6px;
            font-size: 14px;
            cursor: pointer;
        }
        #fournisseur-form button[type="submit"] {
            background-color: #C37F00;
            color: white;
            border: none;
            margin-right: 10px;
        }
        #fournisseur-form button[type="submit"]:hover {
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
    <main class="content">
        <header class="header">
            <div class="search-bar">
                <input type="text" placeholder="Rechercher ...">
                <span>🔍</span>
            </div>
            <div class="user">
                <span>👤</span> <p>Utilisateur</p>
            </div>
        </header>

        <section id="fournisseurs" class="page active">
            <button id="show-form" class="add-btn">Ajouter Fournisseur</button>

            <div id="overlay">
                <div id="fournisseur-form">
                    <form method="post" action="index.php?page=fournisseurs&action=add">
                        <label>Nom : <input type="text" name="nom" required></label>
                        <label>Prénom : <input type="text" name="prenom" required></label>
                        <label>Téléphone : <input type="text" name="telephone" required></label>
                        <label>Fixe : <input type="text" name="fix"></label>
                        <label>Adresse : <input type="text" name="adresse" required></label>
                        <button type="submit">Enregistrer</button>
                        <button type="button" id="cancel-form">Annuler</button>
                    </form>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Téléphone</th>
                        <th>Fix</th>
                        <th>Adresse</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <?php if (!empty($fournisseurs)) : ?>
                        <?php foreach ($fournisseurs as $fournisseur) : ?>
                            <tr>
                                <td><?= htmlspecialchars($fournisseur['id']) ?></td>
                                <td><?= htmlspecialchars($fournisseur['nom']) ?></td>
                                <td><?= htmlspecialchars($fournisseur['prenom']) ?></td>
                                <td><?= htmlspecialchars($fournisseur['telephone']) ?></td>
                                <td><?= htmlspecialchars($fournisseur['fix']) ?></td>
                                <td><?= htmlspecialchars($fournisseur['adresse']) ?></td>
                                <td>
                                    <button class="btn modify">Modifier</button>
                                    <button class="btn view-debt">Voir appro</button>
                                    <button class="btn delete">Supprimer</button>
                                </td>
                            </tr>
                        <?php endforeach; ?>
                    <?php else : ?>
                        <tr>
                            <td colspan="5">Aucun fournisseur trouvé.</td>
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
