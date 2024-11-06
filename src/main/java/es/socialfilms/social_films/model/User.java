package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID  = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews = new HashSet<>();

    //Constructors...

    public User(){}

    public User(String userName){
        this.userName = userName;
    }

    //Getter and Setter...

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    // Relationship: User 1-* Review

    public Set<Review> getReviews(){
        return reviews;
    }

    public void addReview(Review review){
        if(this.reviews.contains(review)) return;
        this.reviews.add(review);
        if(review.getUser() != this){
            review.setUser(this);
        }
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        if(id != null && user.id != null) return Objects.equals(id, user.id);
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(userName);
    }

}
