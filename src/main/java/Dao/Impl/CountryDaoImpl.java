package Dao.Impl;

import Dao.Inter.AbstractDao;
import Dao.Inter.CountryDaoInter;
import entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    private Country getCountry(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String countryName = rs.getString("country_name");
        String nationality = rs.getString("nationality");
        return new Country(id, countryName, nationality);
    }

    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result.add(getCountry(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Country getById(int userId) {
        Country result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where id = " + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Country betByName(String name) {
        Country result = null;
        try {
            Connection c = connect();
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where country_name = " + name);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getCountry(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Country country) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("update country set country_name = ?, nationality = ? where id = ?");
            stmt.setString(1, country.getCountryName());
            stmt.setString(2, country.getNationality());
            stmt.setInt(3, country.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean add(Country country) {
        try {
            Connection c = connect();
            PreparedStatement stmt = c.prepareStatement("insert into country (country_name, nationality) values(?,?)");
            stmt.setString(1, country.getCountryName());
            stmt.setString(2, country.getNationality());
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
            return stmt.execute("delete from country where id = " + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
