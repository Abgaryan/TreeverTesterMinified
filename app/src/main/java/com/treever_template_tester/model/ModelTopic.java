package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelTopic implements Parcelable {
    private int topicId;
    private String topicName;

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.topicId);
        dest.writeString(this.topicName);
    }

    public ModelTopic() {
    }

    protected ModelTopic(Parcel in) {
        this.topicId = in.readInt();
        this.topicName = in.readString();
    }

    public static final Parcelable.Creator<ModelTopic> CREATOR = new Parcelable.Creator<ModelTopic>() {
        @Override
        public ModelTopic createFromParcel(Parcel source) {
            return new ModelTopic(source);
        }

        @Override
        public ModelTopic[] newArray(int size) {
            return new ModelTopic[size];
        }
    };
}
