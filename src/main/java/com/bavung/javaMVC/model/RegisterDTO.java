package com.bavung.javaMVC.model;

import com.bavung.javaMVC.Service.validator.RegisterChecked;
import com.bavung.javaMVC.Service.validator.StrongPassword;

@RegisterChecked
public class RegisterDTO {
    private String firstName ;
    private String lastName ;
    private String email ;
    @StrongPassword
    private String passWord ;
    private String confirmPassWord ;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getConfirmPassWord() {
        return confirmPassWord;
    }
    public void setConfirmPassWord(String confirmPassWord) {
        this.confirmPassWord = confirmPassWord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisterDTO{");
        sb.append("firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", passWord=").append(passWord);
        sb.append(", confirmPassWord=").append(confirmPassWord);
        sb.append('}');
        return sb.toString();
    }

   

}
