package com.softwaredevone.sample_sales_app.serialization;

import java.util.List;

public class ApiResponse<T> {

    private List<T> data;
    private int totalRecords;
    private Pagination pagination;

    public ApiResponse(List<T> data, int totalRecords, Pagination pagination) {
        this.data = data;
        this.totalRecords = totalRecords;
        this.pagination = pagination;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
