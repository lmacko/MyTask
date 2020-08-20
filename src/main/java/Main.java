public class Main {
    public static void main(String[] args) {

        if(args[0].equals("--alg1")){
            NumberAsBigInt a;
            NumberAsBigInt b;
            try{
               a = new NumberAsBigInt(args[1]);
               b = new NumberAsBigInt(args[2]);
               a.multiply(b).print();
            }
            catch (NumberFormatException e){
                System.out.println("invalid argument, must be a number");
            }

        } else if(args[0].equals("--alg2")){
            NumberAsArray a;
            NumberAsArray b;
            try{
                a = new NumberAsArray(args[1]);
                b = new NumberAsArray(args[2]);
                a.multiply(b).print();
            } catch (NumberFormatException e){
                System.out.println("invalid argument, must be a number");
            }

        } else printHelp();



//        System.out.println("BigInt");
//        NumberAsBigInt a = new NumberAsBigInt("12345678901234567890");
//        NumberAsBigInt b = new NumberAsBigInt("11111111111111111111");
//        a.print();
//        b.print();
//        a.multiply(b).print();

//        System.out.println("AsArray");
//        NumberAsArray p = new NumberAsArray("512");
//        NumberAsArray q = new NumberAsArray("1024");
//        System.out.println();
//        p.print();
//        System.out.println();
//        q.print();
//        System.out.println();
//        p.multiply(q).print();

    }

    public static void printHelp(){
        System.out.println("usage:");
        System.out.println("    multiply [option] number1 number2" );
        System.out.println("options: ");
        //System.out.println("    -h --help   shows help");
        System.out.println("    --alg1  uses BigInteger class to multiply");
        System.out.println("    --alg2  uses implemented method to multiply");
    }
}
