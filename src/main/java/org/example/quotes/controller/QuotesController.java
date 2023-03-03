package org.example.quotes.controller;

import org.example.Container;
import org.example.Rq;
import org.example.quotes.entity.Quotes;
import org.example.quotes.service.QuotesService;

import java.util.List;
import java.util.Map;

public class QuotesController {

    private QuotesService quotesService;
    public QuotesController(){
        quotesService = new QuotesService();
    }

    public void insert(){
        System.out.print("명언 : ");
        String s = Container.getScanner().nextLine();

        System.out.print("작가 : ");
        String a = Container.getScanner().nextLine();
        long id = quotesService.insert(s,a);
        System.out.printf( "%d번 명언이 등록되었습니다.\n", id);
    }

    public void retrieveAll(){
        List<Quotes> quotesList = quotesService.retrieveAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------------");

        for (int i = quotesList.size() -1 ; i >= 0  ; i--) {
            Quotes q = quotesList.get(i);

            System.out.printf("%d / %s / %s\n", q.getQuotesNum(), q.getAuthor(), q.getQuotes());
        }

    }

    public void delete(Rq rq){
        long id = rq.getLongParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.\n");
            return;
        }
        Quotes q = quotesService.findById(id);
        if (q != null){
            quotesService.delete(id);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
        }
        else{
            System.out.printf("%번 명언이 존재하지 않습니다.\n", id);
        }
    }
    public void update(Rq rq){
        long id = rq.getLongParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.\n");
            return;
        }

        Quotes q = quotesService.findById(id);
        if(q != null){
            System.out.println("명언(기존) : " + q.getQuotes() );
            System.out.print("명언 : ");
            String newQ = Container.getScanner().nextLine().trim();

            System.out.println("작가(기존) : " + q.getAuthor() );
            System.out.print("작가 : ");
            String newA = Container.getScanner().nextLine().trim();

            quotesService.update(id, newQ, newA);
            System.out.printf("%d번 명언이 수정되었습니다.\n", id);
        }
        else{
            System.out.printf("%d번 명언이 존재하지 않습니다.\n", id);
        }
    }
}
