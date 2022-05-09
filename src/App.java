public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome Student Information System");
        System.out.println("===============================");
        System.out.println("Please login first to continue");
        System.out.println("===============================");
        new Administrators().login();
    }
}
