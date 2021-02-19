package Dao.Impl;

import Dao.Inter.AbstractDao;
import Dao.Inter.WorkerCompanyDaoInter;
import entity.Company;
import entity.Contex;
import entity.Worker;
import entity.WorkerCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkerCompanyDaoImpl extends AbstractDao implements WorkerCompanyDaoInter {

    private WorkerCompany getWorkerCompany(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        int companyId = rs.getInt("company_id");
        int workerId = rs.getInt("worker_id");
        double salary = rs.getDouble("salary");
        Company company = Contex.instanceCompanyDao().getById(companyId);
        Worker worker = Contex.instanceWorkerDao().getById(workerId);
        return new WorkerCompany(id, company, worker, salary);
    }

    @Override
    public List<WorkerCompany> getAll() {
        List<WorkerCompany> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from worker_company");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getWorkerCompany(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public WorkerCompany getById(int userId) {
        WorkerCompany result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from worker_company where id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getWorkerCompany(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(WorkerCompany wc) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("update worker_company set salary = ? where id = ?");
            stmt.setDouble(1, wc.getSalary());
            stmt.setInt(2, wc.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(WorkerCompany wc) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("insert into worker_company (company_id, worker_id, salary)" +
                    "values(?, ?, ?)");
            stmt.setInt(1, wc.getCompany().getId());
            stmt.setInt(2, wc.getWorker().getId());
            stmt.setDouble(3, wc.getSalary());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int userId) {
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete from worker_company where id = " + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<WorkerCompany> getAllWorkerCompanyByWorkerId(int userId) {
        List<WorkerCompany> result = new ArrayList<>();
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("select wc.*, c.company_name from worker_company wc " +
                    "left join company c on wc.company_id = c.id where worker_id = " + userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                result.add(getWorkerCompany(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
