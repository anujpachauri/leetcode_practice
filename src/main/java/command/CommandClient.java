package command;

public class CommandClient {
    public static void main(String[] args) {
        TextFileExecutor executor=new TextFileExecutor();
       System.out.println(executor.textExecutor(new OpenTextFile(new TextFile("Flipkart"))));
        System.out.println(executor.textExecutor(new SaveTextFile(new TextFile("Flipkart"))));
    }
}
