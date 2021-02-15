package entity;

import DaoInter.BusinessmanDaoInter;
import DaoInter.CountryDaoInter;

public class Main {
    public static void main(String[] args) throws Exception {
        CountryDaoInter dao = Contex.instanceCountryDao();
        System.out.println(dao.getAll());
    }
}
