package entity;

import java.sql.Date;
import java.util.List;

public class Businessman {
    private Integer id;
    private String name;
    private String surname;
    private Date birthdate;
    private String address;
    private String email;
    private String phone;
    private Integer birthplaceId;
    private Integer nationalityId;
    private Country countryName;
    private Country nationality;
    private List<Company> companies;

    public Businessman() {
    }

    public Businessman(Integer id, String name, String surname, Date birthdate, String address, String email, String phone, Integer birthplaceId, Integer nationalityId, Country countryName, Country nationality, List<Company> companies) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.birthplaceId = birthplaceId;
        this.nationalityId = nationalityId;
        this.countryName = countryName;
        this.nationality = nationality;
        this.companies = companies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBirthplaceId() {
        return birthplaceId;
    }

    public void setBirthplaceId(Integer birthplaceId) {
        this.birthplaceId = birthplaceId;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Country getCountryName() {
        return countryName;
    }

    public void setCountryName(Country countryName) {
        this.countryName = countryName;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "Businessman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthplaceId=" + birthplaceId +
                ", nationalityId=" + nationalityId +
                ", countryName=" + countryName +
                ", nationality=" + nationality +
                ", companies=" + companies +
                '}';
    }
}
