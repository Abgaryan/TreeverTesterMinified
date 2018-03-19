package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Abgaryan on 3/19/18.
 */

public class ServerDataModel implements Parcelable {
    @SerializedName("templates")
    private ArrayList<ModelTemplate> modelTemplates;

    @SerializedName("backgrounds")
    private ArrayList<ModelBackgroundImage> modelBackgroundImages;

    @SerializedName("music")
    private ArrayList<ModelMusic> modelMusics;

    @SerializedName("quotes")
    private ArrayList<ModelQuote> modelQuotes;

    @SerializedName("topics")
    private ArrayList<ModelTopic> modelTopics;

    @Expose
    private int timestamp;


    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }



    public ArrayList<ModelTemplate> getModelTemplates() {
        return modelTemplates;
    }

    public void setModelTemplates(ArrayList<ModelTemplate> modelTemplates) {
        this.modelTemplates = modelTemplates;
    }

    public ArrayList<ModelBackgroundImage> getModelBackgroundImages() {
        return modelBackgroundImages;
    }

    public void setModelBackgroundImages(ArrayList<ModelBackgroundImage> modelBackgroundImages) {
        this.modelBackgroundImages = modelBackgroundImages;
    }

    public ArrayList<ModelMusic> getModelMusics() {
        return modelMusics;
    }

    public void setModelMusics(ArrayList<ModelMusic> modelMusics) {
        this.modelMusics = modelMusics;
    }

    public ArrayList<ModelQuote> getModelQuotes() {
        return modelQuotes;
    }

    public void setModelQuotes(ArrayList<ModelQuote> modelQuotes) {
        this.modelQuotes = modelQuotes;
    }

    public ArrayList<ModelTopic> getModelTopics() {
        return modelTopics;
    }

    public void setModelTopics(ArrayList<ModelTopic> modelTopics) {
        this.modelTopics = modelTopics;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.modelTemplates);
        dest.writeTypedList(this.modelBackgroundImages);
        dest.writeTypedList(this.modelMusics);
        dest.writeTypedList(this.modelQuotes);
        dest.writeTypedList(this.modelTopics);
        dest.writeInt(this.timestamp);
    }

    public ServerDataModel() {
    }

    protected ServerDataModel(Parcel in) {
        this.modelTemplates = in.createTypedArrayList(ModelTemplate.CREATOR);
        this.modelBackgroundImages = in.createTypedArrayList(ModelBackgroundImage.CREATOR);
        this.modelMusics = in.createTypedArrayList(ModelMusic.CREATOR);
        this.modelQuotes = in.createTypedArrayList(ModelQuote.CREATOR);
        this.modelTopics = in.createTypedArrayList(ModelTopic.CREATOR);
        this.timestamp = in.readInt();
    }

    public static final Parcelable.Creator<ServerDataModel> CREATOR = new Parcelable.Creator<ServerDataModel>() {
        @Override
        public ServerDataModel createFromParcel(Parcel source) {
            return new ServerDataModel(source);
        }

        @Override
        public ServerDataModel[] newArray(int size) {
            return new ServerDataModel[size];
        }
    };
}
