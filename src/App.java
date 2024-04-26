import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;



public class App {

    public static void tambahDenda() {
        LocalDate today = LocalDate.now();
        
        for (Peminjaman peminjaman : peminjamans) {
            LocalDate tanggalPinjam = LocalDate.parse(peminjaman.getTanggalPinjam());
            long daysBetween = ChronoUnit.DAYS.between(tanggalPinjam, today);
            
            if (daysBetween > 7) {
                int jumlahDenda = (int) (daysBetween - 7) * 10000;
                Pembayaran pembayaran = new Pembayaran();
                pembayaran.setIdPeminjaman(peminjaman.getIdPeminjaman());
                pembayaran.setJumlahDenda(jumlahDenda);
                
                pembayarans.add(pembayaran);
            }
        }
    }
    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Buku> bukus = new ArrayList<>();
    private static ArrayList<Pengembalian> pengembalians = new ArrayList<>();
    private static ArrayList<Peminjaman> peminjamans = new ArrayList<>();
    private static ArrayList<Pembayaran> pembayarans = new ArrayList<>();
    private static ArrayList<Mahasiswa> membermhs = new ArrayList<>();
    private static ArrayList<DosenStaf> memberdosen = new ArrayList<>();

    public static void contohBuku () {
        Buku buku1 = new Buku(1, "Petualangan Wakwaw", "Wakwaw", "Wakwaw", 1900, "Berseri", "Soft", "Kriminal" );
        bukus.add(buku1);
        
        // Contoh denda 2
        Buku buku2 = new Buku(2, "Petualangan Asep", "Asep", "Asep", 1910, "Berseri", "Hard", "Thriller" );
        bukus.add(buku2);
        
        // Contoh denda 3
        Buku buku3 = new Buku(3, "10 dosa besar soeharto", "yanto", "yanti", 1920, "Berseri", "Soft", "Romance" );
        bukus.add(buku3);
        }
    
    public static void contohPengembalianBuku () {
        Pengembalian peng1 = new Pengembalian(1, 1, "Nicki Minaj", "20 Desember 2077", 5 );
        pengembalians.add(peng1);
            
            // Contoh denda 2
        Pengembalian peng2 = new Pengembalian(2, 2, "Kang Dadang", "21 Desember 2077", 6);
        pengembalians.add(peng2);
            
            // Contoh denda 3
        Pengembalian peng3 = new Pengembalian(3, 3, "Supri", "22 Desember 2077", 7);
        pengembalians.add(peng3);
            }

     public static void contohPeminjamanBuku () {
        Peminjaman pinjam1 = new Peminjaman(1, 1, "Nicki Minaj", "20 Juli 2077");
        peminjamans.add(pinjam1);
                    
                    // Contoh denda 2
        Peminjaman pinjam2 = new Peminjaman(2, 2, "Kang Dadang", "21 Juli 2077");
        peminjamans.add(pinjam2);
                    
                    // Contoh denda 3
        Peminjaman pinjam3 = new Peminjaman(3, 3, "Supri", "22 Juli 2077");
        peminjamans.add(pinjam3);
            }
    

    public static void contohDenda () {
    Pembayaran denda1 = new Pembayaran(1, 1, 2, "Terlambat", 20000, false);
    pembayarans.add(denda1);
    
    // Contoh denda 2
    Pembayaran denda2 = new Pembayaran(2, 2, 1, "Kerusakan", 15000, true);
    pembayarans.add(denda2);
    
    // Contoh denda 3
    Pembayaran denda3 = new Pembayaran(3, 3, 3, "Hilang", 30000, false);
    pembayarans.add(denda3);
    }

    
    public static void main(String[] args) throws Exception {
        contohBuku();
        contohPengembalianBuku();
        contohPeminjamanBuku();
        contohDenda();

        int roleChoice;
        boolean isValidRole = false;

        System.out.println("Selamat datang di Aplikasi Perpustakaan!");

        do {
            try {        // Memilih role
        System.out.println("Apakah Anda ingin login sebagai Pustakawan atau Pengunjung?");
        System.out.println("1. Pustakawan");
        System.out.println("2. Pengunjung");
        roleChoice = scanner.nextInt();

        switch (roleChoice) {
            case 1:
                loginPustakawan();
                isValidRole = true;
                break;
            case 2:
                menuPengunjung();
                isValidRole = true;
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan pilih lagi.");
                break;
        }
    } catch (Exception e) {
        System.out.println("Pilihan tidak valid! Silahkan pilih lagi ");
        scanner.nextLine(); // Membersihkan buffer input
    }
} while (!isValidRole);
    }

