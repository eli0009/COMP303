package code;

import java.util.Arrays;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address a1 = new Address("Long Road", 1);
        Address a2 = (Address) a1.clone();
        a2.setNumber(2);
        a2.setStreet("Short Road");
        System.out.println(a1);
        System.out.println(a2);

        Person p1 = new Person(new String[] { "John", "Doe" }, a1);
        Person p2 = (Person) p1.clone();
        p2.setName(new String[] { "Jane", "Doe" });
        p2.getAddress().setNumber(3);
        p2.getAddress().setStreet("Another Road");
        System.out.println(p1);
        System.out.println(p2);
    }
}

class Address implements Cloneable {
    private String street;
    private int number;

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // shallow since fields are immutable
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "{" +
                " street='" + street + "'" +
                ", number='" + number + "'" +
                "}";
    }

}

class Person implements Cloneable {
    private String[] name;
    private Address address;

    public Person(String[] name, Address address) {
        this.name = name;
        this.address = address;
    }

    // deep copy, need to clone each field!
    @Override
    public Person clone() {
        return new Person(this.name.clone(), this.address.clone());
    }

    public String[] getName() {
        return this.name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + Arrays.toString(name) + "'" +
                ", address='" + address + "'" +
                "}";
    }
}
