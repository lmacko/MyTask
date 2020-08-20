import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class NumberAsArrayTest {

    @Test
    public void multiply() {
        NumberAsArray p = new NumberAsArray("12345678901234567890");
        NumberAsArray q = new NumberAsArray("11111111111111111111");
        NumberAsArray expected = new NumberAsArray("137174210013717420998628257899862825790");
        assertArrayEquals(expected.getNumberAsArray(), p.multiply(q).getNumberAsArray());
    }

    @Test
    public void print() {
        NumberAsArray p = new NumberAsArray("12345678901234567890");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        p.print();
        assertEquals("12345678901234567890",outContent.toString());
    }

    @Test
    public void BigIntVsAsArray() {
        NumberAsBigInt a = new NumberAsBigInt("012345678901234567890");
        NumberAsBigInt b = new NumberAsBigInt("11111111111111111111");
        NumberAsArray p = new NumberAsArray("012345678901234567890");
        NumberAsArray q = new NumberAsArray("11111111111111111111");

        ByteArrayOutputStream BigIntProduct = new ByteArrayOutputStream();
        System.setOut(new PrintStream(BigIntProduct));
        a.multiply(b).print();

        ByteArrayOutputStream AsArrayProduct = new ByteArrayOutputStream();
        System.setOut(new PrintStream(AsArrayProduct));
        p.multiply(q).print();

        assertEquals(BigIntProduct.toString(),AsArrayProduct.toString());
    }

}