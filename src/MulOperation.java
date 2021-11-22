public class MulOperation extends Operation{
    public MulOperation(String operand) {
        super(operand);
    }

    @Override
    public int apply(int target) {
        return target * operand;
    }
}
