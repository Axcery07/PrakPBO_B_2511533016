package Pekan_4;
	
import java.util.ArrayList;

public class Rekening {
	// Bagian atas dari class Rekening.java
	private String nomorRekening;
	private String namaPemilik;
	private String pin; // data sensitif
	
	// Gunakan prptected agar Subclass bisa mengaksesnya langsung
	protected double saldo;
	protected ArrayList<Transaksi>riwayatTransaksi;
	
	// Isi konstruktor dan methode lainnya TETAP SAMA seperti Modul 3
	
	// 2. Modifikasi Constructor untuk menerima PIN awal	
	public Rekening(String nomor, String nama, double saldoAwal, String pinAwal) {
		this.nomorRekening = nomor;
		this.namaPemilik = nama;
		this.setSaldo(saldoAwal);
		
		// Validasi PIN di dalam constructor
		if (pinAwal.length() == 6) {
			this.pin = pinAwal;
		} else {
			System.out.println("Peringatan : PIN harus 6 digit! Menggunakan PIN default 123456");
			this.pin = "123456";
		}
	}
		
		// 3. Getter untuk atribut yang diizinkan dibaca publik 
		public String getNomorRekening() {
			return nomorRekening;
		}
		
		public String getNamaPemilik() {
			return namaPemilik;
		}
		
		// 4. Method Otentikasi Internal (Validasi Enkapsulasi()
		public boolean otentikasi(String inputPin) {
			return this.pin.equals(inputPin);
		}
		
		{
		// Wajib mwnginisialisasi ArrayList di dalam constructor agar tidak NullPointerException
		this.riwayatTransaksi = new ArrayList<>();
		}
	public void setorTunai(double nominal) {
		if (nominal > 0){
			setSaldo(getSaldo() + nominal);
			// Merekam riwayat (pembuatan objek Transaksi di dalam method)
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + getSaldo());
		} else {
			System.out.println("Gagal : Nominal setor harus lebih dari 0!");
		}
	}
		
	public void tarikTunai(double nominal) {
		if (nominal >= 10000 && nominal <= getSaldo()) {
			setSaldo(getSaldo() - nominal);
			String idTrx = "TRX-T-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Debit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("Tarik tunai Rp " + nominal + " berhasil. Saldo saat ini : Rp" + getSaldo());
		} else {
			System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: Rp" + getSaldo());
		} 
	}
		
	public boolean cocokDenganNomor(String nomor) {
		if (this.nomorRekening.equals(nomor)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void cetakMutasi() {
	    if (riwayatTransaksi.isEmpty()) {
	        System.out.println("Belum ada transaksi pada rekening ini");
	    } else {
	        for (Transaksi trx : riwayatTransaksi) {
	            trx.cetakDetail();
	        }
	    }
	}
		
	public void cekInformasi() {
		System.out.println("--- INFO REKENING ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir  : " + getSaldo());
		System.out.println("----------------------");
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
