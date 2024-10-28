package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new HashSet<>();
    
    // Constructors...

    public Genre(){}
    
    public Genre(String name){
        this.name = name;
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

    public Set<Film> getFilms(){
        return films;
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;
        if(id != null && genre.id != null) return Objects.equals(id, genre.id);
        return name.equals(genre.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}