package com.example.librarymanage.Entity;

public class Account {
    private Integer id;
    private String username;
<<<<<<< Updated upstream
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "fullname")
    private String fullname;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "role")
    private String role;
    @ColumnInfo(name = "otp")
    private String otp;

    public User() {
    }

    public User(int userId, String username, String email, String password, String fullname, String phone, String address, String role, String otp) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.otp = otp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", otp='" + otp + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
=======
    private String password;
    private String email;
    private String dob;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(Integer id, String username, String password, String email, String dob) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
>>>>>>> Stashed changes
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

<<<<<<< Updated upstream
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

=======
>>>>>>> Stashed changes
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< Updated upstream
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
=======
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}

>>>>>>> Stashed changes
