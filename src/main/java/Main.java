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
                Quotes newQuotes = new Quotes(idx++, s, a);

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