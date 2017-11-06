import de.vksi.c4j.ContractReference;
import de.vksi.c4j.Pure;

@ContractReference(FractionContract.class)
public class Fraction {

   private int numerator;
   private int denominator;

   public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
   }

   @Pure
   public int getNumerator() {
      return numerator;
   }
   @Pure
   // getter-Methoden haben keine Seiteneffekte, daher annotation mit @Pure
   public int getDenominator() {
      return denominator;
   }

   public void multiply(int multiplier) {
      this.multiply(new Fraction(multiplier, 1));
   }

   public void multiply(Fraction fract) {
      numerator *= fract.getNumerator();
      denominator *= fract.getDenominator();
   }

   public void divide(Fraction fract) {
      this.multiply(new Fraction(fract.getDenominator(), fract.getNumerator()));
   }
}
