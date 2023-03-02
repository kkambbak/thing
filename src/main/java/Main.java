import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App newApp = new App();
        newApp.run();
    }
}

class App{
    public void run(){
        System.out.println("== 명언 앱 ==");
        int idx = 1;
        Map<Integer,Quotes> qList = new HashMap<>();

        while(true){
            System.out.print("명령) ");
            Scanner sc = new Scanner(System.in);
            String order = sc.nextLine();
            if (order.equals("종료")){
                break;
            }

            if (order.equals("등록") ){

                System.out.print("명언 : ");
                String s = sc.nextLine();

                System.out.print("작가 : ");
                String a = sc.nextLine();
                System.out.println( idx + "번 명언이 등록되었습니다.");
                Quotes newQuotes = new Quotes(idx, s, a);
                qList.put(idx++,newQuotes);

            }

            if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("------------------------");
                qList.size();
                for (int i = 1; i <= idx; i++) {
                    Quotes q = qList.get(i);
                    if (q != null)
                        System.out.println(q.getQuotesNum() + " / " + q.getAuthor() + " / " + q.getQuotes());
                }
            }

            if (order.contains("삭제?id=")){
                int num = Integer.parseInt(order.substring(6));
                Quotes q = qList.get(num);
                if (q != null){

                    qList.remove(num);
                    System.out.println(num+"번 명언이 삭제되었습니다.");
                }
                else{
                    System.out.println(num + "번 명언이 존재하지 않습니다.");
                }
            }

            if (order.contains("수정?id=")){
                int num = Integer.parseInt(order.substring(6));


                Quotes q= qList.get(num);
                if(q != null){
                    System.out.println("명언(기존) : " + q.getQuotes() );
                    System.out.print("명언 : ");
                    String newQ = sc.nextLine();
                    q.setQuotes(newQ);
                    System.out.println("작가(기존) : " + q.getAuthor() );
                    System.out.print("작가 : ");
                    String newA = sc.nextLine();
                    q.setAuthor(newA);
                    System.out.println(num + "번 명언이 수정되었습니다.");
                }
                else{
                    System.out.println(num + "번 명언이 존재하지 않습니다.");
                }
            }
        }
    }
}

class Orders{
    String orderName;
    Orders(String orderName){
        this.orderName = orderName;
    }
}

class Quotes{
    public int getQuotesNum() {
        return quotesNum;
    }
    public int getQuotesNum(int i) {
        return quotesNum;
    }

    public void setQuotesNum(int quotesNum) {
        this.quotesNum = quotesNum;
    }

    private int quotesNum;
    private String quotes;

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;
    Quotes(int quotesNum, String quotes, String author){
        this.quotesNum = quotesNum;
        this.quotes = quotes;
        this.author = author;
    }
}