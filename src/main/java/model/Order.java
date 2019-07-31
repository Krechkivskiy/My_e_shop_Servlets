package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "new_post_adress")
    private String newPostAdress;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "isConfirmed")
    private boolean isConfirmed;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Basket basket;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private User user;

    public Order() {
    }

    public Order(String name, String surname, String newPostAdress, int phoneNumber, boolean isConfirmed, Basket basket, User user) {
        this.name = name;
        this.surname = surname;
        this.newPostAdress = newPostAdress;
        this.phoneNumber = phoneNumber;
        this.isConfirmed = isConfirmed;
        this.basket = basket;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPostAdress() {
        return newPostAdress;
    }

    public void setNewPostAdress(String newPostAdress) {
        this.newPostAdress = newPostAdress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", newPostAdress='" + newPostAdress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", basket=" + basket +
                '}';
    }

}
