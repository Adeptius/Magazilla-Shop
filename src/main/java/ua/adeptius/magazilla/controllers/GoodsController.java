package ua.adeptius.magazilla.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.adeptius.magazilla.dao.HibernateGoodsDao;
import ua.adeptius.magazilla.model.Good;

import java.util.ArrayList;

public class GoodsController {

    private HibernateGoodsDao goodsDao;

    public void setGoodsDao(HibernateGoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Transactional
    public ArrayList<Good> getGoods(){
        return goodsDao.getAllGoods();
    }

    @Transactional
    public void addGood(Good good){
        goodsDao.save(good);
    }

}
