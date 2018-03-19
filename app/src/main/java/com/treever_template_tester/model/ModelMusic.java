package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.treever_template_tester.comman.Constants;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelMusic implements Parcelable {

    @SerializedName("music_file_object_key")
    String musicObjectKey;


    @SerializedName("music_file_id")
    private  int musicCloudID = 0;

    @SerializedName("music_file_mood")
    int musicMood;

    private  String musicLink = "";



    private  int local_id = 0;

    private int iss_asset = 0;


    public String getMusicObjectKey() {
        return musicObjectKey;
    }

    public void setMusicObjectKey(String musicObjectKey) {
        this.musicObjectKey = musicObjectKey;
        if(musicObjectKey!= null){
            this.musicLink = Constants.MUSIC_BASE_URL+musicObjectKey;
        }
    }

    public int getMusicMood() {
        return musicMood;
    }

    public void setMusicMood(int musicMood) {
        this.musicMood = musicMood;
    }



    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public int getMusicCloudID() {
        return musicCloudID;
    }

    public void setMusicCloudID(int musicCloudID) {
        this.musicCloudID = musicCloudID;
    }

    public String getMusicLink() {
       return musicLink;
    }

    public void setMusicLink(String musicLink) {
        this.musicLink = musicLink;
    }

    public int getIss_asset() {

        return iss_asset;
    }

    public void setIss_asset(int iss_asset) {
        this.iss_asset = iss_asset;
    }


    public ModelMusic() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.musicObjectKey);
        dest.writeInt(this.musicCloudID);
        dest.writeInt(this.musicMood);
        dest.writeString(this.musicLink);
        dest.writeInt(this.local_id);
        dest.writeInt(this.iss_asset);
    }

    protected ModelMusic(Parcel in) {
        this.musicObjectKey = in.readString();
        this.musicCloudID = in.readInt();
        this.musicMood = in.readInt();
        this.musicLink = in.readString();
        this.local_id = in.readInt();
        this.iss_asset = in.readInt();
    }

    public static final Creator<ModelMusic> CREATOR = new Creator<ModelMusic>() {
        @Override
        public ModelMusic createFromParcel(Parcel source) {
            return new ModelMusic(source);
        }

        @Override
        public ModelMusic[] newArray(int size) {
            return new ModelMusic[size];
        }
    };
}
