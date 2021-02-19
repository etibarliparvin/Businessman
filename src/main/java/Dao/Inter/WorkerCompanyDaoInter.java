package Dao.Inter;

import entity.Worker;
import entity.WorkerCompany;

import java.util.List;

public interface WorkerCompanyDaoInter {

    public List<WorkerCompany> getAll();

    public WorkerCompany getById(int id);

    public boolean update(WorkerCompany wc);

    public boolean add(WorkerCompany wc);

    public boolean remove(int id);

}
