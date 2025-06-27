<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../public/css/styles.css">
    <title>Document</title>
</head>
<body>
    <?php require_once"partial/_menu.html.php"?>
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
        <section id="articles" class="page active">
                <button class="add-btn">Ajouter un article</button>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Artile</th>
                            <th>Prix</th>
                            <th>Quantité</th>
                            <th>Montant</th>
                            <th>Type</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if (!empty($articleConfections)) : ?>
                            <?php foreach ($articleConfections as $a) : ?>
                                <tr>
                                    <td><?= htmlspecialchars($a['id']) ?></td>
                                    <td><?= htmlspecialchars($a['nomArticle']) ?></td>
                                    <td><?= htmlspecialchars($a['prix']) ?></td>
                                    <td><?= htmlspecialchars($a['quantite']) ?></td>
                                    <td><?= htmlspecialchars($a['montant']) ?></td>
                                    <td><?= htmlspecialchars($a['type']) ?></td>
                                    <td>
                                        <button class="btn modify">Modifier</button>
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
</main>
</body>
</html>