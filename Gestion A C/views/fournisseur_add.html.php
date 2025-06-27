<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8" />
    <title>Ajouter un fournisseur</title>
    <link rel="stylesheet" href="../public/css/styles.css" />
</head>
<body>
    <?php require_once "partial/_menu.html.php"; ?>

    <main class="content">
        <h2>Ajouter un fournisseur</h2>
        <form method="post" action="index.php?controller=fournisseur&action=add">
            <label for="nom">Nom :</label><br>
            <input type="text" id="nom" name="nom" required><br><br>

            <label for="prenom">Prénom :</label><br>
            <input type="text" id="prenom" name="prenom" required><br><br>

            <label for="telephone">Téléphone :</label><br>
            <input type="tel" id="telephone" name="telephone" required><br><br>

            <label for="fix">Fix :</label><br>
            <input type="tel" id="fix" name="fix"><br><br>

            <label for="adresse">Adresse :</label><br>
            <input type="text" id="adresse" name="adresse" required><br><br>

            <button type="submit">Ajouter</button>
        </form>
        <p><a href="index.php?controller=fournisseur&action=list">Retour à la liste</a></p>
    </main>
</body>
</html>
