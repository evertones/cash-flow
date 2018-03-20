package org.evertones.api;

import org.evertones.model.Model;

import java.util.ArrayList;
import java.util.List;

public class SuggestionBoxDto<T extends Model> {

    private String query;
    private List<T> suggestions = new ArrayList<T>();

    public String getQuery() {
        return query;
    }

    public SuggestionBoxDto setQuery(String query) {
        this.query = query;
        return this;
    }

    public List<T> getSuggestions() {
        return suggestions;
    }

    public SuggestionBoxDto setSuggestions(List<T> suggestions) {
        this.suggestions = suggestions;
        return this;
    }
}
