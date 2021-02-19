package Dao.Inter;

import entity.Country;

import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll();

    public Country getById(int userId);

    public Country betByName(String name);

    public boolean update(Country country);

    public boolean add(Country country);

    public boolean remove(int userId);

}
