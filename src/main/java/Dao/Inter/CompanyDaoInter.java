package Dao.Inter;

import entity.Company;

import java.util.List;

public interface CompanyDaoInter {

    public List<Company> getAll();

    public Company getById(int userId);

    public Company getByName(String name);

    public boolean update(Company company);

    public boolean add(Company company);

    public boolean removeById(int userId);

    public boolean removeByName(String name);

    public List<Company> getAllCompaniesByBusinessmanId(int userId);
}
