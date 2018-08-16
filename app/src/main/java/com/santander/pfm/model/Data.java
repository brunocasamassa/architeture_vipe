package com.santander.pfm.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("data")
    @Expose

    private List<Datum> data = null;

    /**
     * No args constructor for use in serialization
     */
    public Data() {
    }

    /**
     * @param data
     */
    public Data(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Data withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}
