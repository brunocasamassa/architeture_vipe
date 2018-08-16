package com.santander.pfm.model;

import java.util.List;

public class CategoryModel {

    private String id;
    private String label;
    private String value;
    private String icon;

    private List<SubCategoryModel> subcategories;

    public CategoryModel() {

    }

    public List<SubCategoryModel> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategoryModel> subcategories) {
        this.subcategories = subcategories;
    }

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
