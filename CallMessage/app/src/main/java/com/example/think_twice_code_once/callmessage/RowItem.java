package com.example.think_twice_code_once.callmessage;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by think-twice-code-once on 31/1/17.
 */

public class RowItem extends AppCompatActivity {
    private String name;
    private String phoneNumber;


    public RowItem(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + "\n" + phoneNumber;
    }
}
