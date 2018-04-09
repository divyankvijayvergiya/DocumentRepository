package com.example.documentrepository.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by divyankvijayvergiya on 09/04/18.
 */

public class MainItems implements Parcelable {

    String name;
    int image;

    public MainItems(){

    }

    public MainItems(String name, int image){
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public MainItems(Parcel in) {
        name = in.readString();
        image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MainItems> CREATOR = new Parcelable.Creator<MainItems>() {
        @Override
        public MainItems createFromParcel(Parcel in) {
            return new MainItems(in);
        }

        @Override
        public MainItems[] newArray(int size) {
            return new MainItems[size];
        }
    };
}