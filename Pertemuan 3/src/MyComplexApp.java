import  java.util.Scanner;

public class MyComplexApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        double r1, r2, i1, i2;
        System.out.println("Enter complex number 1 (real and imaginary part): ");
        r1 = sc.nextDouble();
        i1 = sc.nextDouble();
        System.out.print(r1 + " " + i1 + "i" );
        System.out.println(" ");

        System.out.println("Enter complex number 2 (real and imaginary part): ");
        r2 = sc.nextDouble();
        i2 = sc.nextDouble();
        System.out.print(r2 + " " + i2 + "i" );


        // bikin objek
        MyComplex n1 = new MyComplex(r1, i1);
        MyComplex n2 = new MyComplex(r2, i2);

        // print dari metode to string
        System.out.println("Number 1 is: ("+n1+")");
        if(n1.isReal()){
            System.out.println(n1 + " is a pure real number");

        }  else {
            System.out.println(n1 + " is a NOT pure real number");

        }


        System.out.println("Number 1 is: ("+n1+")");
        if(n1.isImaginary()){
            System.out.println(n1 + " is a pure imaginary number");

        }  else {
            System.out.println(n1 + " is a NOT pure imaginary number");

        }

        System.out.println("Number 2 is: ("+n2+")");
        if(n2.isReal()){
            System.out.println(n2 + " is a pure real number");

        }  else {
            System.out.println(n2 + " is a NOT pure real number");

        }

        System.out.println("Number 2 is: ("+n1+")");
        if(n2.isImaginary()){
            System.out.println(n2+ " is a pure imaginary number");

        }  else {
            System.out.println(n2 + " is a NOT pure imaginary number");

        }

        if(n1.equals(n2)){
            System.out.println(n1 + "Is equals to " + n2);

        } else {
            System.out.println("(" + n1 +")" + "is NOT equals " + "(" + n2 +")");
        }

        System.out.println("(" + n1 + ")"+ " +" + "(" + n2 + ")" + "=" + "(" + n1.addNew(n2) + ")" );



    }
}
