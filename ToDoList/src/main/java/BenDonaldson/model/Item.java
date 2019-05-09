package BenDonaldson.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    public Item(){

    }

    private String name;
    private boolean completed;
    //private Date dateAdded;
    private int userID;


    public Item(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
//    public Date getDateAdded() {
//        return dateAdded;
//    }
//    public void setDateAdded(Date dateAdded) {
//        this.dateAdded = dateAdded;
//    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public long getId() {
        return id;
    }

    private int listType;
    public void setListType(int listType){ this.listType=listType;}
    public int getListType() {
        return listType;
    }
}




