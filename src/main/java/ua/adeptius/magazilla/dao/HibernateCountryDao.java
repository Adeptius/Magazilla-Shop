package ua.adeptius.magazilla.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.adeptius.magazilla.model.Country;
public class HibernateCountryDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Country country) {
        Session session = sessionFactory.getCurrentSession();
        session.save(country);
    }

}
