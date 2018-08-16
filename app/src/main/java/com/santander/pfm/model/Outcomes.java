
package com.santander.pfm.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outcomes {

    @SerializedName("prevision")
    @Expose
    private String prevision;
    @SerializedName("scheduled")
    @Expose
    private String scheduled;
    @SerializedName("current")
    @Expose
    private String current;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("categories")
    @Expose
    private List<Category_> categories = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Outcomes() {
    }

    /**
     * 
     * @param total
     * @param scheduled
     * @param prevision
     * @param current
     * @param categories
     */
    public Outcomes(String prevision, String scheduled, String current, String total, List<Category_> categories) {
        super();
        this.prevision = prevision;
        this.scheduled = scheduled;
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

    public Outcomes withPrevision(String prevision) {
        this.prevision = prevision;
        return this;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public Outcomes withScheduled(String scheduled) {
        this.scheduled = scheduled;
        return this;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Outcomes withCurrent(String current) {
        this.current = current;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Outcomes withTotal(String total) {
        this.total = total;
        return this;
    }

    public List<Category_> getCategories() {
        return categories;
    }

    public void setCategories(List<Category_> categories) {
        this.categories = categories;
    }

    public Outcomes withCategories(List<Category_> categories) {
        this.categories = categories;
        return this;
    }

}