    public static void loginPustakawan() {
        boolean isValid = false;

        do {
            try {
                System.out.println("Masukkan username:");
                String username = scanner.next();
                System.out.println("Masukkan password:");
                String password = scanner.next();

                if (PustakawanRepository.isValidLogin(username, password)) {
                    System.out.println("Login berhasil!");
                    isValid = true;
                    menuPustakawan();
                } else {
                    System.out.println("Username atau password salah! Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer input
            }
        } while (!isValid);
    }

    public static void menuPustakawan() {
        int choice;
        boolean continueMenu = true;

        do {
            try {
                System.out.println("\nMenu Pustakawan:");
                System.out.println("1. Menyediakan Buku");
                System.out.println("2. Mengatur Pengembalian Buku");
                System.out.println("3. Mengatur Peminjaman");
                System.out.println("4. Mengatur Denda");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        menyediakanBuku();
                        break;
                    case 2:
                        mengaturPengembalianBuku();
                        break;
                    case 3:
                        mengaturPeminjamanBuku();
                        break;
                    case 4:
                        mengaturPembayaranDenda();
                        break;
                    case 5:
                        System.out.println("Terima kasih telah menggunakan aplikasi perpustakaan!");
                        continueMenu = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih menu lagi.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer input
            }
        } while (continueMenu);
    }

    public static void buatMember() {

        boolean isValidRole = true;
        do {       
        System.out.println("\nApakah anda Mahasiswa atau Dosen/Staf?");
        System.out.println("1. Mahasiswa");
        System.out.println("2. Dosen/Staf");
        System.out.println("3. Keluar");
        int roleChoice = scanner.nextInt();
        scanner.nextLine();

        switch (roleChoice) {
            case 1:
                memberMahasiswa();
                break;
            case 2:
                memberDosenStaf();
                break;
            case 3:
                isValidRole = false;
                break;
            default:
                System.out.println("Pilihan tidak valid! Silakan pilih lagi.");
                break;
        }
           }   while (isValidRole);
    }


    public static void memberMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();

        int nim = 0;
        boolean idNim = false;
        while (!idNim) {
            try {
                System.out.println("Masukkan NIM: ");
                nim = Integer.parseInt(scanner.nextLine());
                idNim = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: NIM harus berupa bilangan bulat.");
            }
        }
        
        mahasiswa.setNIM(nim);

        String nama = "";
        while (nama.isEmpty()) {
            System.out.println("Masukkan Nama: ");
            nama = scanner.nextLine();
            if (nama.isEmpty()) {
                System.out.println("Error: Nama tidak boleh kosong.");
            }
        }
        mahasiswa.setNama(nama);

        String password = "";
        while (password.isEmpty()) {
            System.out.println("Masukkan password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Error: Password tidak boleh kosong.");
            }
        }
        mahasiswa.setPassword(password);

        String fakultas = "";
        while (fakultas.isEmpty()) {
            System.out.println("Masukkan nama Fakultas: ");
            fakultas = scanner.nextLine();
            if (fakultas.isEmpty()) {
                System.out.println("Error: Fakultas tidak boleh kosong.");
            }
        }
        mahasiswa.setFakultas(fakultas);

        String alamat = "";
        while (alamat.isEmpty()) {
            System.out.println("Masukkan alamat: ");
            alamat = scanner.nextLine();
            if (alamat.isEmpty()) {
                System.out.println("Error: Alamat tidak boleh kosong.");
            }
        }
        mahasiswa.setAlamat(alamat);

        String noHp = "";
        while (noHp.isEmpty()) {
            System.out.println("Masukkan No HP: ");
            noHp = scanner.nextLine();
            if (noHp.isEmpty()) {
                System.out.println("Error: No HP tidak boleh kosong.");
            }
        }
        mahasiswa.setNoHp(noHp);

        String status = "";
        while (status.isEmpty()) {
            System.out.println("Masukkan Status: ");
            status = scanner.nextLine();
            if (status.isEmpty()) {
                System.out.println("Error: Status tidak boleh kosong.");
            }
        }
        mahasiswa.setStatus(status);

        System.out.println("\nMember berhasil dibuat!");

        membermhs.add(mahasiswa);

    }

