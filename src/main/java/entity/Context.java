package entity;

import DaoInter.BusinessmanDaoInter;
import DaoImpl.BusinessmanDaoImpl;

public class Context {
    public static BusinessmanDaoInter instanceBusinessmanDao() {
        return new BusinessmanDaoImpl();
    }
}
