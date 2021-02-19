package Dao.Impl;

import Dao.Inter.AbstractDao;
import Dao.Inter.WorkerDaoInter;
import entity.Country;
import entity.Worker;
import entity.WorkerCompany;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
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
        List<WorkerCompany> companies =
    }


    @Override
    public List<Worker> getAll() {
        List<Worker> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select w.*, c1.country_name, c2.nationality from worker w " +
                    "left join country c1 on w.birthplace_id = c1.id " +
                    "left join country c2 on w.nationality_id = c2.id;");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                result.add(getWorker(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Worker getById(int id) {
        return null;
    }

    @Override
    public boolean update(Worker w) {
        return false;
    }

    @Override
    public boolean add(Worker w) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