    public static void memberDosenStaf() {
        DosenStaf dosenstaf = new DosenStaf();

        int nik = 0;
        boolean idNik = false;
        while (!idNik) {
            try {
                System.out.println("Masukkan NIK: ");
                nik = Integer.parseInt(scanner.nextLine());
                idNik = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: NIK harus berupa bilangan bulat.");
            }
        }
        
        dosenstaf.setNIK(nik);

        String nama = "";
        while (nama.isEmpty()) {
            System.out.println("Masukkan Nama: ");
            nama = scanner.nextLine();
            if (nama.isEmpty()) {
                System.out.println("Error: Nama tidak boleh kosong.");
            }
        }
        dosenstaf.setNama(nama);

        String password = "";
        while (password.isEmpty()) {
            System.out.println("Masukkan password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Error: Password tidak boleh kosong.");
            }
        }
        dosenstaf.setPassword(password);

        String fakultas = "";
        while (fakultas.isEmpty()) {
            System.out.println("Masukkan nama Fakultas: ");
            fakultas = scanner.nextLine();
            if (fakultas.isEmpty()) {
                System.out.println("Error: Fakultas tidak boleh kosong.");
            }
        }
        dosenstaf.setFakultas(fakultas);

        String alamat = "";
        while (alamat.isEmpty()) {
            System.out.println("Masukkan alamat: ");
            alamat = scanner.nextLine();
            if (alamat.isEmpty()) {
                System.out.println("Error: Alamat tidak boleh kosong.");
            }
        }
        dosenstaf.setAlamat(alamat);

        String noHp = "";
        while (noHp.isEmpty()) {
            System.out.println("Masukkan No HP: ");
            noHp = scanner.nextLine();
            if (noHp.isEmpty()) {
                System.out.println("Error: No HP tidak boleh kosong.");
            }
        }
        dosenstaf.setNoHp(noHp);

        String status = "";
        while (status.isEmpty()) {
            System.out.println("Masukkan Status: ");
            status = scanner.nextLine();
            if (status.isEmpty()) {
                System.out.println("Error: Status tidak boleh kosong.");
            }
        }
        dosenstaf.setStatus(status);

        System.out.println("Member berhasil dibuat!");

