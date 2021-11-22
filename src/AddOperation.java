public class AddOperation extends Operation {
    public AddOperation(String operand) {
        super(operand);
    }

    @Override
    public int apply(int target) {
        return target + operand;
    }
}
