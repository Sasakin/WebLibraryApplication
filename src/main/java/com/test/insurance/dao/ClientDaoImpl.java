package com.test.insurance.dao;

import com.test.insurance.model.Client;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addClient(Client client) {
        entityManager.unwrap(Session.class).persist(client);
    }

    @Override
    public void updateClient(Client client) {
        entityManager.unwrap(Session.class).update(client);

    }

    @Override
    public void removeClient(int id) {
        Client client = (Client) entityManager.unwrap(Session.class).load(Client.class, new Integer(id));

        if(client!=null){
            entityManager.unwrap(Session.class).delete(client);
        }
    }

    @Override
    public Client getClientById(int id) {
        Client Client = entityManager.unwrap(Session.class).load(Client.class, new Integer(id));
        return Client;
    }

    @Override
    public List<Client> listClients() {
        List<Client> list = entityManager.unwrap(Session.class).createQuery("from Client").getResultList();
        return list;
    }
}
