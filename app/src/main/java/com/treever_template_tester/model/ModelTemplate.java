package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelTemplate implements Parcelable {

    @SerializedName("treever_template_active")
    private int is_active = 1;

    @SerializedName("treever_template_body")
    private String template_body;

    @SerializedName("treever_template_mood")
    private String mood;

    @SerializedName("treever_template_image_count")
    private int image_count;


    @SerializedName("treever_template_title")
    private String file_name;


    @SerializedName("treever_template_status")
    private int status = 0;

    @SerializedName("treever_template_id")
    private int template_cloud_id = 0;




    private int template_id;


    private String original_file_name;

    private int is_asset = 0;



    public int getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }

    public int getTemplate_cloud_id() {
        return template_cloud_id;
    }

    public void setTemplate_cloud_id(int template_cloud_id) {
        this.template_cloud_id = template_cloud_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getTemplate_body() {
        return template_body;
    }

    public void setTemplate_body(String template_body) {
        this.template_body = template_body;
    }

    public String getOriginal_file_name() {
        return original_file_name;
    }

    public void setOriginal_file_name(String original_file_name) {
        this.original_file_name = original_file_name;
    }

    public int getImage_count() {
        return image_count;
    }

    public void setImage_count(int image_count) {
        this.image_count = image_count;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getIs_asset() {
        return is_asset;
    }

    public void setIs_asset(int is_asset) {
        this.is_asset = is_asset;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.template_id);
        dest.writeInt(this.template_cloud_id);
        dest.writeString(this.file_name);
        dest.writeString(this.template_body);
        dest.writeString(this.original_file_name);
        dest.writeInt(this.image_count);
        dest.writeString(this.mood);
        dest.writeInt(this.is_asset);
        dest.writeInt(this.status);
        dest.writeInt(this.is_active);
    }



    protected ModelTemplate(Parcel in) {
        this.template_id = in.readInt();
        this.template_cloud_id = in.readInt();
        this.file_name = in.readString();
        this.template_body = in.readString();
        this.original_file_name = in.readString();
        this.image_count = in.readInt();
        this.mood = in.readString();
        this.is_asset = in.readInt();
        this.status = in.readInt();
        this.is_active = in.readInt();
    }

    public ModelTemplate(){

    }




    public static final Parcelable.Creator<ModelTemplate> CREATOR = new Parcelable.Creator<ModelTemplate>() {
        @Override
        public ModelTemplate createFromParcel(Parcel source) {
            return new ModelTemplate(source);
        }

        @Override
        public ModelTemplate[] newArray(int size) {
            return new ModelTemplate[size];
        }
    };
}
