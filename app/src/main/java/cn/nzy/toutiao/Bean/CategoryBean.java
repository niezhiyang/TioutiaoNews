package cn.nzy.toutiao.Bean;

import java.io.Serializable;

public class CategoryBean implements Serializable {
    private String title;
    private String category;

    public CategoryBean(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}