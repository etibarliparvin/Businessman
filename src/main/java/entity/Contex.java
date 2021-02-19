package entity;

import Dao.Impl.*;
import Dao.Inter.*;

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

    public static WorkerDaoInter instanceWorkerDao() {
        return new WorkerDaoImpl();
    }

    public static WorkerCompanyDaoInter instanceWorkerCompanyDao() {
        return new WorkerCompanyDaoImpl();
    }
}
