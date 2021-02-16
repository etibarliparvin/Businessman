package DaoInter;

import entity.Businessman;
import entity.Company;

import java.util.List;

public interface BusinessmanDaoInter {

    public List<Businessman> getAll();

    public Businessman getById(int id);

    public boolean update(Businessman b);

    public boolean add(Businessman b);

    public boolean remove(int id);

    public List<Company> getAllCompaniesByBusinessmanId(int userId);

}
