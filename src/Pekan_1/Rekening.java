package Pekan_1;
	
public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
		
	public Rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;
		System.out.println("Rekening atas nama " + namaPemilik + " berhasil dibuat dengan saldo Rp " + saldo);
	}
		
	public void setorTunai(double nominal) {
		if (nominal > 0){
			saldo += nominal;
			System.out.println("Setor tunai Rp" + nominal + " berhasil. Saldo saat ini : Rp" + saldo);
		} else {
			System.out.println("Gagal : Nominal setor harus lebih dari 0!");
		}
	}
		
	public void tarikTunai(double nominal) {
		if (nominal <= 10000 && nominal <= saldo) {
			saldo -= nominal;
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
		
	public void cekInformasi() {
		System.out.println("--- INFO REKENING ---");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir  : " + saldo);
		System.out.println("----------------------");
	}
	
}
