public class Sorting {
int data[];



Sorting(int [] a ){
    this.data = a;
}

// buat ngeprint arraynya
    public String toString(){
    String output = "";
    for (int m: data){
      output += " " + m;
    }
    return output;
    }

    void insertionSortAscending() {

        for (int i=1; i<this.data.length; i++){
            int temp  = this.data[i];
            int j;
                for ( j = i - 1; j >= 0 && this.data[j] > temp; j--) {
                    this.data[j+1] = this.data[j];



                }
            this.data[j+1] = temp;


        }

    }

    void selectionSort() {
        for (int i = 0; i < this.data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.data.length; j++) {
                if (this.data[j] < this.data[minIndex]) {  // Mencari elemen terkecil
                    minIndex = j;  // Update minIndex jika elemen yang lebih kecil ditemukan
                }
            }
            // Pertukaran dilakukan setelah selesai mencari elemen terkecil
            int temp = this.data[minIndex];  // Simpan elemen terkecil di temp
            this.data[minIndex] = this.data[i];  // Tukar elemen terkecil dengan elemen di indeks i
            this.data[i] = temp;  // Temp disimpan ke posisi i
        }

    }



}
