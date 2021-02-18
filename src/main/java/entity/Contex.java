package entity;

import Dao.Impl.CompanyDaoImpl;
import Dao.Impl.CountryDaoImpl;
import Dao.Inter.BusinessmanDaoInter;
import Dao.Impl.BusinessmanDaoImpl;
import Dao.Inter.CompanyDaoInter;
import Dao.Inter.CountryDaoInter;

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
