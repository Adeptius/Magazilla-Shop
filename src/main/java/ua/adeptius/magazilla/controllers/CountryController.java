package ua.adeptius.magazilla.controllers;


import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.magazilla.dao.HibernateCountryDao;
import ua.adeptius.magazilla.model.Country;

import java.util.List;

public class CountryController {

    HibernateCountryDao countryDao;

    public void setCountryDao(HibernateCountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional
    public void addCountry(Country country) {
        countryDao.save(country);
    }


    @Transactional
    public Country findCountryByName(String country) {
        return countryDao.getCountry(country);
    }

    @Transactional
    public List<Country> getAllCountryes() {
        return countryDao.getAll();
    }

    @Transactional
    public void addNewCountry(String name) {
        countryDao.createCountry(name);
    }
}
