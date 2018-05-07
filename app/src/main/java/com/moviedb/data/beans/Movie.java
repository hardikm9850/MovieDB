package com.moviedb.data.beans;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hardik on 01/11/17.
 */

public class Movie {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Movie(){

    }

    public Movie(Integer page, Integer totalResults, Integer totalPages, List<Result> results, int protectedVar) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
        this.protectedVar = protectedVar;
    }

    public int getProtectedVar() {
        return protectedVar;
    }

    public void setProtectedVar(int protectedVar) {
        this.protectedVar = protectedVar;
    }

    protected int protectedVar;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


    private static void iamprivate(){

    }

    public static void iamstatic(){

    }


}