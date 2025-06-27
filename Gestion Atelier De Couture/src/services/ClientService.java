package services;

import java.util.ArrayList;

import entity.Client;

public class ClientService {
    
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static void afficherClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static Client getClientByTel(String tel) {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
            return null;
        }
        for (Client client : clients) {
            if (client.getTelephone().equals(tel)) {
                return client;
            }
        }
        return null;
    }

}
