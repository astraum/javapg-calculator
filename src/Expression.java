import java.util.Arrays;
import java.util.List;

// 양의 정수와 사칙연산만을 포함하는 계산식을 오브젝트로 표현하는 클래스
public class Expression {
    private final List<String> tokens; // 계산식을 숫자와 연산자의 리스트로 저장한다. 한번 만들어지면 값이 바뀌지 않는다.
    private int accumulator; // 첫 숫자부터 시작해서 순차적으로 결과값을 담아나간다.

    public Expression(String userInput) {
        // 입력값의 유효성을 확인한다.
        // 1. 맨 처음에는 1자리 이상의 숫자가 와야 한다. \d+ (참고: 현재 이 코드는 양의 정수의 사칙연산만을 전제한다)
        // 2. 이후에는 아래와 같은 패턴이 1번 이상 반복되어야 한다. ()+
        // 2-1. 0자리 이상의 공백(whitespace). \s*
        // 2-2. 사칙연산자 중 하나. [-+*/]
        // 2-3. 0자리 이상의 공백(whitespace). \s*
        // 2-4. 1자리 이상의 숫자. \d+
        if (!userInput.matches("\\d+(\\s*[-+*/]\\s*\\d+)+")) {
            // 입력값이 검사 패턴과 매치되지 않을 경우 다음과 같은 오류 메시지(?)를 전송한다.
            throw new RuntimeException("invalid format");
        }

        tokens = tokenize(userInput);
        accumulator = Integer.parseInt(tokens.get(0));
    }

    public int calculate() {
        for (String token : tokens.subList(1, tokens.size())) {
                accumulator = Operation.from(token).apply(accumulator);
            }
        return accumulator;
    }

    private List<String> tokenize(String expressionString) {
        String[] s = expressionString
                .replaceAll("\\s+", "")
                .replaceAll("([-+*/])", " $1")
                .split(" ");
        return Arrays.asList(s);
    }

}
