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

        <section id="dashboard" class="page active">
            <div class="card-container">
                <div class="card">
                    <span>xxxxxxxxxxxxxxxxxxxx :</span>
                    <span>437.000,00 XOF</span>
                </div>
                <div class="card">
                    <span>xxxxxxxxxxxxxxxxxxxx :</span>
                    <span>152.000,00 XOF</span>
                </div>
                <div class="card">
                    <span>xxxxxxxxxxxxxxxxxxxx :</span>
                    <span>3</span>
                </div>
                <div class="card">
                    <span>xxxxxxxxxxxxxxxxxxxx :</span>
                    <span>787</span>
                </div>
            </div>
        </section>
    </main>
</body>
</html>