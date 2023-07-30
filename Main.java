import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static String[] dataUser = new String[10];
    private static String[] dataPass = new String[10];
    private static int[] hargaMakanan = new int[3];
    private static int[] hargaMinuman = new int[3];
    
    
    public static void main(String[] args) throws Exception {
        Scanner filereader = new Scanner(new File("riwayatpesanan.txt"));
        String touch[] = {"Buatakun", "login"};
        int pilih ;
        JOptionPane.showMessageDialog(null, "WELCOME TO MYwarkoP", "Selamat Datang",JOptionPane.DEFAULT_OPTION);
        pilih = JOptionPane.showOptionDialog(null, "Menu : \nSilahkan Pilih", "Welcome", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, touch, touch[0]);
        
        if (pilih == 0) {
            BuatAkunn();
        } else if (pilih == 1) {
            Login();
        } 
        halamanUtama();
        
    }

    public static void halamanUtama() throws Exception{
        String menu[] ={"1. pesan", "2. Cek Saldo", "3 Riwayat Tarnsaksi", "Exit"};
        int pilihMenu;
        pilihMenu = JOptionPane.showOptionDialog(null, "Menu Mywarkop", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu, menu);

        if (pilihMenu == 0) {
            fungsi.pesan();
        } else if (pilihMenu == 1) {
            CekSaldo();
        } else if (pilihMenu== 2) {
            RiwayatTransaksi();
        } else if (pilihMenu == 3) {
            keluar();
        }
    }

    public static void BuatAkunn() {

        System.out.print("Masukkan Username yang akan anda buat : ");
        String username = JOptionPane.showInputDialog("Masukkan username yang anda buat");
        username = dataUser[1];
        
        String pass2 = "";
        String password = "";
        do {
            password = JOptionPane.showInputDialog("Masukkan password yang anda buat");
            pass2 = password;
    
            password = JOptionPane.showInputDialog("Ketikkan Password kemabali");

            if (!password.equals(pass2)) {
                System.out.println("Password yang anda masukkan tidak sesuai");
                System.out.println("Silahkan masukkan kembali");
            }
        } while (!password.equals(pass2));
        
    }

    public static void Login() {
        dataUser[0] = "mabidm";
        dataPass[0] = "mabid1234";
        String username = "";
        String password = "";

        do {
            username = JOptionPane.showInputDialog(null, "Masukkan Username");
            password = JOptionPane.showInputDialog(null, "Masukkan Paswrod");
         
            if (!username.equalsIgnoreCase(dataUser[0]) && !password.equalsIgnoreCase(dataPass[0])){
                JOptionPane.showMessageDialog(null, "Username atau Password yang anda masukkan salah", "Warning", JOptionPane.ERROR_MESSAGE);
            }
            
        } while (!username.equals(dataUser[0]) && !password.equals(dataPass[0]));
    }

    public static void CekSaldo() throws Exception {
        int saldoUtama = 0;
        String inputSaldo = "";
        int cek ;
        String pilihLan[] = {"Ya", "Tidak"};

        do {
            JOptionPane.showMessageDialog(null, "Cek saldo \nMyPAY \nSaldo Anda " + saldoUtama, "MyPAY", JOptionPane.DEFAULT_OPTION);
            
            String pilih[] = {"1. Iya", "2. Tidak"};
            int pilihPay;
            pilihPay = JOptionPane.showOptionDialog(null, "Apakah anda ingin menambahkan Saldo?", "MyPAY", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, pilih, pilih[0]);
      
            if (pilihPay == 0) {
                String pilihh[] = {"Bank Bank", "Bank Mandiri", "Bank BNI"};
                int pilihBank;
                pilihBank = JOptionPane.showOptionDialog(null, "Pilih Bank", "BANK ", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, pilihh, pilihh);
                int biayaAdmin = 0;
                if (pilihBank == 0 || pilihBank == 1) {
                    JOptionPane.showMessageDialog(null, "Tambahan Biaya Admin 5000", "BCA % Mandiri", JOptionPane.DEFAULT_OPTION);
                    biayaAdmin = 5000;
                } else if (pilihBank == 2) {
                    JOptionPane.showMessageDialog(null, "Tambahan Biaya Admin 6000", "BNI", JOptionPane.DEFAULT_OPTION);
                    biayaAdmin = 6000;
                }
                int inpsaldo;
                inputSaldo = (String) JOptionPane.showInputDialog(null, "Masukkan Nominal : ",JOptionPane.DEFAULT_OPTION);
                inpsaldo = Integer.parseInt(inputSaldo);
                fungsi.animasiLoading();
    
                saldoUtama = inpsaldo - biayaAdmin; 
            }
            
            cek = JOptionPane.showOptionDialog(null, "Apakah ingin Cek Saldo?", "Pilih Opsi", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, pilihLan, pilihLan);

        } while (cek == 0);
        halamanUtama();
    }
    public static void keluar(){
        JOptionPane.showMessageDialog(null, "Terimakasih telah mengunjungi Toko kami", "Thank you", JOptionPane.DEFAULT_OPTION);
    }

    public static void RiwayatTransaksi() throws Exception {
        Scanner fileReader = new Scanner(new File("riwayatpesanan.txt"));
        String nama = fileReader.nextLine();
        String alamat = fileReader.nextLine();
        String fixdriver = fileReader.nextLine();
        String total = fileReader.nextLine();

        JOptionPane.showMessageDialog(null, nama + "\n" + alamat + "\n" + fixdriver + "\n" + total);
        String kembalikeHalaman[] = {"Halaman Utama", "Exit"};
        int pilihHalaman;
        pilihHalaman = JOptionPane.showOptionDialog(null, "Apakah anda ingin kembali ke halaman utama? ", "Pilih", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, kembalikeHalaman, kembalikeHalaman);
        if (pilihHalaman == 0) {
            Main.halamanUtama();
        } else if (pilihHalaman == 1) {
            Main.keluar();
        }

    }

    
}