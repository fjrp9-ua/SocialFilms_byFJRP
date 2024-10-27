package es.socialfilms.social_films.dto;

import java.util.Objects;

public class UserData {

    private Long id;
    private String userName;
    private String password;
    private String email;

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof UserData)) return false;
        UserData userData = (UserData) o;
        return Objects.equals(getId(), userData.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getId());
    }

}
