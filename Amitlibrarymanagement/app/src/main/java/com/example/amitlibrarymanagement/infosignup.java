package com.example.amitlibrarymanagement;

public class infosignup {
    int id;
    String name;
    String email;
    String phone;
    String password;
    String confirmpass;

    infosignup(String name, String email, String phone, String password, String confirmpass){
        this.confirmpass  = confirmpass;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public infosignup() {

    }
    public int getId(){
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

    public String getPassword() {
        return password;
    }

    public String getConfirmpass() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmpass(String confirmpass) {
        this.confirmpass = password;
    }
}

