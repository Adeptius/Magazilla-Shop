package ua.adeptius.magazilla.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.magazilla.dao.HibernateCountryDao;
import ua.adeptius.magazilla.model.Country;

public class CountryController {

    HibernateCountryDao countryDao;

    public void setCountryDao(HibernateCountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional
    public void addCountry(Country country) {
        countryDao.save(country);
    }
}
