package com.treever_template_tester.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Abgaryan on 3/13/18.
 */

public class ModelQuote implements Parcelable {

    @Expose
    private int quote_id;

    @Expose
    private int is_disabled;

    @Expose
    private String quote;

    @SerializedName("mood")
    private int quote_mood;

    private int quote_local_id = 0;


    public int getQuote_mood() {
        return quote_mood;
    }

    public void setQuote_mood(int quote_mood) {
        this.quote_mood = quote_mood;
    }



    public int getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(int quote_id) {
        this.quote_id = quote_id;
    }

    public int getQuote_local_id() {
        return quote_local_id;
    }

    public void setQuote_local_id(int quote_local_id) {
        this.quote_local_id = quote_local_id;
    }



    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }




    public int getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(int is_disabled) {
        this.is_disabled = is_disabled;
    }


    public ModelQuote() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.quote_id);
        dest.writeInt(this.is_disabled);
        dest.writeString(this.quote);
        dest.writeInt(this.quote_mood);
        dest.writeInt(this.quote_local_id);
    }

    protected ModelQuote(Parcel in) {
        this.quote_id = in.readInt();
        this.is_disabled = in.readInt();
        this.quote = in.readString();
        this.quote_mood = in.readInt();
        this.quote_local_id = in.readInt();
    }

    public static final Creator<ModelQuote> CREATOR = new Creator<ModelQuote>() {
        @Override
        public ModelQuote createFromParcel(Parcel source) {
            return new ModelQuote(source);
        }

        @Override
        public ModelQuote[] newArray(int size) {
            return new ModelQuote[size];
        }
    };
}
