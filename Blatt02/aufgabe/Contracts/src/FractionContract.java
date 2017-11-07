import static de.vksi.c4j.Condition.postCondition;
import static de.vksi.c4j.Condition.preCondition;
import static de.vksi.c4j.Condition.unchanged;
import de.vksi.c4j.ClassInvariant;
import de.vksi.c4j.Target;

class FractionContract extends Fraction {

    @Target
    private Fraction target;

    @ClassInvariant
    public void classInvariant() {
        assert target.getDenominator() != 0;
    }

    public FractionContract(int numerator, int denominator) {
        super(numerator, denominator);
        if (postCondition()) {
            assert target.getDenominator() != 0;
        }
    }

    @Override
    public void multiply(int multiplier) {
        if (preCondition()) {
            assert target.getDenominator() != 0;
        }
        if (postCondition()) {
            assert !unchanged(target.getNumerator());
            assert unchanged(target.getDenominator());
            assert target.getDenominator() != 0;
        }
    }

    @Override
    public void multiply(Fraction fract) {
        if (preCondition()) {
            assert fract instanceof Fraction;
            assert target.getDenominator() != 0;
        }
        if (postCondition()) {
            assert !unchanged(target.getNumerator());
            assert target.getDenominator() % fract.getDenominator() == 0;
            assert target.getDenominator() != 0;
        }
    }

    @Override
    public void divide(Fraction fract) {
        if (preCondition()) {
            assert target.getDenominator() != 0;
            assert fract instanceof Fraction;
        }
        if (postCondition()) {
            assert target.getDenominator() != 0;
            assert !unchanged(target.getNumerator()) || !unchanged(target.getDenominator());
        }
    }
}
