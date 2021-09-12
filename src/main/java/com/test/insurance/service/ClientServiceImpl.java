package com.test.insurance.service;

import com.test.insurance.dao.ClientDao;
import com.test.insurance.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    @Qualifier("clientDao")
    private ClientDao dao;

    @Override
    public void addClient(Client client) {
        dao.addClient(client);
    }

    @Override
    public void updateClient(Client client) {
        dao.updateClient(client);
    }

    @Override
    public void removeClient(int id) {
        dao.removeClient(id);
    }

    @Override
    public Client getClientById(int id) {
        return dao.getClientById(id);
    }

    @Override
    public List<Client> listClients() {
        return dao.listClients();
    }
}
