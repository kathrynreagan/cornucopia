package com.thoughtworks.cornucopia;

import com.google.gson.annotations.SerializedName;


public class Recipe {

    private final String title;
    @SerializedName("source_url") private final String url;
    @SerializedName("image_url") private final String imageUrl;

    public Recipe(String title, String url, String imageUrl) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (title != null ? !title.equals(recipe.title) : recipe.title != null) return false;
        return url != null ? url.equals(recipe.url) : recipe.url == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
