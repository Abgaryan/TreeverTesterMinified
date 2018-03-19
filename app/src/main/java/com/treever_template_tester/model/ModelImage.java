package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelImage implements Parcelable {
    private int id;
    private String path;
    private Long mediaTakenDateMillis;
    private String duration;
    private String file_name;
    private String title;
    private String bucket;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public Long getMediaTakenDateMillis() {
        return mediaTakenDateMillis;
    }

    public void setMediaTakenDateMillis(Long mediaTakenDateMillis) {
        this.mediaTakenDateMillis = mediaTakenDateMillis;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.path);
        dest.writeValue(this.mediaTakenDateMillis);
        dest.writeString(this.duration);
        dest.writeString(this.file_name);
        dest.writeString(this.title);
        dest.writeString(this.bucket);
    }

    public ModelImage() {
    }

    protected ModelImage(Parcel in) {
        this.id = in.readInt();
        this.path = in.readString();
        this.mediaTakenDateMillis = (Long) in.readValue(Long.class.getClassLoader());
        this.duration = in.readString();
        this.file_name = in.readString();
        this.title = in.readString();
        this.bucket = in.readString();
    }

    public static final Parcelable.Creator<ModelImage> CREATOR = new Parcelable.Creator<ModelImage>() {
        @Override
        public ModelImage createFromParcel(Parcel source) {
            return new ModelImage(source);
        }

        @Override
        public ModelImage[] newArray(int size) {
            return new ModelImage[size];
        }
    };
}
