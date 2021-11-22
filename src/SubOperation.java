public class SubOperation extends Operation {
    public SubOperation(String operand) {
        super(operand);
    }

    @Override
    public int apply(int target) {
        return target - operand;
    }
}
