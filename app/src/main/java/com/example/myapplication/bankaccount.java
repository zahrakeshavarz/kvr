package com.example.myapplication;

public class bankaccount {
    private int id;

    public int getId() {
        return id;
    }

    public String getCardnum() {
        return cardnum;
    }

    public int getPassword() {
        return password;
    }

    public int getPass2() {
        return pass2;
    }

    private String cardnum;
    private int password;
    private int pass2;
    private int credit;

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public bankaccount(String cardnum, int password, int pass2, int credit) {
        this.cardnum = cardnum;
        this.password = password;
        this.pass2 = pass2;
        this.credit = credit;
    }
}
