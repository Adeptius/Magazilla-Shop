package ua.adeptius.magazilla;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.adeptius.magazilla.controllers.CountryController;
import ua.adeptius.magazilla.controllers.GoodsController;
import ua.adeptius.magazilla.model.Category;
import ua.adeptius.magazilla.model.Country;
import ua.adeptius.magazilla.model.Good;
import ua.adeptius.magazilla.model.Region;

import java.util.ArrayList;

public class Main {

    private GoodsController goodsController;
    private SessionFactory sessionFactory;
    private CountryController countryController;

    public void setCountryController(CountryController countryController) {
        this.countryController = countryController;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setGoodsController(GoodsController goodsController) {
        this.goodsController = goodsController;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml", "hibernate-context.xml");

        Main main = context.getBean(Main.class);


        Country country = new Country(Region.CHINA);
        main.countryController.addCountry(country);

        Good good = new Good();
        good.setCategory(Category.BAGS);
        good.setPrice(5);
        good.setTitle("Сумка 15 с алиэкспресс");
        good.setCountry(country);

        main.goodsController.addGood(good);

        ArrayList<Good> goods = main.goodsController.getGoods();
        goods.forEach(System.out::println);
    }

    private void init(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
