package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();


    String getContent();

    String getName();

    default String getStringRepresentation() {
        return "Имя " + getName() + " - тип" + getContent();
    }
}
