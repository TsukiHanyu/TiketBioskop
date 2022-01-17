package tiketbioskop;

import java.util.Date;
import java.util.Scanner;

public class TiketBioskop {

 private static Scanner input = new Scanner(System.in);
 private static DataCustomer[] pembeliEntity = new DataCustomer[100];
 private static AdminBioskop[] adminEntity = new AdminBioskop[100];
 private static DataCustomerFix[] terinputEntity = new DataCustomerFix[100];
 private static int pilKelas;
 private static int jumCustomer = 0;
 private static int cekAdmin;
 
    public static void main(String[]args){
     dataAdmin();
     int pil;
     do{
        System.out.println("Julah Customer : "+jumCustomer);
           System.out.println("1. Login Admin");
           System.out.println("2. Lihat Data Tiket");
           System.out.println("3. Biodata Admin");
           System.out.println("0. Log Out");
           System.out.print("Pilih Menu : ");
           pil = input.nextInt();
           switch (pil){
               case 1:
                   loginAdmin();
                   break;
               case 2:
                   cetaktiket();
                   break;
               case 3:
                   viewAdmin();
                    break;
           }
     }while (pil !=0);
 }
 static int dataAdmin(){
     String namaAdmin[] = {"Rafi", "Risqi", "Ilham", "Bagas", "Rahmad",};
     String passAdmin[] = {"001", "002", "003", "004", "005"};
     String idAdmin[] = {"01", "02", "03", "04", "05"};
     String shiftAdmin[] = {"Pagi", "Siang", "Siang", "Pagi", "Siang"};
     for (int i = 0; i < namaAdmin.length; i++){
         adminEntity[i] = new AdminBioskop(passAdmin[i], namaAdmin[i], idAdmin[i], shiftAdmin[i]);
     }
     return namaAdmin.length;
 }
 
