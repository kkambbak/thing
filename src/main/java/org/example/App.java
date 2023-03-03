package org.example;

import org.example.quotes.controller.QuotesController;
import org.example.quotes.entity.Quotes;
import org.example.system.controller.SystemController;

import java.util.HashMap;
import java.util.Map;

public class App {
    private int idx = 1;

    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) { this.idx = idx;}

    public void run() {
        System.out.println("== 명언 앱 ==");

        SystemController systemController = new SystemController();
        QuotesController quotesController = new QuotesController();


        while (true) {
            System.out.print("명령) ");
            String order = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(order);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    quotesController.insert();
                    break;
                case "목록":
                    quotesController.retrieveAll();
                    break;
                case "삭제":
                    quotesController.delete(rq);
                    break;
                case "수정":
                    quotesController.update(rq);
                    break;
            }
        }
    }
}
