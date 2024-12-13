/**
 * Coursework   : 05
 * Student ID   : 5026231037
 * Full Name    : Al-khiqmah Manzilatul Mukaromah 
 * Class        : C
 */

public class Main {

    public static void main(String[] args) {
        //  Mendeklarasikan dan menginisialisasi array data untuk pengujian
        int data [] = {100, -2, 99, -99, 2, 22, 1, 3, 4, -1, 5,1000};
        // //Menampilkan teks Test Buble Sort:
        System.out.println("Test Buble Sort:");
        // Membuat objek Sorting bernama b dengan array data sebagai argumen
        Sorting b = new Sorting(data);
        //  Memanggil metode bubleSort pada objek b untuk mengurutkan array
        b.bubleSort();
        // Mencetak hasil dari pengurutan Bubble Sot
        System.out.println(b);

        //  Menampilkan teks Test Selection Sort:
        System.out.println("Test Selection Sort:");
        // Membuat objek Sorting bernama s dengan array data sebagai argumen
        Sorting s = new Sorting(data);
        // Memanggil metode selectionSort pada objek s untuk mengurutkan array
        s.selectionSort();
        // Mencetak hasil dari pengurutan Selection Sort
        System.out.println(s);


        // mencetak teks Test Insertion Sort:
        System.out.println("Test Insertion Sort:");
        // Membuat objek Sorting bernama i dengan array data sebagai argumen
        Sorting i = new Sorting(data);
        // Memanggil metode insertionSort
        i.insertionSort();
        // Mencetak hasil dari pengurutan Insertion Sort
        System.out.println(i);

        // mencetak teks Test Merge Sort:
       System.out.println("Test Merge Sort:");
       //Membuat objek Sorting bernama m dengan array data sebagai argumen
        Sorting m = new Sorting(data);
        //Memanggil metode mergeSort pada objek m
        m.mergeSort();
        // Mencetak hasil dari pengurutan Merge Sort
        System.out.println(m);


        // mencetak teks Reverse:
        System.out.println("Reverse:");
        // Mencetak hasil dari pengurutan Merge Sort
        m.reverse();
        // mencetak hasil dari reverse
        System.out.println(m);

        // Memanggil metode reverse pada objek m untuk membalik urutan elemen-elemen array
        m.reverse();

        //endeklarasikan variabel k dengan nilai 99 untuk pencarian elemen dalam array
        int k = 99;

        // mencetak teks Linear Search:
        System.out.println("Linear Search:");
        //Memanggil metode linearSearch pada objek m untuk mencari nilai k dalam array
        int id = m.linearSearch(k);
        // Jika id bernilai -1, menampilkan bahwa k tidak ditemukan dalam array
        if(id==-1) System.out.println(k+ " is not found");
            // Jika id bukan -1, menampilkan indeks di mana k ditemukan
        else System.out.println(k+ " is found at index "+ id);

        // mencetak teks Binary Search:
        System.out.println("Binary Search:");
        // Memanggil metode binarySearch pada objek m untuk mencari nilai k dalam array
        id = m.binarySearch(k);

        // Jika id bernilai -1, menampilkan bahwa k tidak ditemukan dalam array
        if(id==-1) System.out.println(k+ " is not found");

        // Jika id bukan -1, menampilkan indeks di mana k ditemukan
        else System.out.println(k+ " is found at index "+ id);

    }
}
