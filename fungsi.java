import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class fungsi {
    private static char[] alamat;
    private static char[] total;

    public static void pesan() throws Exception {

        Random r = new Random();
        Scanner input = new Scanner(System.in);
        int totalHargaMakanan = 0;
        int totalHargaMinuman = 0;
        int pesanLagi;
        String[] driver = new String[4];
        
        do {
            String pilihPes[] = {"Minuman", "Makanan"};
            int pesan = JOptionPane.showOptionDialog(null, "Silahkan Pilih", "pesan", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, pilihPes, pilihPes);

            if (pesan == 1) {
                int pesanMakanan = 0;
                int hargaMakanan = 0;
                String makanan[] = {"Nasi Campur = 10k", "Nasi Krawu = 10k", "Nasi Boran = 8k", "Selesai"};
                
                do {
                    System.out.print("Pilih : ");
                    pesanMakanan = JOptionPane.showOptionDialog(null, "Pilih Makanan", "Makanan", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, makanan, makanan);
                    
                    if (pesanMakanan == 0) {
                        hargaMakanan = 10;
                    } else if (pesanMakanan == 1) {
                        hargaMakanan = 10;
                    } else if (pesanMakanan == 2) {
                        hargaMakanan = 8;
                    } else if (pesanMakanan == 3) {
                        hargaMakanan = 0;
                    }

                    totalHargaMakanan += hargaMakanan;
                   
                    if (pesanMakanan != 3) {
                        JOptionPane.showMessageDialog(null, "Total Harga : " + (totalHargaMakanan+totalHargaMinuman));
                    }   
                } while (pesanMakanan != 3);
                
                
    
            } else if (pesan == 0) {
                int pesanMinuman = 0;
                int hargaMinuman = 0;
                
                String listMinuman[] = {"kopi = 3k", "Es teh = 5k", "\nTeh hangat = 4k", "Jahe hangat = 4k", "Selesai"};
    
                do {
                    pesanMinuman = JOptionPane.showOptionDialog(null, "Pilih Minuman", "Minuman", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, listMinuman, listMinuman);
    
                    if (pesanMinuman == 0) {
                        hargaMinuman = 3;
                    } else if (pesanMinuman == 1){
                        hargaMinuman = 5;
                    } else if (pesanMinuman == 2) {
                        hargaMinuman = 4;
                    } else if (pesanMinuman == 3) {
                        hargaMinuman = 4;
                    } else if (pesanMinuman == 4) {
                        hargaMinuman = 0;
                    }

                    totalHargaMinuman += hargaMinuman;
    
                    if (pesanMinuman != 4) {
                        JOptionPane.showMessageDialog(null, "Total Harga : " +(totalHargaMinuman+totalHargaMakanan), "Total", JOptionPane.DEFAULT_OPTION);
                    }
                } while (pesanMinuman != 4);
            }
            String pilihLagi[] = {"Ya", "Tidak"};
            pesanLagi = JOptionPane.showOptionDialog(null, "Apakah anda ingin pesan lagi?", "Pilih", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, pilihLagi, pilihLagi);
        } while (pesanLagi == 0);

        int total = totalHargaMakanan + totalHargaMinuman;
        JOptionPane.showMessageDialog(null, "Total pesanan anda = " + total, "Total", JOptionPane.DEFAULT_OPTION);

        Object nama = JOptionPane.showInputDialog("Silahkan masukkan nama anda");
        Object alamat = JOptionPane.showInputDialog("Silahkan masukkan alamat anda");
        
        JOptionPane.showMessageDialog(null, "Sedang mencari driver", "Driver", JOptionPane.DEFAULT_OPTION);
        driver[0] = "Achmad Subagio";
        driver[1] = "Rachmad Munir";
        driver[2] = "Endang";
        driver[3] = "Ginaya";
        
        animasiLoading();

        int pilihDriver = r.nextInt(3);
        String fixDriver = "";
        if (pilihDriver == 0){
            fixDriver = driver[0];
        } else if (pilihDriver == 1) {
            fixDriver = driver[1];
        } else if (pilihDriver == 2) {
            fixDriver = driver[2];
        } else if (pilihDriver == 3) {
            fixDriver = driver[3];
        }

        JOptionPane.showMessageDialog(null, "Driver di temukan bernama \n" + fixDriver, "Driver", JOptionPane.DEFAULT_OPTION);
        JOptionPane.showMessageDialog(null, "Pesanan anda siap untuk diantar", "Antar Pesanan", JOptionPane.DEFAULT_OPTION);
        PrintWriter fileWriter = new PrintWriter("riwayatpesanan.txt");
        
        fileWriter.println("Atas nama : " + nama);
        fileWriter.println("Dikirim Ke : " + alamat);
        fileWriter.println("Driver : " + fixDriver);
        fileWriter.println("Total pesanan = " + total);
        fileWriter.close();
        
        String kembalikeHalaman[] = {"Halaman Utama", "Exit"};
        int pilihHalaman;
        pilihHalaman = JOptionPane.showOptionDialog(null, "Apakah anda ingin kembali ke halaman utama? ", "Pilih", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, kembalikeHalaman, kembalikeHalaman);
        if (pilihHalaman == 0) {
            Main.halamanUtama();
        } else if (pilihHalaman == 1) {
            Main.keluar();
        }

        Main.keluar();

        

    }

    public static void animasiLoading() throws Exception {
        int repeats = 5;
		int steps_per_second = 10;

		for ( int i=0; i<repeats*11 ; i++ )
		{
			if ( i%11 == 0 )
				System.out.print(" .oOo..... \r");
			else if ( i%11 == 1 )
				System.out.print(" ..oOo.... \r");
			else if ( i%11 == 2 )
				System.out.print(" ...oOo... \r");
			else if ( i%11 == 3 )
				System.out.print(" ....oOo.. \r");
			else if ( i%11 == 4 )
				System.out.print(" .....oOo. \r");
			else if ( i%11 == 5 )
				System.out.print(" ......oOo \r");
			else if ( i%11 == 6 )
				System.out.print(" .......oO \r");
			else if ( i%11 == 7 )
				System.out.print(" o.......o \r");
			else if ( i%11 == 8 )
				System.out.print(" Oo....... \r");
			else if ( i%11 == 9 )
				System.out.print(" oOo...... \r");
			else if ( i%11 == 10 )
				System.out.print(" .oOo..... \r");

			Thread.sleep(1000/steps_per_second);
		}
        
    }

}