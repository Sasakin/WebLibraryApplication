package com.test.insurance.service;

import com.test.insurance.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientService service;

    @Override
    public void addClient(Client client) {
        service.addClient(client);
    }

    @Override
    public void updateClient(Client client) {
        service.updateClient(client);
    }

    @Override
    public void removeClient(int id) {
        service.removeClient(id);
    }

    @Override
    public Client getClientById(int id) {
        return service.getClientById(id);
    }

    @Override
    public List<Client> listClients() {
        return service.listClients();
    }
}
