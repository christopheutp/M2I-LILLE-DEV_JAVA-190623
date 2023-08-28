package org.example.services;




import org.example.entities.Adresse;
import org.example.entities.Commande;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;


public class CommandeService extends BaseService implements Repository<Commande> {

    public CommandeService() {
        super();
    }

    @Override
    public boolean create(Commande o) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        o.setTotal(o.getTotal());
        session.save(o);
        o.getProduits().forEach(p -> {
            p.setStock(p.getStock() - 1);
            session.update(p);
        });
        session.getTransaction().commit();
        session.close();
        return o.getId() > 0;
    }
    public boolean createWithAdresse(Commande o, Adresse adresse) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        adresse.setCommande(o);
        o.setAdresse(adresse);
        o.setTotal(o.getTotal());
        session.save(o);
        session.save(adresse);
        o.getProduits().forEach(p -> {
            p.setStock(p.getStock() - 1);
            session.update(p);
        });
        session.getTransaction().commit();
        session.close();
        return o.getId() > 0;
    }

    @Override
    public boolean update(Commande o) {
        return false;
    }

    @Override
    public boolean delete(Commande o) {
        return false;
    }

    @Override
    public Commande findById(int id) {
        return null;
    }

    @Override
    public List<Commande> findAll() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Commande> commandeQuery = session.createQuery("from Commande");
        List<Commande> commandeList = commandeQuery.list();
        session.getTransaction().commit();
        session.close();
        return commandeList;
    }


    public List<Commande> commandesOfTheDay() {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Commande> commandeQuery = session.createQuery("from Commande where dateCommande =:dateCommande");
        commandeQuery.setParameter("dateCommande", new Date());
        List<Commande> commandeList = commandeQuery.list();
        session.getTransaction().commit();
        session.close();
        return commandeList;
    }


}
