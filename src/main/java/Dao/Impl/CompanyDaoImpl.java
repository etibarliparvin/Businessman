package Dao.Impl;

import Dao.Inter.AbstractDao;
import Dao.Inter.CompanyDaoInter;
import entity.Company;
import entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDaoImpl extends AbstractDao implements CompanyDaoInter {

    private Company getCompany(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String companyName = rs.getString("company_name");
        int businessmanId = rs.getInt("businessman_id");
        int locationId = rs.getInt("location_id");
        String countryNameStr = rs.getString("country_name");
        Country countryName = new Country(null, countryNameStr, null);
        return new Company(id, companyName, businessmanId, locationId, countryName);
    }

    @Override
    public List<Company> getAll() {
        List<Company> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select c.*, c1.country_name from company c " +
                    "left join country c1 on c.location_id = c1.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getCompany(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Company getById(int userId) {
        Company result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select c.*, c1.country_name from company c " +
                    "left join country c1 on c.location_id = c1.id where id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCompany(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Company getByName(String name) {
        Company result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from company where name = " + name);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCompany(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Company company) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("update company set company_name = ?, businessman_id = ?, location_id = ?" +
                    "where id = ?");
            stmt.setString(1, company.getCompanyName());
            stmt.setInt(2, company.getBusinessmanId());
            stmt.setInt(3, company.getLocationId());
            stmt.setInt(4, company.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Company company) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("insert into company (company_name, businessman_id, location_id) " +
                    "values (?, ?, ?)");
            stmt.setString(1, company.getCompanyName());
            stmt.setInt(2, company.getBusinessmanId());
            stmt.setInt(3, company.getLocationId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeById(int userId) {
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete from company where id = " + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeByName(String name) {
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete from company where company_name = " + name);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Company> getAllCompaniesByBusinessmanId(int userId) {
        List<Company> result = new ArrayList<>();
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("select c.*, c1.country_name from company c " +
                    "left join country c1 on c.location_id = c1.id " +
                    "where businessman_id = " + userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getCompany(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
