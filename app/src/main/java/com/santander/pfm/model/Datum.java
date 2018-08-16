package com.santander.pfm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("currentMonth")
    @Expose
    private Boolean currentMonth;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("periodFrom")
    @Expose
    private String periodFrom;
    @SerializedName("periodTo")
    @Expose
    private String periodTo;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("incomes")
    @Expose
    private Incomes incomes;
    @SerializedName("outcomes")
    @Expose
    private Outcomes outcomes;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param outcomes
     * @param result
     * @param periodTo
     * @param name
     * @param incomes
     * @param currentMonth
     * @param periodFrom
     */
    public Datum(Boolean currentMonth, String name, String periodFrom, String periodTo, Result result, Incomes incomes, Outcomes outcomes) {
        super();
        this.currentMonth = currentMonth;
        this.name = name;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
        this.result = result;
        this.incomes = incomes;
        this.outcomes = outcomes;
    }

    public Boolean getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(Boolean currentMonth) {
        this.currentMonth = currentMonth;
    }

    public Datum withCurrentMonth(Boolean currentMonth) {
        this.currentMonth = currentMonth;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Datum withName(String name) {
        this.name = name;
        return this;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Datum withPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
        return this;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }

    public Datum withPeriodTo(String periodTo) {
        this.periodTo = periodTo;
        return this;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Datum withResult(Result result) {
        this.result = result;
        return this;
    }

    public Incomes getIncomes() {
        return incomes;
    }

    public void setIncomes(Incomes incomes) {
        this.incomes = incomes;
    }

    public Datum withIncomes(Incomes incomes) {
        this.incomes = incomes;
        return this;
    }

    public Outcomes getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Outcomes outcomes) {
        this.outcomes = outcomes;
    }

    public Datum withOutcomes(Outcomes outcomes) {
        this.outcomes = outcomes;
        return this;
    }

}
