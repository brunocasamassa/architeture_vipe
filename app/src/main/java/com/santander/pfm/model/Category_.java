
package com.santander.pfm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("color")
    @Expose
    private String color;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category_() {
    }

    /**
     * 
     * @param icon
     * @param color
     * @param name
     * @param value
     */
    public Category_(String name, String value, String icon, String color) {
        super();
        this.name = name;
        this.value = value;
        this.icon = icon;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category_ withName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Category_ withValue(String value) {
        this.value = value;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Category_ withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category_ withColor(String color) {
        this.color = color;
        return this;
    }

}
