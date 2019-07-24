package model;

public class Order {

    private int id;
    private String name;
    private String surname;
    private String newPostAdress;
    private int phoneNumber;
    private int basketId;
    private int userId;

    public Order(String name, String surname, String newPostAdress, int phoneNumber, int basketId) {
        this.name = name;
        this.surname = surname;
        this.newPostAdress = newPostAdress;
        this.phoneNumber = phoneNumber;
        this.basketId = basketId;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", newPostAdress='" + newPostAdress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", basketId=" + basketId +
                '}';
    }

}
