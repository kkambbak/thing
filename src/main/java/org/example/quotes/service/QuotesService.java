package org.example.quotes.service;

import org.example.Container;
import org.example.quotes.entity.Quotes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuotesService {
    private long lastQuotesId;

    private final Map<Integer, Quotes> qList = new HashMap<>();

    private int idx = 1;

    public long insert(String s, String a) {

        Quotes newQuotes = new Quotes(idx, s, a);
        qList.put(idx,newQuotes);
        return idx++;
    }

    public Quotes findById(long id) {
        return qList.get((int)id);
    }

    public List<Quotes> retrieveAll() {
        List<Quotes> listQ = new ArrayList<>();
        qList.size();

        for (int i = 1; i <= idx; i++) {
            Quotes q = qList.get(i);
            if (q != null)
                listQ.add(q);
        }
        return listQ;
    }

    public void delete(long num) {
        qList.remove((int)num);
    }

    public void update(long num, String newQ, String newA) {
        Quotes q = qList.get((int)num);
        q.setQuotes(newQ);
        q.setAuthor(newA);
    }
}
