package Dao.Inter;

import entity.Worker;

import java.util.List;

public interface WorkerDaoInter {

    public List<Worker> getAll();

    public Worker getById(int userId);

    public boolean update(Worker w);

    public boolean add(Worker w);

    public boolean remove(int userId);
}