        memberdosen.add(dosenstaf);
    }

    public static void menuPengunjung() {
        int choice;
        boolean continueMenu = true;

        do {
            try {
                System.out.println("\nMenu Pengunjung:");
                System.out.println("1. Lihat Daftar Buku");
                System.out.println("2. Melakukan Peminjaman (Member)");
                System.out.println("3. Buat Member");
                System.out.println("4. Keluar");
                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        lihatDaftarBuku();
                        break;
                    case 2:
                        memasukkanMember();
                        break;
                    case 3:
                        buatMember();
                        break;
                    case 4:
                        continueMenu = false;
                        break;    
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih menu lagi.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer input
            }
        } while (continueMenu);
    }

    public static void lihatDaftarBuku() {
        System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-10s | %-10s%n",
         "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Edisi", "Jenis Sampul", "Kategori");

         for (Buku buku : bukus) {
            System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-12s | %-10s%n",
            buku.getIdBuku(), truncateString(buku.getJudulBuku(), 20), truncateString(buku.getPengarang(), 15), truncateString(buku.getPenerbit(), 15),
            buku.getTahunTerbit(), buku.getEdisiTerbit(), truncateString(buku.getJenisSampul(), 15), truncateString(buku.getKategori(), 10));
        }

        int choice;
        boolean continueMenu = true;

        do {
            System.out.println("1. Cetak daftar buku ke dalam file .txt");
            System.out.println("2. Keluar");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                try (FileWriter writer = new FileWriter("daftar_buku.txt")) {
                    writer.write(String.format("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-10s | %-10s%n",
                    "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Edisi", "Jenis Sampul", "Kategori"));
            
        
                for (Buku buku : bukus) {
                writer.write(String.format("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-12s | %-10s%n",
                        buku.getIdBuku(), buku.getJudulBuku(), buku.getPengarang(), buku.getPenerbit(),
                        buku.getTahunTerbit(), buku.getEdisiTerbit(), buku.getJenisSampul(), buku.getKategori()));
                }
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan saat mencetak file: " + e.getMessage());
                }
                break;
                case 2:
                continueMenu = false;
                break;
            }
        } while (continueMenu);
    }

    public static void memasukkanMember() {
        int choice;
        boolean continueMenu = true;

        do {
                System.out.println("\nApakah Anda Mahasiswa atau Dosen/Staf?");
                System.out.println("1. Mahasiswa");
                System.out.println("2. Dosen/Staf");
                System.out.println("3. Keluar");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan NIM: ");
                        int nim = scanner.nextInt();
                        scanner.nextLine(); // Clear the buffer
                        System.out.print("Masukkan Password: ");
                        String password = scanner.nextLine();

                        boolean isMemberValid = false;
                        for (Mahasiswa member : membermhs) {
                            if (member.getNIM() == nim && member.getPassword().equals(password)) {
                                isMemberValid = true;
                                break;
                            }
                        }
                        if (isMemberValid) {
                            System.out.println("Login berhasil!");
                            melakukanPeminjaman();
                        } else {
                            System.out.println("NIM atau Password salah. Login gagal.");
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan NIK: ");
                        int nik = scanner.nextInt();
                        scanner.nextLine(); // Clear the buffer
                        System.out.print("Masukkan Password: ");
                        String password2 = scanner.nextLine();

                        boolean isMemberValid2 = false;
                        for (DosenStaf member : memberdosen) {
                            if (member.getNIK() == nik && member.getPassword().equals(password2)) {
                                isMemberValid2 = true;
                                break;
                            }
                        }

                        if (isMemberValid2) {
                            System.out.println("Login berhasil!");
                            melakukanPeminjaman();
                        } else {
                            System.out.println("NIK atau Password salah. Login gagal.");
                        }
                        break;
                    case 3:
                        continueMenu = false;
                        break; 
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih menu lagi.");
                        break;
                    }
    } while (continueMenu);
}

    public static void melakukanPeminjaman() {
        System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-10s | %-10s%n",
         "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Edisi", "Jenis Sampul", "Kategori");

         for (Buku buku : bukus) {
            System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-12s | %-10s%n",
            buku.getIdBuku(), truncateString(buku.getJudulBuku(), 20), truncateString(buku.getPengarang(), 15), truncateString(buku.getPenerbit(), 15),
            buku.getTahunTerbit(), buku.getEdisiTerbit(), truncateString(buku.getJenisSampul(), 15), truncateString(buku.getKategori(), 10));
        }



        int idBukuPilihan;
        do {
            System.out.print("Masukkan ID buku yang ingin dipinjam: ");
            idBukuPilihan = scanner.nextInt();
            if (idBukuPilihan <= 0) {
                System.out.println("ID buku tidak valid! Silakan masukkan ID buku yang benar.");
            }
        } while (idBukuPilihan <= 0);
        
        Buku bukuPilihan = null;
        for (Buku buku : bukus) {
            if (buku.getIdBuku() == idBukuPilihan) {
                bukuPilihan = buku;
                break;
            }
        }
        
        if (bukuPilihan != null) {
            System.out.println("Anda memilih buku: " + bukuPilihan.getJudulBuku());
            // Lakukan operasi lain sesuai kebutuhan setelah memilih buku
        } else {
            System.out.println("Buku dengan ID tersebut tidak ditemukan.");
        }
    }

    public static void menyediakanBuku() {
        boolean continueMenu = true;
    
        do {   

            System.out.println("Daftar Buku:");
            System.out.println("==============");
    
            // Output format list tabel berdasarkan class buku
            System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-10s | %-10s%n",
         "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Edisi", "Jenis Sampul", "Kategori");

         for (Buku buku : bukus) {
            System.out.printf("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-12s | %-10s%n",
            buku.getIdBuku(), truncateString(buku.getJudulBuku(), 20), truncateString(buku.getPengarang(), 15), truncateString(buku.getPenerbit(), 15),
            buku.getTahunTerbit(), buku.getEdisiTerbit(), truncateString(buku.getJenisSampul(), 15), truncateString(buku.getKategori(), 10));
        }
        
    
            System.out.println("\nMenu Penyediaan Buku:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Print Tabel ke File .txt");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    printBukuToFile();
                    break;
                case 3:
                    continueMenu = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
        } 
    } while (continueMenu);
    }
    
    public static void tambahBuku() {
        // Implementasi untuk menambahkan buku berdasarkan atribut dari class buku
        Buku buku = new Buku();

        int id = 0;
        boolean idValid = false;
        while (!idValid) {
            try {
                System.out.println("Masukkan ID: ");
                id = Integer.parseInt(scanner.nextLine());
                idValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: ID harus berupa bilangan bulat.");
            }
        }
        buku.setIdBuku(id);

        // Loop untuk mengulang input hanya untuk atribut yang mengalami kesalahan sebelumnya
        String judul = "";
        while (judul.isEmpty()) {
            System.out.println("Masukkan Judul Buku: ");
            judul = scanner.nextLine();
            if (judul.isEmpty()) {
                System.out.println("Error: Judul tidak boleh kosong.");
            }
        }
        buku.setJudulBuku(judul);

        String pengarang = "";
        while (pengarang.isEmpty()) {
            System.out.println("Masukkan Pengarang: ");
            pengarang = scanner.nextLine();
            if (pengarang.isEmpty()) {
                System.out.println("Error: Pengarang tidak boleh kosong.");
            }
        }
        buku.setPengarang(pengarang);

        String penerbit = "";
        while (penerbit.isEmpty()) {
            System.out.println("Masukkan Penerbit: ");
            penerbit = scanner.nextLine();
            if (penerbit.isEmpty()) {
                System.out.println("Error: Penerbit tidak boleh kosong.");
            }
        }
        buku.setPenerbit(penerbit);

        int tahunTerbit = 0;
        boolean tahunValid = false;
        while (!tahunValid) {
            try {
                System.out.println("Masukkan Tahun Terbit: ");
                tahunTerbit = Integer.parseInt(scanner.nextLine());
                tahunValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Tahun terbit harus berupa bilangan bulat.");
            }
        }
        buku.setTahunTerbit(tahunTerbit);

        String edisiTerbit = "";
        while (edisiTerbit.isEmpty()) {
            System.out.println("Masukkan Edisi: ");
            edisiTerbit = scanner.nextLine();
            if (edisiTerbit.isEmpty()) {
                System.out.println("Error: Edisi tidak boleh kosong.");
            }
        }
        buku.setEdisiTerbit(edisiTerbit);

        String jenisSampul = "";
        while (jenisSampul.isEmpty()) {
            System.out.println("Masukkan Jenis Sampul: ");
            jenisSampul = scanner.nextLine();
            if (jenisSampul.isEmpty()) {
                System.out.println("Error: Jenis sampul tidak boleh kosong.");
            }
        }
        buku.setJenisSampul(jenisSampul);

        String kategori = "";
        while (kategori.isEmpty()) {
            System.out.println("Masukkan Kategori: ");
            kategori = scanner.nextLine();
            if (kategori.isEmpty()) {
                System.out.println("Error: Kategori tidak boleh kosong.");
            }
        }
        buku.setKategori(kategori);

        bukus.add(buku);
    }
    
    public static void printBukuToFile() {
        try (FileWriter writer = new FileWriter("daftar_buku.txt")) {
            // Implementasi untuk menulis daftar buku ke file
            // Tuliskan setiap buku dalam format yang sesuai ke file
            writer.write(String.format("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-10s | %-10s%n",
            "ID", "Judul Buku", "Pengarang", "Penerbit", "Tahun Terbit", "Edisi", "Jenis Sampul", "Kategori"));
    
    // Tulis setiap buku dalam format yang sesuai ke file
        for (Buku buku : bukus) {
        writer.write(String.format("%-4s| %-30s | %-15s | %-15s | %-13s | %-7s | %-12s | %-10s%n",
                buku.getIdBuku(), buku.getJudulBuku(), buku.getPengarang(), buku.getPenerbit(),
                buku.getTahunTerbit(), buku.getEdisiTerbit(), buku.getJenisSampul(), buku.getKategori()));
        }
    } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat mencetak file: " + e.getMessage());
    }
}

