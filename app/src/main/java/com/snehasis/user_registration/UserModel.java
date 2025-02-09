package com.snehasis.user_registration;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    private String name;
    private String occupation;
    private String degree;
    private int score;
    private String country;


    //default constructor
    public UserModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
        this.name = "";
        this.occupation = "";
        this.degree = "";
        this.score = 0;
        this.country = "";
    }

    //parameterized constructor
    public UserModel(String name, String occupation, String degree, int score, String country) {
        this.name = name;
        this.occupation = occupation;
        this.degree = degree;
        this.score = score;
        this.country = country;
    }

    //parcelable read
    protected UserModel (Parcel in) {
        name = in.readString();
        occupation = in.readString();
        degree = in.readString();
        score = in.readInt();
        country = in.readString();
    }

    //handling descriptor
    @Override
    public int describeContents() {
        return 0;
    }

    //parcelable write
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(occupation);
        parcel.writeString(degree);
        parcel.writeInt(score);
        parcel.writeString(country);
    }

    //used to create objects on the intent activity
    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };


    // Getters
    public void setName(String name) {
        this.name = name;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setCountry(String country) {
        this.country = country;

    }

    //Setters
    public String getName() {
        return name;
    }
    public String getOccupation() {
        return occupation;
    }
    public String getDegree() {
        return degree;
    }
    public int getScore() {
        return score;
    }
    public String getCountry() {
        return country;
    }

}
