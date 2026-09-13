package Pekan_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rekening akunAktif = null; // Objek belum diinstalisasi(null)
		boolean isRunning = true;
		
		ArrayList<Rekening> rekeningAktif = new ArrayList<>();
		
		System.out.println("=== SISTEN PERBANKAN MINI ===");
		
		while (isRunning) {
			System.out.println("\nMenu Utama : ");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik Tunai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.printf("Pilih Menu : ");
			
			int pilihan = input.nextInt();
			input.nextLine(); // Membersihkan buffer enter
			
			switch (pilihan) {
			case 1 : 
				System.out.print("Masukkan No Rekening: ");
				String no = input.nextLine();
				System.out.print("Masukkan Nama Pemilik : ");
				String nama = input.nextLine();
				System.out.print("Masukkan Saldo Awal : ");
				double saldo = input.nextDouble();
					
				// Instansiasi Objek / Menjalankan Constructor
				akunAktif = new Rekening(no, nama, saldo);
				
				rekeningAktif.add(akunAktif);
				System.out.println("Rekening berhasil ditambahkan dan ditumpuk. Total rekening: " + rekeningAktif.size());

				break;
			
			case 2 : 
				if (akunAktif == null) {
					System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
				} else { 
					System.out.print("Masukkan nominal setor : ");
					double setor = input.nextDouble();
			 		akunAktif.setorTunai(setor); // Memanggil Behavior / method
				}
				break;
				
			case 3 : 
				if (akunAktif.saldo < 10000) {
					System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: Rp" + akunAktif.saldo);
				} else {
					System.out.print("Masukkan nominal tarik : ");
					double tarik = input.nextDouble();
					akunAktif.tarikTunai(tarik);
				}
				break;
				
			case 4 : 
				if (akunAktif == null) {
					System.out.println("Error : Anda belum membuka rekening!");
				} else {
					akunAktif.cekInformasi();
				}
				break;
			
			case 5 :
			    if (rekeningAktif.isEmpty()) {
			        System.out.println("Belum ada rekening yang terdaftar!");
			    } else {
			        System.out.print("Masukkan nomor rekening yang ingin diaktifkan : ");
			        String cariNomor = input.nextLine();
			        boolean ditemukan = false;
			        for (Rekening rA : rekeningAktif) {
			            if (rA.cocokDenganNomor(cariNomor)) {
			                akunAktif = rA;
			                ditemukan = true;
			                System.out.println("Berhasil! Akun aktif sekarang atas nama " + rA.namaPemilik
			                        + " (No. Rekening: " + rA.nomorRekening + ")");
			                break;
			            }
			        }
			        if (!ditemukan) {
			            System.out.println("Gagal: Nomor rekening " + cariNomor + " tidak ditemukan.");
			        }
			    }
			    break;
				
			case 0 : 
				isRunning = false;
				System.out.println("Sistem ditutup. Terima Kasih!");
				break;
				
			default:
				System.out.println("Pilihan tidak valid!");
			}
		}
		input.close();
	}
}
