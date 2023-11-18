//import scanner untuk masukkan pengguna
import java.util.Scanner;
//class main untuk menjalankan code program
public class Main2 {
    public static void main(String[] args) {
        //membuat objek linkedlist dari class linkedlist
        LinkedList linkedList = new LinkedList();
        // Menambahkan node ke linkedlist
        linkedList.addSenjata("Enchanted Talisman", 9, 1870);
        linkedList.addSenjata("Divine Glaive", 11, 1970);
        linkedList.addSenjata("Winte Truncheon", 14, 1910);
        linkedList.addSenjata("Feather of Heaven", 1, 2030);
        linkedList.addSenjata("Holy Crystal", 0, 2180);    
        linkedList.addSenjata("Genius Wand", 6, 2000);
        linkedList.addSenjata("Necklace of Endurance", 10, 2110);
        linkedList.addSenjata("Concentrated Energy", 12, 2020);
        linkedList.addSenjata("Ice Queen Wand", 18, 2240);         
        linkedList.addSenjata("Glowing Wand", 16, 2120);
        linkedList.addSenjata("Calamity Reaper", 15, 1950);
        linkedList.addSenjata("Clock of Destiny", 19, 1950);
        linkedList.addSenjata("Blood Wings", 20, 3000);            
        linkedList.addSenjata("Fleeting Time", 21, 2050);            
        linkedList.addSenjata("Lighting Truncheon", 17, 2250);            
        //menampilkan senjata sebelum diurutkan
        System.out.println("Senjata sebelum diurutkan:");
        //fungsi untuk memanggil metode display pada linklist
        linkedList.displayLinkedlist();
        //fungsi untuk memanggil metode selection sort untuk urutkan data dari stoknya
        linkedList.selectionSortByStok();
        //fungsi untuk menampilkan senjata setelah diurutkan berdasarkan jumlah stok
        System.out.println("Senjata setelah diurutkan berdasarkan jumlah stok :");
        //fungsi untuk memanggil metode display untuk selection sort
        linkedList.displaySelect();
        //fungsi untuk memanggil metode yang mengurutkan berdasarkan harga
        linkedList.insertionSortByMaxHarga();
        //fungsi untuk menampilkan senjata setelah diurutkan berdasarkan harga terbesar
        System.out.println("Senjata setelah diurutkan berdasarkan harga terbesar:");
        //fungsi untuk memanggil metode display untuk insert sort
        linkedList.displayInsert();
        //fungsi untuk memanggil metode shellsort berdasarkan harga terkecil
        linkedList.shellSortByHargaKecil();
        //fungsi untuk menampilkan senjata setelah diurutkan berdasarkan harga terkecil
        System.out.println("Senjata setelah diurutkan berdasarkan harga terkecil:");
        //fungsi untuk memanggil metode display untuk shellsort
        linkedList.displayShell();
        //membuat objek scanner untuk input pengguna
        Scanner scanner = new Scanner(System.in);
        //fungsi untuk menampilkan masukkan harga yang ingin dicari
        System.out.println("Masukkan harga yang ingin dicari:");
        //variabel ini digunakan untuk menyimpan masukkan pengguna
        int targetHarga = scanner.nextInt();

        //membuat objek binarysearch berdasarkan data linklist
        BinarySearch binarySearch = new BinarySearch(linkedList);
        //memanggil metode binarysearchbyharga dengan acuan harga masukkan pengguna
        binarySearch.binarySearchByHarga(targetHarga);
    }
}