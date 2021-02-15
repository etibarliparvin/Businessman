package DaoImpl;

import DaoInter.AbstractDao;
import DaoInter.BusinessmanDaoInter;
import entity.Businessman;
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
        return new Businessman(id, name, surname, birhtdate, address, email, phone, birhtplaceId, nationalityId);
    }

    @Override
    public List<Businessman> getAll() {
        List<Businessman> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from businessman");
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
            stmt.execute("select * from businessman where id = " + id);
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
}