package es.socialfilms.social_films.dto;

import java.util.Objects;

public class ReviewData {
    
    private Long id;
    private String review;
    private float rating;

    // Getters and Setters ...

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getReview(){
        return review;
    }

    public void setReview(String review){
        this.review = review;
    }

    public float getRating(){
        return rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    // Overrides ...

    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof ReviewData)) return false;

        ReviewData reviewData = (ReviewData) o;
        return Objects.equals(this.getReview(), reviewData.getReview());
    }

    public int hashCode(){
        return Objects.hash(getReview(), getRating());
    }
}
