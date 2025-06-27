package views;

import java.util.Scanner;

import services.Test;

public class Vue {
    
    protected static String saisieChaine(String message) {
        
        String mot;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(message);
            mot = scanner.nextLine();
        } while (!Test.isAlpha(mot));
        return mot;
    }

    protected static String saisieTel(String message) {
        
        String tel;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(message);
            tel = scanner.nextLine();
            switch (Test.isTel(tel)) {
                case 0:
                    System.err.println("Le numero doit contenir 9 chiffres !");
                    break;
                case 1:
                    System.err.println("Le numero doit commencer par 77, 78, 70 ou 76 !");
                    break;
                case 2:
                    System.err.println("Le numero ne doit contenir que des chiffres !");
                    break;
                default:
                    break;
            }
        } while (Test.isTel(tel) != 3);
        return tel;
    }

    protected static String saisieFix(String message) {
        
        String fix;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(message);
            fix = scanner.nextLine();
            switch (Test.isFix(fix)) {
                case 0:
                    System.err.println("Le numero doit contenir 9 chiffres !");
                    break;
                case 1:
                    System.err.println("Le numero doit commencer par 33 !");
                    break;
                case 2:
                    System.err.println("Le numero ne doit contenir que des chiffres !");
                    break;
                default:
                    break;
            }
        } while (Test.isFix(fix) != 3);
        return fix;
    }

    protected static double saisieDouble(String message) {
        
        String mot;
        double reel;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(message);
            mot = scanner.nextLine();
        } while (!Test.isDouble(mot));
        reel = Double.parseDouble(mot);
        return reel;
    }

    protected static int saisieEntier(String message) {
        
        String mot;
        int entier;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(message);
            mot = scanner.nextLine();
        } while (!Test.isNumeric(mot));
        entier = Integer.parseInt(mot);
        return entier;
    }
        


}
