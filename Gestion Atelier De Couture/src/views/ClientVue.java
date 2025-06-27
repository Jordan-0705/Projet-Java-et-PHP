package views;

import java.util.Scanner;

import entity.Client;

public class ClientVue extends Vue {
    
    public static Client saisieClient(){

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisie des informations du client :\n");

        client.setNom(saisieChaine("Saisir le nom du client : "));
        client.setPrenom(saisieChaine("Saisir le prenom du client : "));
        client.setTelephone(saisieTel("Saisir le numero de telephone du client : "));
        client.setAdresse(saisieChaine("Saisir l'adresse du client : "));

        return client;
    }

    

}
