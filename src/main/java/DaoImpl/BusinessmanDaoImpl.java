package DaoImpl;

import DaoInter.AbstractDao;
import DaoInter.BusinessmanDaoInter;
import entity.Businessman;
import entity.Company;
import entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusinessmanDaoImpl extends AbstractDao implements BusinessmanDaoInter {

    private Businessman getBusinessman(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        Date birhtdate = rs.getDate("birthdate");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int birhtplaceId = rs.getInt("birthplace_id");
        int nationalityId = rs.getInt("nationality_id");
        String countryNameStr = rs.getString("country_name");
        String nationalityStr = rs.getString("nationality");
        int companyId = rs.getInt("company_id");
        String companyName = rs.getString("company_name");
        String companyLocationStr = rs.getString("company_location");

        Country countryName = new Country(null, countryNameStr, null);
        Country nationality = new Country(null, null, nationalityStr);
        Country companyLocation = new Country(null, companyLocationStr, null);
        Company company = new Company(companyId, companyName, null, null, companyLocation);

        return new Businessman(id, name, surname, birhtdate, address, email, phone, birhtplaceId, nationalityId, countryName, nationality, company);
    }

    @Override
    public List<Businessman> getAll() {
        List<Businessman> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select b.id, b.name, b.surname, b.birthdate, b.address, b.email, b.phone, b.birthplace_id, c1.country_name, " +
                    "b.nationality_id, c2.nationality, c.id as company_id, c.company_name, c3.country_name as company_location " +
                    "from businessman b " +
                    "left join company c on c.businessman_id = b.id " +
                    "left join country c1 on b.birthplace_id = c1.id " +
                    "left join country c2 on b.nationality_id = c2.id " +
                    "left join country c3 on c.location_id = c3.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getBusinessman(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Businessman getById(int id) {
        Businessman result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select b.id, b.name, b.surname, b.birthdate, b.address, b.email, b.phone, b.birthplace_id, c1.country_name, " +
                    "b.nationality_id, c2.nationality, c.id as company_id, c.company_name, c3.country_name as company_location " +
                    "from businessman b " +
                    "left join company c on c.businessman_id = b.id " +
                    "left join country c1 on b.birthplace_id = c1.id " +
                    "left join country c2 on b.nationality_id = c2.id " +
                    "left join country c3 on c.location_id = c3.id where id = " + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getBusinessman(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Businessman b) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("update businessman set name = ?, surname = ?" +
                    "birthdate = ?, address = ?, email = ?, phone = ?, birthplace_id = ?, nationality_id = ? where id = ?");
            stmt.setString(1, b.getName());
            stmt.setString(2, b.getSurname());
            stmt.setDate(3, b.getBirthdate());
            stmt.setString(4, b.getAddress());
            stmt.setString(5, b.getEmail());
            stmt.setString(6, b.getPhone());
            stmt.setInt(7, b.getBirthplaceId());
            stmt.setInt(8, b.getNationalityId());
            stmt.setInt(9, b.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Businessman b) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("insert into businessman (name, surname, birthdate, address, " +
                    "email, phone, birhtplace_id, nationality_id) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, b.getName());
            stmt.setString(2, b.getSurname());
            stmt.setDate(3, b.getBirthdate());
            stmt.setString(4, b.getAddress());
            stmt.setString(5, b.getEmail());
            stmt.setString(6, b.getPhone());
            stmt.setInt(7, b.getBirthplaceId());
            stmt.setInt(8, b.getNationalityId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int id) {
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            return stmt.execute("delete from businessman where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

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
