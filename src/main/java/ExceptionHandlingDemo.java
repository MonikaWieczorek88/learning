public class ExceptionHandlingDemo {

    public static void main(String[] args) {

        demo();
    }

    public static void demo() {

        try {
            System.out.println("Hello World...!");
            int i = 1/0;
            System.out.println("Completed");
        }catch (ArithmeticException e) {
            System.out.println("I am inside catch block");
            System.out.println("Message is: " + e.getMessage());
            System.out.println("Cause is : " + e.getCause());
            e.printStackTrace();
        }finally {
            System.out.println("I am inside finally block");
        }

    }
}
