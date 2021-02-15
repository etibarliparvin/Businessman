package entity;

public class Company {
    private Integer id;
    private String companyName;
    private Integer businessmanId;
    private Integer locationId;
    private Country countryName;

    public Company() {
    }

    public Company(Integer id, String companyName, Integer businessmanId, Integer locationId, Country countryName) {
        this.id = id;
        this.companyName = companyName;
        this.businessmanId = businessmanId;
        this.locationId = locationId;
        this.countryName = countryName;
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

    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(Country countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", businessmanId=" + businessmanId +
                ", locationId=" + locationId +
                ", countryName=" + countryName +
                '}';
    }
}
