package com.example.dataBinding2;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class User extends BaseObservable {
    private String firstName,lastName;

    public User(String firstName, String lastName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    @Bindable
    public String getFirstName() { return firstName; }
    @Bindable
    public String getLastName() { return lastName; }

    void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }
    void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
