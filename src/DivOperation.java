public class DivOperation extends Operation{
    public DivOperation(String operand) {
        super(operand);
    }

    @Override
    public int apply(int target) {
        return target / operand;
    }
}
