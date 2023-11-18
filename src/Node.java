/* Node untuk linkedlist */
public class Node {
    /* deklarasi variabel untuk menyimpan nama senjata */
    /* deklarasi variabel untuk menyimpan jumlah stok dan harga */
    /* inisialisasi node selanjutnya dan sebelumnya karena menggunakan linkedlist */
    String nama;
    int stok;
    int harga;
    Node prev;
    Node next;
    /* konstruktor untuk membuat objek node dengan variabel yang sudah dibuat */
    public Node(String nama, int stok, int harga) {
        /* konstruktor yang berisi nama, stok, dan harga */
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        /* set konstruktor tidak ada node awal atau sebelumnya */
        this.prev = null;
        this.next = null;
    }
}