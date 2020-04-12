package com.hfad.notesaver;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Note implements Parcelable {

    private String date;
    private String note;

    public static final ArrayList<Note> noteList = new ArrayList<>();

    public Note() {
    }

    public Note(String date, String note) {
        this.date = date;
        this.note = note;
    }

    protected Note(Parcel in) {
        date = in.readString();
        note = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    @Override
    public String toString() {
//        return "Note{" +
//                "date='" + date + '\'' +
//                ", note='" + note + '\'' +
//                '}';
        return "Note:" + "\n" + date + "\n" + note;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(note);
    }
}
