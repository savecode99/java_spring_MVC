package com.bavung.javaMVC.model;

import com.bavung.javaMVC.Service.validator.RegisterChecked;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RegisterChecked
public class RegisterDTO {
    @NotNull
    private String firstName ;
    @NotNull
    private String lastName ;
    @NotNull
    @Email(message = "Vui lòng điền email của bạn", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email ;
    // /@StrongPassword
    @NotNull
    @Size(min = 2 , message = "Cần tối thiểu 3 ký tự")
    private String passWord ;
    @NotNull
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