public static void mengaturPengembalianBuku() {
    boolean continueMenu = true;

    do {
        System.out.println("Daftar Buku yang Telah Dikembalikan:");
        System.out.println("==================================");

        // Output format list tabel berdasarkan class pengembalian
        System.out.printf("%-15s| %-15s | %-25s | %-25s | %-13s%n",
        "ID Pengembalian", "ID Peminjaman", "Pustakawan", "Tanggal Kembali", "Jumlah Pengembalian");

        for (Pengembalian pengembalian : pengembalians) {
           System.out.printf("%-15s| %-15s | %-25s | %-25s | %-13s%n",
           pengembalian.getIdPengembalian(), pengembalian.getIdPeminjaman(), truncateString(pengembalian.getPustakawan(), 15), pengembalian.getTanggalKembali(),
           pengembalian.getJumlahPengembalian());
       }

        System.out.println("\nMenu Pengembalian Buku:");
        System.out.println("1. Tambah Buku yang Telah Dikembalikan");
        System.out.println("2. Print Tabel ke File .txt");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                tambahPengembalianBuku();
                break;
            case 2:
                printPengembalianToFile();
                break;
            case 3:
                continueMenu = false;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    } while (continueMenu);
}

public static void tambahPengembalianBuku() {
    // Implementasi untuk menambahkan buku yang telah dikembalikan berdasarkan atribut dari class pengembalian
    Pengembalian pengembalian = new Pengembalian();
    
    int idPengembalian = 0;
    int idPinjam = 0;
    String namaPustakawan = "";
    String tanggalKembali = "";
    int jumlahPengembalian = 0;

    // Validasi dan input untuk ID Pengembalian
    boolean idValid = false;
    while (!idValid) {
        try {
            System.out.println("Masukkan ID Pengembalian: ");
            idPengembalian = Integer.parseInt(scanner.nextLine());
            idValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: ID Pengembalian harus berupa bilangan bulat.");
        }
    }
    pengembalian.setIdPengembalian(idPengembalian);

    // Validasi dan input untuk ID Peminjaman
    boolean idPinjamValid = false;
    while (!idPinjamValid) {
        try {
            System.out.println("Masukkan ID Peminjaman: ");
            idPinjam = Integer.parseInt(scanner.nextLine());
            idPinjamValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: ID Peminjaman harus berupa bilangan bulat.");
        }
    }
    pengembalian.setIdPeminjaman(idPinjam);

    // Validasi dan input untuk Nama Pustakawan
    while (namaPustakawan.isEmpty()) {
        System.out.println("Masukkan Nama Pustakawan: ");
        namaPustakawan = scanner.nextLine();
        if (namaPustakawan.isEmpty()) {
            System.out.println("Error: Nama Pustakawan tidak boleh kosong.");
        }
    }
    pengembalian.setPustakawan(namaPustakawan);

    // Validasi dan input untuk Tanggal Kembali
    while (tanggalKembali.isEmpty()) {
        System.out.println("Masukkan Tanggal Kembali: ");
        tanggalKembali = scanner.nextLine();
        if (tanggalKembali.isEmpty()) {
            System.out.println("Error: Tanggal Kembali tidak boleh kosong.");
        }
    }
    pengembalian.setTanggalKembali(tanggalKembali);

    // Validasi dan input untuk Jumlah Pengembalian
    boolean jumlahValid = false;
    while (!jumlahValid) {
        try {
            System.out.println("Masukkan Jumlah Pengembalian: ");
            jumlahPengembalian = Integer.parseInt(scanner.nextLine());
            jumlahValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: Jumlah Pengembalian harus berupa bilangan bulat.");
        }
    }
    pengembalian.setJumlahPengembalian(jumlahPengembalian);

        pengembalians.add(pengembalian);
    }


