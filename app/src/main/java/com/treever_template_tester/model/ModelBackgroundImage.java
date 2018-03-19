package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.treever_template_tester.comman.Constants;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelBackgroundImage implements Parcelable {

    @Expose
    private int is_disabled = 0;

    @Expose
    private int mood;

    @Expose
    private String file;

    @Expose
    private int background_id;

    private int background_local_id;


    private String background_url = "";


    public String getBackground_url() {
        return background_url;
    }

    public void setBackground_url(String background_url) {
        this.background_url = background_url;
    }




    public int getBackground_id() {
        return background_id;
    }

    public void setBackground_id(int background_id) {
        this.background_id = background_id;
    }

    public int getBackground_local_id() {
        return background_local_id;
    }

    public void setBackground_local_id(int background_local_id) {
        this.background_local_id = background_local_id;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
        if(file != null){
            this.background_url = Constants.BACKGROUDS_BASE_URL +file;
        }
    }

    public int getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(int is_disabled) {
        this.is_disabled = is_disabled;
    }


    public ModelBackgroundImage() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.is_disabled);
        dest.writeInt(this.mood);
        dest.writeString(this.file);
        dest.writeInt(this.background_id);
        dest.writeInt(this.background_local_id);
        dest.writeString(this.background_url);
    }

    protected ModelBackgroundImage(Parcel in) {
        this.is_disabled = in.readInt();
        this.mood = in.readInt();
        this.file = in.readString();
        this.background_id = in.readInt();
        this.background_local_id = in.readInt();
        this.background_url = in.readString();
    }

    public static final Creator<ModelBackgroundImage> CREATOR = new Creator<ModelBackgroundImage>() {
        @Override
        public ModelBackgroundImage createFromParcel(Parcel source) {
            return new ModelBackgroundImage(source);
        }

        @Override
        public ModelBackgroundImage[] newArray(int size) {
            return new ModelBackgroundImage[size];
        }
    };
}
