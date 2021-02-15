package entity;

public class Company {
    private Integer id;
    private String companyName;
    private Integer businessmanId;
    private Integer locationId;

    public Company() {
    }

    public Company(Integer id, String companyName, Integer businessmanId, Integer locationId) {
        this.id = id;
        this.companyName = companyName;
        this.businessmanId = businessmanId;
        this.locationId = locationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getBusinessmanId() {
        return businessmanId;
    }

    public void setBusinessmanId(Integer businessmanId) {
        this.businessmanId = businessmanId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", businessmanId=" + businessmanId +
                ", locationId=" + locationId +
                '}';
    }
}
