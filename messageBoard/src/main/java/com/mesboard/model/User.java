package com.mesboard.model;

public class User {
    private String acId;

    private String account;

    private String password;

    private String lastLoginTime;

    private String acOpenTime;

    private String acSts;

    private String lastLoginIp;

    public String getAcId() {
        return acId;
    }

    public void setAcId(String acId) {
        this.acId = acId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getAcOpenTime() {
        return acOpenTime;
    }

    public void setAcOpenTime(String acOpenTime) {
        this.acOpenTime = acOpenTime;
    }

    public String getAcSts() {
        return acSts;
    }

    public void setAcSts(String acSts) {
        this.acSts = acSts;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
}