public static void printPengembalianToFile() {
    try (FileWriter writer = new FileWriter("daftar_pengembalian.txt")) {
        
        writer.write(String.format("%-15s| %-15s | %-25s | %-25s | %-13s%n",
        "ID Pengembalian", "ID Peminjaman", "Pustakawan", "Tanggal Kembali", "Jumlah Pengembalian"));

        for (Pengembalian pengembalian : pengembalians) {
           writer.write(String.format("%-15s| %-15s | %-25s | %-25s | %-13s%n",
           pengembalian.getIdPengembalian(), pengembalian.getIdPeminjaman(), truncateString(pengembalian.getPustakawan(), 15), pengembalian.getTanggalKembali(),
           pengembalian.getJumlahPengembalian()));
       }

    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat mencetak file: ");
    }
}

public static void mengaturPeminjamanBuku() {
    boolean continueMenu = true;

    do {
        System.out.println("Daftar Buku yang Sedang Dipinjam:");
        System.out.println("==================================");

        System.out.printf("%-15s| %-15s | %-25s | %-25s%n",
        "ID Peminjaman", "ID Klien", "Pustakawan", "Tanggal Pinjam");

        for (Peminjaman peminjaman : peminjamans) {
           System.out.printf("%-15s| %-15s | %-25s | %-25s%n",
           peminjaman.getIdPeminjaman(), peminjaman.getIdPeminjaman(), peminjaman.getPustakawan(), peminjaman.getTanggalPinjam());
       }

        System.out.println("\nMenu Pengembalian Buku:");
        System.out.println("1. Tambah Buku yang akan Dipinjam");
        System.out.println("2. Print Tabel ke File .txt");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                tambahPeminjamanBuku();
                break;
            case 2:
                printPeminjamanToFile();
                break;
            case 3:
                continueMenu = false;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    } while (continueMenu);
}

