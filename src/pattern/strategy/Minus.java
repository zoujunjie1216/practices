package pattern.strategy;

public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayint[]=split(exp,"\\-");
        return arrayint[0]-arrayint[1];
    }
}
