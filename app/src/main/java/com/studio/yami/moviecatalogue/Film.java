package com.studio.yami.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int poster;
    private String title;
    private String date;
    private int score;
    private String runtime;
    private String budget;
    private String genre;
    private String overview;

    public Film(int poster, String title, String date, int score, String runtime, String budget, String genre, String overview) {
        this.poster = poster;
        this.title = title;
        this.date = date;
        this.score = score;
        this.runtime = runtime;
        this.budget = budget;
        this.genre = genre;
        this.overview = overview;
    }

    public int getPoster() {
        return poster;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getBudget() {
        return budget;
    }

    public String getGenre() {
        return genre;
    }

    public String getOverview() {
        return overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeInt(this.score);
        dest.writeString(this.runtime);
        dest.writeString(this.budget);
        dest.writeString(this.genre);
        dest.writeString(this.overview);
    }

    protected Film(Parcel in) {
        this.poster = in.readInt();
        this.title = in.readString();
        this.date = in.readString();
        this.score = in.readInt();
        this.runtime = in.readString();
        this.budget = in.readString();
        this.genre = in.readString();
        this.overview = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
