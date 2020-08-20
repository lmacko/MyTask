import java.util.Arrays;

public class NumberAsArray {
    //numbers are stored in reverse order for easier multiplication
    private int[] numberAsArray;

    //constructor using String - for input number
    public NumberAsArray(String numberAsString) {
        String[] stringArray = numberAsString.split("\\B");
        int[] tempArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            tempArray[i] = Integer.parseInt(stringArray[stringArray.length - i - 1]);
        }
        this.numberAsArray = removeZeroes(tempArray);
    }

    //constructor using NumberAsArray - for multiplication
    public NumberAsArray(int[] numberAsArray) {
        this.numberAsArray = removeZeroes(numberAsArray);
    }

    public int[] getNumberAsArray() {
        return numberAsArray;
    }

    //removes zeroes at the beginning of a number
    //actually removes zeroes at the end of reversed number
    private int[] removeZeroes(int[] array) {
        int newSize = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 0) {
                newSize = i + 1;
                break;
            }
        }

        if (newSize == -1) return new int[1];

        if (newSize < array.length) {
            int[] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, newSize);
            return newArray;

        } //if there are no zeroes at the beginning of number we do not process it
        else return array;
    }

    //multiply method
    public NumberAsArray multiply(NumberAsArray number) {
        int p = this.numberAsArray.length;
        int q = number.numberAsArray.length;
        int[] product = new int[p + q];
        for (int j = 0; j < q; j++) {
            int carry = 0;
            for (int i = 0; i < p; i++) {
                product[i + j] += carry + (this.numberAsArray[i] * number.numberAsArray[j]);
                carry = product[i + j] / 10;
                product[i + j] = product[i + j] % 10;
            }
            product[j + p] = carry;
        }
        return new NumberAsArray(product);
    }

    //prints number, changes from reversed order
    public void print() {
        for (int i = 0; i < this.numberAsArray.length; i++) {
            System.out.print(this.numberAsArray[this.numberAsArray.length - i - 1]);
        }
    }
}
