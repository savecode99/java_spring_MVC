package com.bavung.javaMVC.model;

import jakarta.validation.constraints.NotBlank;

public class PasswordDTO {
    @NotBlank(message = "Vui lòng nhập mật khẩu hiện tại")
    private String oldPassword;
    @NotBlank(message = "Vui lòng nhập mật khẩu mới")
    private String newPassword;
    @NotBlank(message = "Vui lòng xác nhận mật khẩu mới")
    private String confirmNewPassword;
    public String getOldPassword() {
        return oldPassword;
    }
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }
    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
    
}
