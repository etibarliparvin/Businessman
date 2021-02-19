package entity;

import Dao.Inter.BusinessmanDaoInter;
import Dao.Inter.WorkerCompanyDaoInter;
import Dao.Inter.WorkerDaoInter;

public class Main {
    public static void main(String[] args) throws Exception {
//        WorkerCompanyDaoInter dao = Contex.instanceWorkerCompanyDao();
//        System.out.println(dao.getAll());

        WorkerDaoInter dao = Contex.instanceWorkerDao();
        System.out.println(dao.getAll());
    }
}
