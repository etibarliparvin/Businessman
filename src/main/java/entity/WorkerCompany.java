package entity;

public class WorkerCompany {
    private Integer id;
    private Company company;
    private Worker worker;
    private Double salary;

    public WorkerCompany() {
    }

    public WorkerCompany(Integer id, Company company, Worker worker, Double salary) {
        this.id = id;
        this.company = company;
        this.worker = worker;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "WorkerCompany{" +
                "id=" + id +
                ", company=" + company +
                ", worker=" + worker +
                ", salary=" + salary +
                '}';
    }
}
