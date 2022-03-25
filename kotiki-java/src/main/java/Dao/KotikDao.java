package Dao;

import Entities.Kotik;
import Hybernate.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Optional;

public class KotikDao implements Dao<Kotik>{
    //private ArrayList<Kotik> kotiki = new ArrayList<>();

    @Override
    public Kotik get(Integer id) {
        return HibernateSession.getSessionFactory().openSession().get(Kotik.class, id);
    }

    @Override
    public ArrayList<Kotik> getAll() {
        ArrayList<Kotik> kotiks = (ArrayList<Kotik>)  HibernateSession.getSessionFactory().openSession().createQuery("From Kotik").list();
        return kotiks;
    }

    @Override
    public void save(Kotik kotik) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(kotik);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Kotik kotik) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(kotik);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Kotik kotik) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(kotik);
        tx1.commit();
        session.close();
    }
}
