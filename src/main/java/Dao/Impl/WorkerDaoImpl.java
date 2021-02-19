package Dao.Impl;

import Dao.Inter.AbstractDao;
import Dao.Inter.WorkerDaoInter;
import entity.Contex;
import entity.Country;
import entity.Worker;
import entity.WorkerCompany;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDaoImpl extends AbstractDao implements WorkerDaoInter {

    private Worker getWorker(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        Date birthdate = rs.getDate("birthdate");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int birthplaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String countryNameStr = rs.getString("country_name");
        String nationalityStr = rs.getString("nationality");
        Country countryName = new Country(null, countryNameStr, null);
        Country nationality = new Country(null, null, nationalityStr);
        List<WorkerCompany> companies = Contex.instanceWorkerCompanyDao().getAllWorkerCompanyByWorkerId(id);
        return new Worker(id, name, surname, birthdate, address, email, phone, birthplaceId, nationalityId, countryName, nationality, companies);
    }


    @Override
    public List<Worker> getAll() {
        List<Worker> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select w.*, c1.country_name, c2.nationality from worker w " +
                    "left join country c1 on w.birthplace_id = c1.id " +
                    "left join country c2 on w.nationality_id = c2.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getWorker(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Worker getById(int userId) {
        Worker result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select w.*, c1.country_name, c2.nationality from worker w " +
                    "left join country c1 on w.birthplace_id = c1.id " +
                    "left join country c2 on w.nationality_id = c2.id where id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getWorker(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Worker w) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("update worker set name = ?, surname = ? " +
                    "birthdate = ?, address = ?, email = ?, phone = ?, birthplace_id = ?, nationality_id = ? where id = ?");
            stmt.setString(1, w.getName());
            stmt.setString(2, w.getSurname());
            stmt.setDate(3, w.getBirthdate());
            stmt.setString(4, w.getAddress());
            stmt.setString(5, w.getEmail());
            stmt.setString(6, w.getPhone());
            stmt.setInt(7, w.getBirthplaceId());
            stmt.setInt(8, w.getNationalityId());
            stmt.setInt(9, w.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Worker w) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("insert into worker (name, surname, birthdate, address, " +
                    "email, phone, birhtplace_id, nationality_id) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, w.getName());
            stmt.setString(2, w.getSurname());
            stmt.setDate(3, w.getBirthdate());
            stmt.setString(4, w.getAddress());
            stmt.setString(5, w.getEmail());
            stmt.setString(6, w.getPhone());
            stmt.setInt(7, w.getBirthplaceId());
            stmt.setInt(8, w.getNationalityId());
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
            return stmt.execute("delete from worker where id = " + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
