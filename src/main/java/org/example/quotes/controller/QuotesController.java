package org.example.quotes.controller;

import org.example.Container;
import org.example.quotes.entity.Quotes;

import java.util.Map;

public class QuotesController {
    private long lastQuotesId;
    public QuotesController(){

    }

    public void insert(Map<Integer, Quotes> qList, int idx){
        System.out.print("명언 : ");
        String s = Container.getScanner().nextLine();

        System.out.print("작가 : ");
        String a = Container.getScanner().nextLine();
        System.out.println( idx + "번 명언이 등록되었습니다.");
        Quotes newQuotes = new Quotes(idx, s, a);
        qList.put(idx,newQuotes);

    }

    public void retrieveAll(Map<Integer, Quotes> qList, int idx){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------------");
        qList.size();
        for (int i = 1; i <= idx; i++) {
            Quotes q = qList.get(i);
            if (q != null)
                System.out.println(q.getQuotesNum() + " / " + q.getAuthor() + " / " + q.getQuotes());
        }
    }

    public void delete(Map<Integer, Quotes> qList, int num){
        Quotes q = qList.get(num);
        if (q != null){

            qList.remove(num);
            System.out.println(num+"번 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(num + "번 명언이 존재하지 않습니다.");
        }
    }
    public void update(Map<Integer, Quotes> qList, int num){
        Quotes q= qList.get(num);
        if(q != null){
            System.out.println("명언(기존) : " + q.getQuotes() );
            System.out.print("명언 : ");
            String newQ = Container.getScanner().nextLine();
            q.setQuotes(newQ);
            System.out.println("작가(기존) : " + q.getAuthor() );
            System.out.print("작가 : ");
            String newA = Container.getScanner().nextLine();
            q.setAuthor(newA);
            System.out.println(num + "번 명언이 수정되었습니다.");
        }
        else{
            System.out.println(num + "번 명언이 존재하지 않습니다.");
        }
    }
}
