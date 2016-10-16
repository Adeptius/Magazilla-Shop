package ua.adeptius.magazilla.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.magazilla.model.Country;
import ua.adeptius.magazilla.model.Good;

import java.util.ArrayList;
import java.util.List;

public class HibernateGoodsDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public ArrayList<Good> getAllGoods() {
        List<Good> allGoods = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        System.out.println(session);
        return (ArrayList<Good>) session.createQuery("select g from Good g").list();
    }

    public void save(Good good) {
        Session session = sessionFactory.getCurrentSession();
        session.save(good);
    }

//    public ArrayList<Good> getAllFromCountry() {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("select g from Good g where g.country like :country");
//        query.setParameter("country", 2);
//        return (ArrayList<Good>) query.uniqueResult();
//    }
}
