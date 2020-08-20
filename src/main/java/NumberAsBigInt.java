import java.math.BigInteger;

public class NumberAsBigInt {
    private BigInteger bigInteger;

    //constructor using String - for input number
    public NumberAsBigInt(String numberAsString) {
        this.bigInteger = new BigInteger(numberAsString);
    }

    //constructor using NumberAsBigInt - for multiplication
    public NumberAsBigInt(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public NumberAsBigInt multiply(NumberAsBigInt number) {
        return new NumberAsBigInt(this.bigInteger.multiply(number.bigInteger));
    }

    public void print() {
        System.out.print(this.bigInteger);
    }
}
