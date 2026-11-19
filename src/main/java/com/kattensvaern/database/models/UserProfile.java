
package com.kattensvaern.database.models;

public class UserProfile {

    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String address;
    private boolean member;
    private String membershipNumber;

    public UserProfile(int id, String name, String email,
                       String phone, int age, String address,
                       boolean member, String membershipNumber) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.member = member;
        this.membershipNumber = membershipNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean isMember() {
        return member;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }
}
