public class Main {
    public static void main(String[] args) {
//        Node t = new Node("A", new Node("B"), new Node("C"));
//        t.inOrderTraversal(t);

        Main obj = new Main();
        System.out.print("Output untuk mystery1(4): ");
        obj.mystery1(4);  // Output: 1, 2, 4
        System.out.println();



    }
    public void mystery1(int n) {
        if (n <= 1) {
            System.out.print(n);
        } else {
            mystery1(n / 2);
            System.out.print(", " + n );
        }
    }
}
