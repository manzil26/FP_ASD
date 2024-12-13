import java.util.*;

public class Main {
    public static void main(String[] args) {
       int [] data = {1000, -2, 99, -99, 2, 22, 1, 3, 4, -1, 5};
       Sorting m = new Sorting(data);
       m.selectionSort();
        System.out.println(m);


    }
}
