import java.math.BigInteger;

public class NumberAsBigInt {
    private BigInteger bigInteger;

    public NumberAsBigInt(String numberAsString) {          //constructor using String - for input number
        this.bigInteger = new BigInteger(numberAsString);
    }

    public NumberAsBigInt(BigInteger bigInteger) {          //constructor using NumberAsBigInt - for multiplication
        this.bigInteger = bigInteger;
    }

    public NumberAsBigInt multiply(NumberAsBigInt number){
        return new NumberAsBigInt(this.bigInteger.multiply(number.bigInteger));
    }

    public void print(){
        System.out.print(this.bigInteger);
    }
}