    static void loginAdmin(){
        System.out.print("Nama : ");
        String nama = input.next();
        System.out.print("Password : ");
        String password = input.next();
        System.out.print("Id : ");
        String id = input.next();
        System.out.print("Shift : ");
        String shift = input.next();
        cekAdmin = login(nama, password, id, shift);
        System.out.println("Selamat Datang " + adminEntity[cekAdmin].getNama());
        int pil;
        do{
            System.out.println("Jumlah Customer : " + jumCustomer);
            System.out.println("1. Input Data Tiket ");
            System.out.println("2. Ubah Data Tiket ");
            System.out.println("3. Cetak Tiket ");
            System.out.println("4. Hapus Data Customer ");
            System.out.println("0. Log Out");
            System.out.print("Pilih Menu : ");
            pil = input.nextInt();
            switch (pil){
                case 1:
                    insertTiket();
                    break;
                case 2:
                    updateTiket();    
                    break;
                case 3:
                    cetaktiket();
                    break;
                case 4:
                    deleteTiket();
                    break;
            }
        }while (pil !=0);
    }
    static int login(String nama, String password, String id, String shift){
        int loop = 0;
        for (int i = 0; i <= dataAdmin(); i++){
        if (adminEntity[i].getNama().equals(nama) && adminEntity[i].getPassword().equals(password)
            && adminEntity[i].getId().equals(id)){
            break;
        }else{
            loop++;
        }
    }
        return loop;
    }
    static void insertTiket(){
        System.out.print("Nama Customer : ");
        String namaCustomer = input.next();
        System.out.print("Jumlah Tiket  : ");
        String jumlah = input.next();
        System.out.print("Jam Tayang    : ");
        String jamTayang = input.next();
        System.out.print("Nama Film     : ");
        String film = input.next();
        
       pembeliEntity[jumCustomer] = new DataCustomer(jumlah, namaCustomer, film, jamTayang);
       insertKelas();
    }
    static void insertKelas(){
        System.out.println("Pilih Kelas : ");
        for (int i = 0; i < KelasBioskop.kelas.length; i++){
            System.out.println(i + ". " + KelasBioskop.kelas[i]);
        }
        System.out.print("Pilih Kelas : ");
        pilKelas = input.nextInt();
        System.out.print("Masukan Kode Tiket : ");
        String kodePendaftar = input.next();
        terinputEntity[jumCustomer] = new DataCustomerFix(pembeliEntity[jumCustomer], pilKelas,
        kodePendaftar);
        jumCustomer = jumCustomer + 1;
    }
    static void updateTiket(){
        System.out.print("Masukan Kode Tiket yang di Rubah : ");
        String search = input.next();
        int cari = 0;
        do{
            if (cari == jumCustomer){
                System.out.println("Tidak Ada Data");
                break;
            }else if (terinputEntity[cari].getKodePendaftar().equals(search)){
                int pilEdit;
                do{
                  System.out.println("Pilih Data Yang ingin Diubah : ");
                  System.out.println("1. Lihat Data : ");
                  System.out.println("2. Nama Customer");
                  System.out.println("3. Jumlah Tiket");
                  System.out.println("4. Jam Tayang");
                  System.out.println("5. Nama Film");
                  System.out.println("6. Jenis Kelas");
                  System.out.println("0. Exit");
                  pilEdit = input.nextInt();
                  input.nextLine();
                  if (pilEdit == 1){
                      System.out.println("===================================");
                      System.out.println("Kode Tiket : " + terinputEntity[cari].getKodePendaftar());
                      System.out.println("===================================");
                      System.out.println("Nama Customer : " + pembeliEntity[cari].getNama()
                              + "\n Jumlah Tiket : " + pembeliEntity[cari].getJumlah()
                              + "\n Jam Tayang : " + pembeliEntity[cari].jamTayang()
                              + "\n Nama Film : " + pembeliEntity[cari].film()
                              + "\n jenia kelas : " + KelasBioskop.kelas[terinputEntity[cari].getIndexKelas()]);
                      System.out.println("===================================");
                  }else if (pilEdit == 2){
                 System.out.print("Ubah Nama Customer   : ");
                      String editNama = input.nextLine();
                      pembeliEntity[cari].setNamaCustomer(editNama);
                  }else if (pilEdit == 3){
                      System.out.print("Ubah Jumlah Tiket   : ");
                      String editAlamat = input.nextLine();
                      pembeliEntity[cari].setJumlah(editAlamat);
                  }else if (pilEdit == 4){
                      System.out.print("Ubah jam Tayang : ");
                      String editNoTelp = input.nextLine();
                      pembeliEntity[cari].setJamtayang(editNoTelp);
                  }else if (pilEdit == 5){
                      System.out.print("Ubah Nama Film  : ");
                      String editUmur = input.nextLine();
                      pembeliEntity[cari].setFilm(editUmur);
                  }else if (pilEdit == 6){
                      System.out.println("Pilih Kelas");
                      for (int i = 0; i < KelasBioskop.kelas.length; i++){
                          System.out.println(i+1 + ". " + KelasBioskop.kelas[i]);
                      }
                          int editKelas = input.nextInt();
                          terinputEntity[cari].setIndexKelas(editKelas);
                      }
                  }while (pilEdit !=0);
                break;
            }else{
                cari = cari +1;
            }
        }while (true);
    }
    static void cetaktiket(){
        if (jumCustomer == 0){
            System.out.println("Belum Ada Data Tiket");
        }else{
            for (int i = 0; i < jumCustomer; i++){
                System.out.println("=========================================");
                System.out.println("kode Tiket : " + terinputEntity[i].getKodePendaftar());
                System.out.println("=========================================");
                System.out.println("Nama Customer   : " + pembeliEntity[i].getNama()
                        + "\n Jumlah Tiket  : " + pembeliEntity[i].getJumlah()
                        + "\n Jam Tayang    : " + pembeliEntity[i].getJaTayang()
                        + "\n Nama Film : " + pembeliEntity[i].getfilm()
                        + "\n Jenis Kelas: " + KelasBioskop.kelas[terinputEntity[i].getIndexKelas()]);
                System.out.println("=========================================");
            }
        }
    }
    static void viewAdmin(){
        for (int i = 0; i < dataAdmin(); i++){
            System.out.println("=============================================");
            System.out.println("Nama : " + adminEntity[i].getNama()
                    + "\n No. Telp : " + adminEntity[i].getId()
                    + "\n Alamat : " + adminEntity[i].getShift());
            System.out.println("=============================================");
        }
    }
     static void deleteTiket(){
        System.out.print("Masukan Kode Tiket yang Akan di HAPUS : ");
        String search = input.next();
        input.nextLine();
        int cari = 0;
        do{
            if (cari == jumCustomer){
                System.out.println("Tidak Ada Data!");
                break;
            }else if (terinputEntity[cari].getKodePendaftar().equals(search)){
                if (cari == jumCustomer - 1){
                    jumCustomer = jumCustomer - 1;
                }else{
                    for (int i = cari; i < jumCustomer; i++){
                        terinputEntity[i] = terinputEntity[i + 1];
                        pembeliEntity[i] = pembeliEntity[i + 1];
                    }
                    jumCustomer = jumCustomer - 1;
                }
                break;
            }else{
                cari = cari + 1;
            }
        }while (true);
    }
}