public static void tambahPeminjamanBuku() {
    Peminjaman peminjaman = new Peminjaman();

    int idPeminjaman = 0;
    int idKlien = 0;
    String namaPustakawan = "";
    String tanggalPinjam = "";

    boolean idValid = false;
    while (!idValid) {
        try {
            System.out.println("Masukkan ID Peminjaman: ");
            idPeminjaman = Integer.parseInt(scanner.nextLine());
            idValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: ID Peminjaman harus berupa bilangan bulat.");
        }
    }
    peminjaman.setIdPeminjaman(idPeminjaman);

    // Validasi dan input untuk ID Peminjaman
    boolean idKlienValid = false;
    while (!idKlienValid) {
        try {
            System.out.println("Masukkan ID Klien: ");
            idKlien = Integer.parseInt(scanner.nextLine());
            idKlienValid = true;
        } catch (NumberFormatException e) {
            System.out.println("Error: ID Klien harus berupa bilangan bulat.");
        }
    }
    peminjaman.setIdKlien(idKlien);

    // Validasi dan input untuk Nama Pustakawan
    while (namaPustakawan.isEmpty()) {
        System.out.println("Masukkan Nama Pustakawan: ");
        namaPustakawan = scanner.nextLine();
        if (namaPustakawan.isEmpty()) {
            System.out.println("Error: Nama Pustakawan tidak boleh kosong.");
        }
    }
    peminjaman.setPustakawan(namaPustakawan);

    // Validasi dan input untuk Tanggal Kembali
    while (tanggalPinjam.isEmpty()) {
        System.out.println("Masukkan Tanggal Pinjam: ");
        tanggalPinjam = scanner.nextLine();
        if (tanggalPinjam.isEmpty()) {
            System.out.println("Error: Tanggal Pinjam tidak boleh kosong.");
        }
    }
    peminjaman.setTanggalPinjam(tanggalPinjam);
    
    peminjamans.add(peminjaman);
}

