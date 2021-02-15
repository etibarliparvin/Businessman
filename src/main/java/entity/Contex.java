package entity;

import DaoImpl.CompanyDaoImpl;
import DaoImpl.CountryDaoImpl;
import DaoInter.BusinessmanDaoInter;
import DaoImpl.BusinessmanDaoImpl;
import DaoInter.CompanyDaoInter;
import DaoInter.CountryDaoInter;

public class Contex {

    public static BusinessmanDaoInter instanceBusinessmanDao() {
        return new BusinessmanDaoImpl();
    }

    public static CompanyDaoInter instanceCompanyDao() {
        return new CompanyDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }
}
