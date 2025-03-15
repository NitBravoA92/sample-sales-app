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
}
