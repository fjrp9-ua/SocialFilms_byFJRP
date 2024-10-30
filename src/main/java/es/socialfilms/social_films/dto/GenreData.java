package es.socialfilms.social_films.dto;

import java.util.Objects;

public class GenreData {

    private Long id;
    private String name;

    // Getters and Setters...

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

    // Overrides

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof GenreData)) return false;
        GenreData genreData = (GenreData) o;
        return Objects.equals(this.name, genreData.getName());
    }

    @Override 
    public int hashCode(){
        return Objects.hash(this.getName());
    }
}
