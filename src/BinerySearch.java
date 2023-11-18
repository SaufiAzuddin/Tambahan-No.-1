/*class untuk implementasi binary search */
class BinarySearch {
    //deklarasi linklist yang akan dicari
    private LinkedList linkedList; 
    //konstruktor untuk objek binarysearch dengan linkedlist yang diberikan
    public BinarySearch(LinkedList linkedList) {
        this.linkedList = linkedList;
    }
    //metode binary search yang mengacu pada harga
    public void binarySearchByHarga(int cariHarga) {
        //set var low = 0, jadi batas cari bawah
        int low = 0;
        //set var high dengan hasil countnode berdasarkan linkedlist dikurangi 1
        //ini menjadi batas pencarian atas
        int high = linkedList.countNodes() - 1;
        //melakukan perulangan selama batas bawah tidak lebih dari batas atas
        while (low <= high) {
            //set value mid dengan operasi matematis
            int mid = low + (high - low) / 2;
            //node dari indeks ditengah diambil dari IndexNode mid
            Node midNode = linkedList.IndexNode(mid);
            //untuk menyimpan harga pada node tengan dengan ambil data harga dari midnode
            int midHarga = midNode.harga;
            //memeriksa jika harga pada node tengah sama dengan target pencarian
            if (midHarga == cariHarga) {
                //menampilkan nama senjata, harga dan stok senjata
                System.out.println("Senjata dengan harga " + cariHarga + " ditemukan pada posisi ke -" + mid + 1);
                System.out.println("Nama: " + midNode.nama);
                System.out.println("Stok: " + midNode.stok);
                System.out.println("Harga: " + midNode.harga);
                //memeriksa jika nilai mid +1 lebih kecil dari count node
                if (mid + 1 < linkedList.countNodes()) {
                    //nextnode akan menyimpan data mid+1
                    Node nextNode = linkedList.IndexNode(mid + 1);
                    //menampilkan data node mid+1
                    System.out.println("\nTerletak setelah");
                    System.out.println("Nama: " + nextNode.nama);
                    System.out.println("Stok: " + nextNode.stok);
                    System.out.println("Harga: " + nextNode.harga);
                }//memeriksa jika mid-1 lebih dari atau sama 0
                if (mid - 1 >= 0) {
                    //prevnode diset dengan data dari node ke mid-1
                    Node prevNode = linkedList.IndexNode(mid - 1);
                    //menampilkan data node ke mid-1
                    System.out.println("\nTerletak sebelum");
                    System.out.println("Nama: " + prevNode.nama);
                    System.out.println("Stok: " + prevNode.stok);
                    System.out.println("Harga: " + prevNode.harga);
                }
                //keluar dari metode setelah menemukan senjata
                return;
            //memeriksa jika harga ditengah lebih kecil dari harga yang dicari
            } else if (midHarga < cariHarga) {
                //nilai low di set sebagai mid+1
                low = mid + 1;
                //jika tidak 
            } else {
                //nilai high diset sebagai mid-1
                high = mid - 1;
            }
        }
        //selain dari itu menampilkan senjata tidak ditemukan
            System.out.println("Senjata dengan harga " + cariHarga + " tidak ditemukan.");
    }

    //metode mendapatkan node indeks tertentu
    public Node IndexNode(int index) {
        //node current di set dengan mengambil head dari linkedlist
        Node current = linkedList.getHead();
        //set count dengan 0
        int count = 0;
        //perulangan selama current tidak kosong dan count lebih kecil dari index
        while (current != null && count < index) {
            //set current dengan current selanjutnya untuk perulangan
            current = current.next;
            //jumlah count +1
            count++;
        }
        //mengembalikan node pada indeks
        return current;
    }
    //metode menghitung jumlah node dalam linkedlist 
    public int countNodes() {
        //set count=0
        int count = 0;
        //set node current dengan head dari gethead pada linkedlist
        Node current = linkedList.getHead();
        //perulangan selama current toak 0
        while (current != null) {
            //jumlah count bertambah
            count++;
            //current di set untuk current selanjutnya
            current = current.next;
        }
        //mengembalikan jumlah node
        return count;
    }
}
