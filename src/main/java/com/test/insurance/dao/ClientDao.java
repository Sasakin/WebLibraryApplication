package com.test.insurance.dao;

import com.test.insurance.model.Client;

import java.util.List;

public interface ClientDao {
    void addClient(Client client);

    void updateClient(Client client);

    void removeClient(int id);

    Client getClientById(int id);

    List<Client> listClients();
}
