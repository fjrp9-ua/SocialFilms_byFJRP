package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "directors")
public class Director implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String country;

    @Temporal(TemporalType.DATE)
    private Date born;

    @OneToMany(mappedBy = "director")
    private Set<Film> films = new HashSet<>();

    // Constructors...

    public Director(){}
    
    public Director(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

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

    public Set<Film> getFilms(){
        return films;
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;
        if(id != null && director.id != null) return Objects.equals(id, director.id);
        return name.equals(director.name) && lastName.equals(director.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, lastName);
    }
}
