package com.boylab.tablescale.calib.bean;

import java.util.Arrays;

public class ParaUnit {

    public static final int INPUT = 0, SELECT = 1;

    private String label;
    private int value;
    private int action;     //INPUT 、SELECT
    private String[] showValues;

    public ParaUnit(String label, int action, int value, String[] showValues) {
        this.label = label;
        this.value = value;
        this.action = action;
        this.showValues = showValues;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSelectValues() {
        return showValues[value];
    }

    public String[] getShowValues() {
        return showValues;
    }

    public void setShowValues(String[] showValues) {
        this.showValues = showValues;
    }

    @Override
    public String toString() {
        return "ParaUnit{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", action=" + action +
                ", showValues=" + Arrays.toString(showValues) +
                '}';
    }
}
