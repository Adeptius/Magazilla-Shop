package ua.adeptius.magazilla.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.adeptius.magazilla.model.Country;

import java.util.List;

public class HibernateCountryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.save(country);
    }

    public Country getCountry(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "select c from Country c where c.region like :name");
        query.setParameter("name", name);
        return (Country) query.uniqueResult();
    }

    public List<Country> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "select c from Country c");
        return query.list();

    }

    public void createCountry(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.save(new Country(name));
    }
}
