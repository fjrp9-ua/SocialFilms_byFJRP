package es.socialfilms.social_films.dto;

import java.util.Date;
import java.util.Objects;

public class DirectorData {
private Long id;

    private String name;
    private String lastName;
    private String country;
    private Date born;

    // Getters and Setters

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof DirectorData)) return false;

        DirectorData directorData = (DirectorData) o;
        return Objects.equals(this.name, directorData.getName()) && Objects.equals(this.lastName, directorData.getLastName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, lastName);
    }
}
