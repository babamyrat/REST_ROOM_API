package com.example.rest_room_api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    @SerializedName("results")
    @Expose
    private List<Category> results = null;

    public List<Category> getResults() {
        return results;
    }

    public void setResults(List<Category> results) {
        this.results = results;
    }

}
