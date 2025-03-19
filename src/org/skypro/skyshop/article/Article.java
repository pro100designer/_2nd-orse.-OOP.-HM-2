package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Название продукта "+title+"\n"+
                "Описание продукта "+ content;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }
}