public static void printPeminjamanToFile() {
    try (FileWriter writer = new FileWriter("daftar_peminjaman.txt")) {
        // Implementasi untuk menulis daftar buku yang telah dikembalikan ke file
        writer.write(String.format("%-15s| %-15s | %-25s | %-25s%n",
        "ID Peminjaman", "ID Klien", "Pustakawan", "Tanggal Pinjam"));

        for (Peminjaman peminjaman : peminjamans) {
            writer.write(String.format("%-15s| %-15s | %-25s | %-25s%n",
           peminjaman.getIdPeminjaman(), peminjaman.getIdKlien(),peminjaman.getPustakawan(), peminjaman.getTanggalPinjam()));
        }
        // Tuliskan setiap data pengembalian dalam format yang sesuai ke file
    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat mencetak file: ");
    }
}

public static void mengaturPembayaranDenda() {
    boolean continueMenu = true;

    do {
        System.out.println("Daftar Peminjam Yang Memiliki Denda:");
        System.out.println("==================================");

        System.out.printf("%-10s| %-25s | %-20s | %-30s | %-15s%n",
        "ID Denda", "Jumlah Buku Dibayar", "Kategori Denda", "Jumlah Denda", "Status Kerusakan");

        for (Pembayaran pembayaran : pembayarans) {
           System.out.printf("%-10s| %-25s | %-20s | %-30s | %-15s%n",
           pembayaran.getIdDenda(), pembayaran.getJumlahBukuDibayar(), pembayaran.getKategoriDenda(), pembayaran.getJumlahDenda(), pembayaran.isStatusKerusakan());
       }

        System.out.println("\nMenu Pengaturan Denda:");
        System.out.println("1. Hapus Denda");
        System.out.println("2. Print Tabel ke File .txt");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                hapusDenda();
                break;
            case 2:
                printDendaToFile();
                break;
            case 3:
                continueMenu = false;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    } while (continueMenu);
}


public static void hapusDenda() {
    
    System.out.println("Masukkan ID Denda untuk menghapus:");
    int idDenda = scanner.nextInt();
    scanner.nextLine();

    boolean dendaDihapus = false;
    Iterator<Pembayaran> iterator = pembayarans.iterator();
    while (iterator.hasNext()) {
    Pembayaran pembayaran = iterator.next();
    if (pembayaran.getIdDenda() == idDenda) {
        iterator.remove();
        System.out.println("Denda dengan ID " + idDenda + " berhasil dihapus.");
        dendaDihapus = true;
        break;
    }
}

    if (!dendaDihapus) {
    System.out.println("Denda dengan ID " + idDenda + " tidak ditemukan.");
    }
}

public static void printDendaToFile() {
    try (FileWriter writer = new FileWriter("daftar_denda.txt")) {
        // Implementasi untuk menulis daftar buku yang telah dikembalikan ke file
        writer.write(String.format("%-10s| %-25s | %-20s | %-30s | %-15s%n",
        "ID Denda", "Jumlah Buku Dibayar", "Kategori Denda", "Jumlah Denda", "Status Kerusakan"));

        for (Pembayaran pembayaran : pembayarans) {
           writer.write(String.format("%-10s| %-25s | %-20s | %-30s | %-15s%n",
           pembayaran.getIdDenda(), pembayaran.getJumlahBukuDibayar(), pembayaran.getKategoriDenda(), pembayaran.getJumlahDenda(), pembayaran.isStatusKerusakan()));
       }
        // Tuliskan setiap data pengembalian dalam format yang sesuai ke file
    } catch (IOException e) {
        System.out.println("Terjadi kesalahan saat mencetak file: ");
    }
}

public static String truncateString(String str, int maxLength) {
    if (str.length() > maxLength) {
        return str.substring(0, maxLength - 3) + "...";
    } else {
        return str;
    }
 }
}
