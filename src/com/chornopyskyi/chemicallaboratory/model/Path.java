package com.chornopyskyi.chemicallaboratory.model;

public enum Path {
    USER_JSON("src//com//chornopyskyi//chemicallaboratory//repository//UserData.json");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
