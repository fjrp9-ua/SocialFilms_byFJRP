package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    
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

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();

    // Constructors...

    public Actor(){}
    
    public Actor(String name, String lastName){
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

    public Date getborn() {
        return born;
    }

    public void setborn(Date born) {
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

        Actor actor = (Actor) o;
        if(id != null && actor.id != null) return Objects.equals(id, actor.id);
        return name.equals(actor.name) && lastName.equals(actor.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, lastName);
    }
}
