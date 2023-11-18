//class linklist dan beberapa sorting
class LinkedList {
    //node pertama dalam linkedlist
    Node head;

    // Fungsi untuk menambahkan node baru di awal linkedlist
    public void addSenjata(String nama, int stok, int harga) {
        //set newnode dengan node yang isinya nama, stok dan harga
        Node newNode = new Node(nama, stok, harga);
        //periksa jika head kosong
        if (head == null) {
            //head diisi node baru
            head = newNode;
        } else {
            //mengatur next dari newnode ke head
            newNode.next = head;
            //bagian node head merujuk ke prev node baru
            head.prev = newNode;
            //head menjadi node baru
            head = newNode;
        }
    }

    // Metode selection sort untuk mengurutkan berdasarkan jumlah stok terbanyak
    public void selectionSortByStok() {
        //jika node kosong atau hanya 1
        if (head == null || head.next == null) {
            //kembali dan tidak lakukan apa-apa
            return;
        }
        //set current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //set node maxnode dengan hasil metod mencari jumlah terbanyak
            Node maxNode = findMaxNodeByStok(current);
            //menukar node saat ini dengan node yang jumlah terbanyak
            swapNodes(current, maxNode);
            //set current ke next untuk pindah node
            current = current.next;
        }
    }

    // Metode insertion sort untuk mengurutkan berdasarkan harga terbesar
    public void insertionSortByMaxHarga() {
        //jika node kosong atau hanya satu, tidak melakukan proses dan kembali
        if (head == null || head.next == null) {
            return;
        }
        //set node current dengan head selanjutnya
        Node current = head.next;
        //melakukan perulangan jika current tidak kosong
        while (current != null) {
            //set node key dengan current
            Node key = current;
            //deklarasi keyharga untuk mendapatkan harga 
            int keyHarga = key.harga;
            //set node prev dengan prev dari node saat ini
            Node prev = current.prev;
            //iterasi selama prev tidak kosong dan harga dari node prev lebih kecil
            //dari key
            while (prev != null && prev.harga < keyHarga) {
                //tukar node prev dengan key
                swapNodes(prev, key);
                //set key jadi prev
                key = prev;
                //set prev jadi akan jadi prev sebelumnya, untuk melanjukan perulangan
                prev = prev.prev;
            }
            //set current ke next current untuk melanjutkan iterasi
            current = current.next;
        }
    }

// Metode shell sort untuk mengurutkan berdasarkan harga terkecil
public void shellSortByHargaKecil() {
    //deklarasi n dengan nilai dari proses count nodes
    int n = countNodes();
    // iterasi untuk gap=n/2 selama gab lebih dari 0
    // penggerak gap/2
    for (int gap = n / 2; gap > 0; gap /= 2) {
        //iterasi dengan i adalah gap selama i kurag dari countnodes
        for (int i = gap; i < n; i++) {
            //set node temp dengan metode mengambil node dari index tertentu
            Node temp = IndexNode(i);
            //deklarasi tempharga untuk menyimpan data harga yang didapat
            int tempHarga = temp.harga;
            //deklarasi j sebagai i
            int j = i;
            //lakukan perulangan selama j lebih dari gap dan harga 
            // pada node index ke j-gap lebih dari tempharga
            while (j >= gap && IndexNode(j - gap).harga > tempHarga) {
                // Perubahan dilakukan pada baris berikut
                swapNodes(IndexNode(j - gap), IndexNode(j));
                //kurangi j dengan gap untuk melanjutkan perulangan
                j -= gap;
            }
        }
    }
}

    // Metode untuk menemukan node dengan jumlah stok terbesar, dimulai dari node tertentu
    private Node findMaxNodeByStok(Node start) {
        //set maxnode sebagai node start
        Node maxNode = start;
        //set current sebagai node selanjutnya dari start
        Node current = start.next;
        //iterasi selama current tidak kosong
        while (current != null) {
            //periksa apa stok pada current lebih dari stok pada maxnode
            if (current.stok > maxNode.stok) {
                //jika iya set maxnode dengan nilai current
                maxNode = current;
            }
            //set current ke current selanjutnya untuk penggerak perulangan
            current = current.next;            
        }
        //mengembalikan maxnode yang didapat
        return maxNode;
    }

    // Metode untuk melakukan pertukaran dua node dalam linkedlist
    private void swapNodes(Node node1, Node node2) {
        //tukar nama, stok dan harga dari node1 pada var temp
        String tempNama = node1.nama;
        int tempStok = node1.stok;
        int tempHarga = node1.harga;
        //tukar nama, stok dan harga pada node2 ke node 1
        node1.nama = node2.nama;
        node1.stok = node2.stok;
        node1.harga = node2.harga;
        //kembalikan nama, stok, dan harga pada var temp ke node2
        node2.nama = tempNama;
        node2.stok = tempStok;
        node2.harga = tempHarga;
    }

    // Metode untuk menghitung jumlah node dalam linked list
    public int countNodes() {
        //set count dengan 0
        int count = 0;
        //set node current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //count bertambah 1
            count++;
            //current merujuk ke next untuk melakukan perulangan
            current = current.next;
        }
        //kembalikan nilai count
        return count;
    }

    // Metode untuk mendapatkan node pada indeks tertentu
    Node IndexNode(int index) {
        //set current dengan head
        Node current = head;
        //set count 0
        int count = 0;
        //melakukan perulangan selama current tidak kosong dan count lebih kecil dari index yang diterima
        while (current != null && count < index) {
            //set current ke next untuk penggerak
            current = current.next;
            //count bertambah 1
            count++;
        }

        return current;
    }
    //metode menampilkan data selection sort
    public void displaySelect() {
        //set current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //menampilkan data node current
            System.out.println("Id = " + current);
            System.out.println("Nama = " + current.nama);
            System.out.println("Stok = " + current.stok);
            System.out.println();
            current = current.next;
        }
    }
    //metode untuk menampilkan hasil insert sort
    public void displayInsert() {
        //set current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //menampilkan data node current
            System.out.println("Id = " + current);
            System.out.println("Nama = " + current.nama);
            System.out.println("Harga = " + current.harga);
            System.out.println();
            current = current.next;
        }
    }
    //metode untuk menampilkan hasil shell sort
    public void displayShell() {
        //set current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //menampilkan data node current
            System.out.println("Id = " + current);
            System.out.println("Nama = " + current.nama);
            System.out.println("Harga = " + current.harga);
            System.out.println();
            current = current.next;
        }
    }
    //metode untuk menampilkan data tidak tersort
    public void displayLinkedlist() {
        //set current dengan head
        Node current = head;
        //iterasi selama current tidak kosong
        while (current != null) {
            //menampilkan data node current
            System.out.println("Id = " + current);
            System.out.println("Nama = " + current.nama);
            System.out.println("Stok = " + current.stok);
            System.out.println("Harga = " + current.harga);
            System.out.println();
            current = current.next;
        }
    }
    //getter untuk head node
    public Node getHead (){
        return head;
    }
}
