package org.skypro.skyshop.search;

import org.skypro.skyshop.err.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine(List<Searchable> searchables) {
        this.searchables=searchables;
    }

    public List<Searchable> search(String search) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable searchable : searchables) {
            if (searchable == null) continue;
            if (searchable.getSearchTerm().contains(search)) {
                results.add(searchable);
            }
        }
        return results;
    }

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public void excludeNull(List<Searchable> res) {
        for (Searchable searchable : res) {
            if (searchable != null) {
                System.out.println(searchable);
            }
        }

    }

    public static int foundResult(String str, String substring) {
        int count = 0;
        int index = 0;

        while (true) {
            int indexSubstring = str.indexOf(substring, index);
            if (indexSubstring == -1) {
                break;
            }
            count++;
            index = indexSubstring + substring.length();
        }
        return count;
    }

    public  Searchable foundSuitableProductSearchBar(String search) throws BestResultNotFound {
        Searchable bestResult = null;
        int count = 0;
        for (Searchable searchable : searchables) {
            if (searchable==null) {
                continue;
            }
            int countResult = foundResult(searchable.getSearchTerm(), search);
            if (countResult > count) {
                bestResult = searchable;
                count=countResult;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound("Для запроса " + search + " не нашлось подходящей статьи");
        } else {
            System.out.println("Объект найден " +bestResult.getSearchTerm());
        }
        return bestResult;
    }

}
