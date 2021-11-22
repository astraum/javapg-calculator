import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println("양의 정수와 사칙연산만을 포함하는 계산식을 입력하십시오.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // Handle the expression as an object
        Expression exp = new Expression(userInput);

        System.out.print("계산 결과: " + exp.calculate() + "\n");
    }
}
