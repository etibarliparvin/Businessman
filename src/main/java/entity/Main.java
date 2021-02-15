package entity;

import DaoInter.BusinessmanDaoInter;
import DaoInter.CountryDaoInter;

public class Main {
    public static void main(String[] args) throws Exception {
        BusinessmanDaoInter dao = Contex.instanceBusinessmanDao();
        System.out.println(dao.getAll());
    }
}
