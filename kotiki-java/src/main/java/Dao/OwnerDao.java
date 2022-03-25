package Dao;

import Entities.Kotik;
import Entities.Owner;
import Hybernate.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Optional;

public class OwnerDao implements Dao<Owner> {
    private ArrayList<Owner> owners = new ArrayList<>();

    @Override
    public Owner get(Integer id) {
        return HibernateSession.getSessionFactory().openSession().get(Owner.class, id);
    }

    @Override
    public ArrayList<Owner> getAll() {
        ArrayList<Owner> owners = (ArrayList<Owner>)  HibernateSession.getSessionFactory().openSession().createQuery("From Owner").list();
        return owners;
    }

    @Override
    public void save(Owner owner) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Owner owner) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(owner);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Owner owner) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(owner);
        tx1.commit();
        session.close();
    }
}
