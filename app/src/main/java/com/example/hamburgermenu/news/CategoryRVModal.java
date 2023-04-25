package com.example.hamburgermenu.news;

public class CategoryRVModal {
    private String category;
    private String categoryImportUrl;

    public CategoryRVModal(String category, String categoryImportUrl) {
        this.category = category;
        this.categoryImportUrl = categoryImportUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryImportUrl() {
        return categoryImportUrl;
    }

}
