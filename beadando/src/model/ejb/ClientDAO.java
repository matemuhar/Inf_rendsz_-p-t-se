package model.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Client;


/**
 * Session Bean implementation class ClientDAO
 */
@Stateless
@LocalBean
public class ClientDAO {

    @PersistenceContext private EntityManager em;
    
    public void addClient(Client client) {
        em.persist(client);
    }
    public void editClient(Client client){
        em.merge(client);
    }
    public void deleteClient(String id){
    	Client client = em.find(Client.class, id);
        em.remove(client);
    }
    public Client getClient(String id){
        return em.find(Client.class, id);
    }
    public List getAllClients(){
        return em.createNamedQuery("Client.getAll").getResultList();
    }
}
