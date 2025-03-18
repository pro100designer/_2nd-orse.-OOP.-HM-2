package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    public Searchable[] searchables;
    public int size;

    public SearchEngine(int capacity) {
        searchables=new Searchable[capacity];
        size=0;
    }

    public Searchable[] search(String search) {
        Searchable[] results = new Searchable[5];
        int resultsCount=0;
        for (Searchable searchable : searchables) {
            if (searchable==null)continue;
            if (searchable.searchTerm().contains(search)){
                results[resultsCount]=searchable;
                resultsCount++;
                if (resultsCount == 5) {
                    break;
                }
            }

        }
        return Arrays.copyOf(results,resultsCount);
    }

    public void add(Searchable searchable) {
        if (searchables.length > size && searchable != null) {
             searchables[size]=searchable;
            size++;
        }
    }
}
