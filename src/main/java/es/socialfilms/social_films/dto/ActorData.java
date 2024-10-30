package es.socialfilms.social_films.dto;

import java.util.*;

public class ActorData {

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
        if(!(o instanceof ActorData)) return false;

        ActorData actorData = (ActorData) o;
        return Objects.equals(this.name, actorData.getName()) && Objects.equals(this.lastName, actorData.getLastName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, lastName);
    }
}
