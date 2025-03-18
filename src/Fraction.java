public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero.");
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean isProper() {
        return Math.abs(numerator) < Math.abs(denominator);
    }

    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        int wholePart = numerator / denominator;
        int remainder = Math.abs(numerator % denominator);
        if (wholePart != 0) {
            return String.format("%d'%d/%d", wholePart, remainder, denominator);
        } else {
            return String.format("%d/%d", numerator, denominator);
        }
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }
}
