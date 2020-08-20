import java.util.Arrays;

public class NumberAsArray {
    private int[] numberAsArray;            //numbers are stored in reverse order for easier multiplication

    public NumberAsArray(String numberAsString){                            //constructor using String - for input number
        String[] stringArray = numberAsString.split("\\B");
        int[] tempArray = new int[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            tempArray[i] = Integer.parseInt(stringArray[stringArray.length - i -1]);
        }
        this.numberAsArray = removeZeroes(tempArray);
    }

    public NumberAsArray(int[] numberAsArray) {                             //constructor using NumberAsArray - for multiplication
        this.numberAsArray = removeZeroes(numberAsArray);
    }

    public int[] getNumberAsArray() {
        return numberAsArray;
    }

    private int[] removeZeroes(int[] array) {                               //removes zeroes at the beginning of a number
        int newSize = -1;                                                   //actually removes zeroes at the end of reversed number
        for (int i = array.length -1 ; i >= 0 ; i--) {
            if (array[i] != 0) {
                newSize = i+1;
                break;
            }
        }

        if (newSize == -1) return new int[1];

        if(newSize < array.length){
            int[] newArray = new int [newSize];
            System.arraycopy(array, 0, newArray, 0, newSize);
            return newArray;
        } else return array;              //if there are no zeroes at the beginning of number we do not process it
    }

    public NumberAsArray multiply(NumberAsArray number){    //multiply method
        int p = this.numberAsArray.length;
        int q = number.numberAsArray.length;
        int[] product = new int[p+q];
        for(int j = 0; j < q ; j++){
            int carry = 0;
            for(int i = 0; i <p; i++){
                product[i+j] += carry + (this.numberAsArray[i] * number.numberAsArray[j]);
                carry = product[i+j]/10;
                product[i+j] = product[i+j] % 10;
            }
            product[j+p] = carry;
        }
        return new NumberAsArray(product);
    }



    public void print(){            //prints number, changes from reversed order
        for(int i = 0; i < this.numberAsArray.length ; i++){
            System.out.print(this.numberAsArray[this.numberAsArray.length - i -1]);
        }
    }
}
