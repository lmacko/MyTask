public class Main {
    public static void main(String[] args) {

        if (args.length < 4) {
            if (args[0].equals("--alg1")) {
                NumberAsBigInt a;
                NumberAsBigInt b;
                try {
                    a = new NumberAsBigInt(args[1]);
                    b = new NumberAsBigInt(args[2]);
                    a.multiply(b).print();
                } catch (NumberFormatException e) {
                    System.out.println("invalid argument, must be a number");
                }

            } else if (args[0].equals("--alg2")) {
                NumberAsArray a;
                NumberAsArray b;
                try {
                    a = new NumberAsArray(args[1]);
                    b = new NumberAsArray(args[2]);
                    a.multiply(b).print();
                } catch (NumberFormatException e) {
                    System.out.println("invalid argument, must be a number");
                }

            }
        } else printHelp();

    }

    public static void printHelp() {
        System.out.println("usage:");
        System.out.println("    multiply [option] number1 number2");
        System.out.println("options: ");
        //System.out.println("    -h --help   shows help");
        System.out.println("    --alg1  uses BigInteger class to multiply");
        System.out.println("    --alg2  uses implemented method to multiply");
    }
}
