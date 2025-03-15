package com.softwaredevone.sample_sales_app.serialization;

public class Pagination {
    private int page;
    private int pageSize;

    public Pagination(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
}
