import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Operation {
    protected final int operand;

    public Operation(String operand) {
        this.operand = Integer.parseInt(operand);
    }

    public abstract int apply(int target);

    public static Operation from(String prefixedOperand) {
        Pattern pattern = Pattern.compile("(?<op>[-+*/])(?<operand>\\d+)");
        Matcher matcher = pattern.matcher(prefixedOperand);
        boolean matches = matcher.find();
        String operator = matcher.group("op");
        String operand = matcher.group("operand");
        return switch (operator) {
            case "+" -> new AddOperation(operand);
            case "-" -> new SubOperation(operand);
            case "*" -> new MulOperation(operand);
            case "/" -> new DivOperation(operand);
            default -> null;
        };
    }
}
