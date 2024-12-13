class Sorting{
    int data []; //  deklrasi instance  array dengan nama data

    // Konstruktor dengan parameter namanya a untuk menginsiasi array 'data' dengan nilai yang diberikan 
    Sorting(int []a){
        this.data = a; // menyimpan array input 'a' ke dalam variabel instance 'data' 
    }

    // metode untuk mengonversi array yang bernama data menajdi string 
    public String toString(){
        String output=""; // variabel output untuk menyimpan hasil dalam bentuk string
        for(int d:data) output+=" "+d; // menambahakan elemendi 'data ' ke 'output' dengan menambahakan juga spasi
        return output; // menembalikan 'output' yang berisi elemen-elemen array sebagai string 
    }


    // metode mengurutkan array menggunakan  bubble sort 
    //buble sort
    void bubleSort(){

        // looping untuk mengatur batas setiap iterasi (panjang arraynya)
        // Dimulai dari indeks this.data.length - 2, yaitu elemen kedua terakhir, dan akan terus berkurang hingga 0
        for(int s=this.data.length-2;s>=0;s--){
            // loop untuk membandingkan dan menukan elemen dari array yang berdekatan
            for(int p=0;p<=s;p++){
                // jika elemen awal lebih besar dari berikutnya maka akan di swap
                if(this.data[p+1]<this.data[p]){
                    //swap
                    int temp = this.data[p+1]; // assign elemen awal yang besar ke variabel temp
                    this.data[p+1] = this.data[p]; // assign elemen kecil ke varaibel index yang elemen awal besar
                    this.data[p] =temp; // asign elemen dari variabel temp ke varaibel index  elemen kecil
                }
            }
        }
    }

    // metode mengurutkan array menggunakan selection sort 
    //selection sort
    void selectionSort(){
        // looping index sampai batas array yang bernama data 
        for (int p=0; p<this.data.length-1;p++){
            // insialisasi nilai minimum sementara 
            // menggunakan max suapaya elemen dalam array data bisa masuk menjadi kandidat nilai minimum
            int min=Integer.MAX_VALUE;

            // insilisasi indeks minimum sementara 
            int minIdx= p+1;

            //  Loop untuk mencari elemen terkecil di bagian array yang belum diurutkan
            // Loop p digunakan untuk menentukan indeks yang akan diisi dengan elemen terkecil pada setiap iterasi
            for(int i=p+1;i<this.data.length;i++){
                if(this.data[i] < min) {  // Jika ditemukan elemen lebih kecil, update nilai dan indeks minimum
                    min= this.data[i]; // assign elemen lebih kecil tersebut  ke dalam varaibel min
                    minIdx=i; // assign index dari elemen terkecil tersebut  ke dalam varaibel minIdx
                }
            }

            if (min<this.data[p]){ // jika ditemukan elemen lebih kecil elemen di posisi 'p' maka lakukan swap
                //swap
                int t=this.data[p]; // assign elemen p yang lebih besar ke varaibel t
                this.data[p] = min; // assign elemen lebih kecil ke variabel array index p yang lebih besar
                this.data[min] = t; // assignelemen dari varaibel temp tadi ke variabel index min
            }

        }
    }

    //insertion sort

    // metode void insertionSort()
    void insertionSort(){
        //terasi, p mengacu pada elemen yang sedang dipertimbangkan untuk disisipkan ke posisi yang benar di bagian kiri array yang sudah diurutkan
        for(int p=1;p<this.data.length;p++){
            //Variabel temp menyimpan nilai elemen pada indeks p
            int temp = this.data[p];
            // Variabel stop digunakan sebagai tanda (flag) untuk menghentikan loop for bagian dalam jika sudah menemukan posisi yang benar untuk tem
            boolean stop = false;
            // Loop for bagian dalam berjalan dari indeks p-1 (elemen di sebelah kiri) hingga indeks 0
            for(int i=p-1;i>=0 && !stop;i--){
                //Kondisi ini mengecek apakah elemen pada indeks i lebih besar dari temp. Jika benar, berarti temp perlu dipindahkan ke posisi sebelum elemen i agar urutan tetap meningkat.
                if(this.data[i]>temp){
                    // Jika kondisi if terpenuhi, maka velemen pada this.data[i] digeser satu posisi ke kanan, sehingga elemen temp dapat ditempatkan di indeks i.
                    this.data[i+1] = this.data[i];
                    //Velemen temp ditempatkan pada posisi i, menggantikan elemen yang lebih besar dari temp
                    this.data[i] = temp;

                } else{
                    // Jika this.data[i] tidak lebih besar dari temp, berarti posisi temp sudah benar, dan tidak perlu melakukan pergeseran lagi
                    stop =true;
                }
            }
        }
    }

    //Merge Sort
   void mergeSort(){
        //your code is here
       //memanggil
       // this.data: array utama yang akan diurutkan.
       //0: indeks awal dari array this.data.
       //this.data.length - 1: indeks akhir dari array this.data.
       split(this.data, 0, this.data.length-1);

    }

    // Split the array into two subarrays, sort them and merge them
    void split(int arr[], int l, int r) {
        // memastikan bahwa array memiliki lebih dari elemen
        if (l < r) {
            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;

            //Memanggil rekursi split untuk subarray kiri dari l hingga m
            split(arr, l, m);
            // Memanggil rekursi split untuk subarray kanan dari m + 1 hingga r
            split(arr, m + 1, r);

            // Merge the sorted subarrays
            merge(arr, l, m, r);
        }
    }

    // Merge two subarrays L and M into arr
    // metode merge menggabungkan dua subarray dalam array arr.
    void merge(int arr[], int p, int q, int r) {
        // menghitung ukuran dari dua subarray
        // subrray kiri yang dimulai dari indeks p hingga q
        int n1 = q - p + 1;

        //ukuran subarray kanan, yang dimulai dari indeks q+1 hingga r
        int n2 = r - q;


        // menyimpan nilai dari subarray kiri.
        int L[] = new int[n1];
        //menyimpan nilai  dari subarray kanan.
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            //Mengisi array L dengan elemendari subarray kiri arr[p] hingga arr[q].
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            // engisi array M dengan elemen dari subarray kanan
            M[j] = arr[q + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        //Mendeklarasikan variabel i, j, dan k untuk melacak indeks saat ini dalam array L[], M[], dan arr[].
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        // Loop while ini menggabungkan elemendari L[] dan M[] kembali ke arr[], tetapi dalam urutan yang terurut.
        while (i < n1 && j < n2) {
            // Jika elemendi L[i] lebih kecil atau sama dengan elemen di M[j], maka arr[k] diisi dengan L[i] setelah itu index i di decrement .
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                // jika elemen tidak di L[i] lebih kecil atau sama denganelemen di M[j]] arr[k] di isi M[j] setelah itu decrement j
                arr[k] = M[j];
                j++;
            }
            // decrement k
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        //while ini mengatasi sisa elemen di L[] jika L[] masih memiliki elemen yang belum dimasukkan ke arr[]
        while (i < n1) {
            //
            arr[k] = L[i];
            i++;
            k++;
        }
        //  while ini menangani sisa elemen di M[] jika M[] masih memiliki elemen yang belum dimasukkan ke arr[]
        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }


     // metode reverse ini akan membalik urutan elemen dalam array data
    void reverse(){
        // Membuat array baru r dengan ukuran yang sama dengan array this.data.
        // Array r digunakan untuk menyimpan elemen this.data dalam urutan terbalik.
        int r [] = new int[this.data.length];
        // Mendeklarasikan variabel l yang menyimpan indeks terakhir dari array this.data (yaitu this.data.length - 1) namun  Variabel l tidak digunakan dalam kode selanjutnya, tetapi umumnya variabel ini bisa digunakan untuk mengakses indeks terakhir.
        int l = this.data.length-1;

        //your code goes here
        // Memulai loop for yang akan berjalan sebanyak jumlah elemen dalam this.data (dari i = 0 hingga i = this.data.length - 1)
        // Variabel i digunakan untuk mengindeks elemen dari array this.data dan menentukan posisi dalam array r di mana elemen tersebut akan ditempatkan secara terbalik
        for(int i=0; i<this.data.length; i++){
            // Pada setiap iterasi, elemen this.data yang berada pada posisi (this.data.length - i - 1) akan ditempatkan di posisi i dalam array r
            r[i] = this.data[this.data.length - i - 1];

        }
        // Mengganti referensi this.data dengan array r, sehingga this.data sekarang menyimpan elemen-elemen dalam urutan terbalik dari nilai awalnya
        this.data = r;
    }

    int linearSearch(int k){
        //Memanggil fungsi linearSearch(int k, int i) dengan k sebagai nilai yang dicari, dan 0 sebagai indeks awal pencarian
        return linearSearch(k,0);

    }

    int linearSearch(int k, int i){
        //base case
        // Jika indeks i telah mencapai panjang array (artinya sudah memeriksa semua elemen), dan k tidak ditemukan, maka fungsi mengembalikan -1 sebagai indikator bahwa elemen tidak ada di array
        if(i == this.data.length){
            //your code goes here
            return -1;
        }
        //recursive step

        // Jika elemen pada indeks i sama dengan k, maka mengembalikan indeks i, menunjukkan posisi elemen yang dicari
        else if(this.data[i]==k){
            //your code goes here
            return i;
        }
        else{
            //your code goes here
            // Jika elemen pada indeks i bukan yang dicari, maka fungsi memanggil dirinya sendiri dengan indeks berikutnya (i + 1) untuk melanjutkan pencarian
            return linearSearch(k, i+1);

        }

    }

    int binarySearch(int k){
        //k adalah elemen yang dicari.
        //0 adalah batas bawah (l) dari pencarian.
        //this.data.length - 1 adalah batas atas (h) dari pencarian.
        return binarySearch(k, 0, this.data.length-1);
    }

    int binarySearch(int k, int l, int h){
        //base case
        // Jika batas bawah l lebih besar dari batas atas h, ini berarti elemen tidak ditemukan dalam array, sehingga mengembalikan -1
        if(l>h) return -1;

            //recursive step
        else{
            // Menghitung indeks tengah m dengan (l + h) / 2.
            int m = (l+h)/2;
            // memanngil elemen array di data yang manah variabel m
            int v = this.data[m];

            //your code goes here
            // cek apakah nilai yang dicari == elemen index v
            // jika sama maka dia akan mengembalikan index m nya
            if(k==v) return m;
            // Jika k lebih besar dari v, maka elemen yang dicari berada di bagian kanan. Fungsi memanggil dirinya sendiri dengan m + 1 sebagai batas bawah dan h sebagai batas atas
            else if (k>v) return binarySearch(k, m+1, h);
            //// Jika k lebih kecil dari v, maka elemen yang dicari berada di bagian kiri. Fungsi memanggil dirinya sendiri dengan l sebagai batas bawah dan m - 1 sebagai batas atas
            else return binarySearch(k,l, m-1);

        }
    }


}