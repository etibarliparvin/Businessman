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

        Company company = Contex.instanceCompanyDao().getById(id);
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
    public WorkerCompany getById(int id) {
        WorkerCompany result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from worker_company");
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
            PreparedStatement stmt = c.prepareStatement("update worker_company set company_id = ?, " +
                    "worker_id = ?, salary = ? where id = ?");
            stmt.setInt(1, wc.getCompany());

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(WorkerCompany wc) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
