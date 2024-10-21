package com.mycompany.musicapp.model;

public class Model_Category {

    private int CategoryID;
    private String TitleCategory;
    private String ImagePathCategory;

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getTitleCategory() {
        return TitleCategory;
    }

    public void setTitleCategory(String TitleCategory) {
        this.TitleCategory = TitleCategory;
    }

    public String getImagePathCategory() {
        return ImagePathCategory;
    }

    public void setImagePathCategory(String ImagePathCategory) {
        this.ImagePathCategory = ImagePathCategory;
    }

    public Model_Category(int CategoryID, String TitleCategory, String ImagePathCategory) {
        this.CategoryID = CategoryID;
        this.TitleCategory = TitleCategory;
        this.ImagePathCategory = ImagePathCategory;
    }

}
