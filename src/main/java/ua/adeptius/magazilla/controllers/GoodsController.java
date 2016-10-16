package ua.adeptius.magazilla.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.magazilla.dao.HibernateGoodsDao;
import ua.adeptius.magazilla.model.Country;
import ua.adeptius.magazilla.model.Good;

import java.util.ArrayList;

public class GoodsController {

    private HibernateGoodsDao goodsDao;

    public void setGoodsDao(HibernateGoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Transactional
    public ArrayList<Good> getAllGoods(){
        return goodsDao.getAllGoods();
    }

    @Transactional
    public void addGood(Good good){
        goodsDao.save(good);
    }


    public ArrayList<Good> getAllGoodsFromCountry(Country country) {
        ArrayList<Good> allGoods = getAllGoods();
        ArrayList<Good> goodsFromNeededCountry = new ArrayList<>();
        for (Good good : allGoods) {
            if (good.getCountry().getRegion().equals(country.getRegion()))
                goodsFromNeededCountry.add(good);
        }
        return goodsFromNeededCountry;
    }
}
