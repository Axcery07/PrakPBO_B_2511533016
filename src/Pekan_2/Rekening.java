package Pekan_2;
	
import java.util.ArrayList;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
		
	// Implementasi Asosiasi (1-to-many)
	ArrayList<Transaksi>riwayatTransaksi;
	
	public Rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat dengan saldo Rp " + saldo);
		
		// Wajib mwnginisialisasi ArrayList di dalam constructor agar tidak NullPointerException
		this.riwayatTransaksi = new ArrayList<>();
	}
		
	public void setorTunai(double nominal) {
		if (nominal > 0){
			saldo += nominal;
			// Merekam riwayat (pembuatan objek Transaksi di dalam method)
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		} else {
			System.out.println("Gagal : Nominal setor harus lebih dari 0!");
		}
	}
		
	public void tarikTunai(double nominal) {
		if (nominal <= 10000 && nominal <= saldo) {
			saldo -= nominal;
			String idTrx = "TRX-T-" + System.currentTimeMillis();
			Transaksi trxBaru = new Transaksi(idTrx, "Debit", nominal);
			riwayatTransaksi.add(trxBaru);
			System.out.println("Tarik tunai Rp " + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		} else {
			System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: Rp" + saldo);
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
		System.out.println("Saldo Akhir  : " + saldo);
		System.out.println("----------------------");
	}
	
}
