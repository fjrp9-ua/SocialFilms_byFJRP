package es.socialfilms.social_films.dto;

import java.util.Objects;

public class FilmData {
    
    private Long id;
    private String title;
    private int releaseYear;
    private int runningTime;
    private String country;
    private String synopsis;

    // Getters and Setters...

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public int getReleaseYear(){
        return releaseYear;
    }
    
    public void setReleaseYear(int releaseYear){
        this.releaseYear = releaseYear;
    }

    public int getRunningTime(){
        return runningTime;
    }
    
    public void setRunningTime(int runningTime){
        this.runningTime = runningTime;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof FilmData)) return false;

        FilmData filmData = (FilmData) o;
        return Objects.equals(this.getTitle(), filmData.getTitle());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle());
    }
}
