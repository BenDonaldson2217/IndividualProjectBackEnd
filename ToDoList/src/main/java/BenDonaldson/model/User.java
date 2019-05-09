package BenDonaldson.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {return password;};

    private String userName;
    private String password;

    public User() {

    };

    public User(String userName, String password) {
        this.userName=userName;
        this.password=password;
    }

}
