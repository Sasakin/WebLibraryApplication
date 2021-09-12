package com.test.insurance.service;

import com.test.insurance.model.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);

    void updateClient(Client client);

    void removeClient(int id);

    Client getClientById(int id);

    List<Client> listClients();
}
