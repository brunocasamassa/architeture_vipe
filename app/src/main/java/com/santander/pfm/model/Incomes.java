
package com.santander.pfm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Incomes {

    @SerializedName("prevision")
    @Expose
    private String prevision;
    @SerializedName("current")
    @Expose
    private String current;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Incomes() {
    }

    /**
     * 
     * @param total
     * @param prevision
     * @param current
     * @param categories
     */
    public Incomes(String prevision, String current, String total, List<Category> categories) {
        super();
        this.prevision = prevision;
        this.current = current;
        this.total = total;
        this.categories = categories;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public Incomes withPrevision(String prevision) {
        this.prevision = prevision;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Incomes withCurrent(String current) {
        this.current = current;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Incomes withTotal(String total) {
        this.total = total;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Incomes withCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

}
