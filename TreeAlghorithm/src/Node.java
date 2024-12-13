public class Node {
    // setai node punya value string
    private String value;
    // punya node sebelah kiri dan kanan
    private Node left;
    private Node righth;

    Node(String v){
        this.value = v;

    }

    Node(String v, Node l, Node r){
        this.value = v;
        this.left = l;
        this.righth = r;

    }

    void inOrderTraversal(Node n){
       if (n.left != null) inOrderTraversal(n.left);
        System.out.println(n.value); // ngeprin dirinya sendiri
       if (n.righth != null) inOrderTraversal(n.righth);



    }





}
