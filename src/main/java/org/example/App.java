package org.example;

import org.example.quotes.controller.QuotesController;
import org.example.quotes.entity.Quotes;

import java.util.HashMap;
import java.util.Map;

public class App {
    Map<Integer, Quotes> qList = new HashMap<>();
    private int idx = 1;

    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) { this.idx = idx;}

    public void run() {
        System.out.println("== 명언 앱 ==");

        QuotesController quotesController = new QuotesController();

        while (true) {
            System.out.print("명령) ");
            String order = Container.getScanner().nextLine().trim();
            if (order.equals("종료")) {
                break;
            }
            if (order.equals("등록")) {
                quotesController.insert(qList, idx);
                setIdx(++idx);
            }
            if (order.equals("목록")) {
                quotesController.retrieveAll(qList, idx);
            }
            if (order.contains("삭제?id=")) {
                int num = Integer.parseInt(order.substring(6));
                quotesController.delete(qList, num);
            }
            if (order.contains("수정?id=")) {
                int num = Integer.parseInt(order.substring(6));
                quotesController.update(qList, num);
            }
        }
    }
}
