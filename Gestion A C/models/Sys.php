<?php

class Sys {

    // Nettoyer la console (uniquement en CLI)
    public static function cls() {
        if (PHP_SAPI === 'cli') {
            if (strtoupper(substr(PHP_OS, 0, 3)) === 'WIN') {
                system('cls');
            } else {
                system('clear');
            }
        } else {
            echo "<script>console.clear();</script>";
        }
    }

    // Pause "Appuyez sur Entrée pour continuer..."
    public static function pause() {
        echo "Appuyez sur Entrée pour continuer...";
        fgets(STDIN);
    }

    // Met la première lettre en majuscule, le reste en minuscules
    public static function capitalize(string $mot): string {
        if (empty($mot)) {
            return $mot;
        }
        $mot = mb_strtolower($mot);
        return mb_strtoupper(mb_substr($mot, 0, 1)) . mb_substr($mot, 1);
    }

    // Formatage date LocalDate (ici DateTime) en dd-MM-yyyy
    public static function formatDate(\DateTime $date): string {
        return $date->format('d-m-Y');
    }

    // Vérifier si une date est valide au format dd-mm-yyyy
    public static function isDateValide(string $date): bool {
        $d = \DateTime::createFromFormat('d-m-Y', $date);
        return $d && $d->format('d-m-Y') === $date;
    }
}
