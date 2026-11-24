import java.util.Scanner;

public class BankSampah01 {

    static double[] inputSetoran(Scanner input, int jumlahNasabah) {
        double[] daftarSetoran = new double[jumlahNasabah];

        for (int i = 0; i < jumlahNasabah; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            daftarSetoran[i] = input.nextDouble();
        }

        return daftarSetoran;
    }

    static void tampilSetoran(double[] daftarSetoran) {
        System.out.println("\n=== DATA SETORAN SAMPAH ===");
        for (int i = 0; i < daftarSetoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + ": " + daftarSetoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] daftarSetoran) {
        double totalBerat = 0;

        for (double berat : daftarSetoran) {
            totalBerat += berat;
        }

        return totalBerat;
    }

    static double hitungSaldo(double beratSetoran, double hargaPerKg) {
        return beratSetoran * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] daftarSetoran) {
        int indeksTerbesar = 0;

        for (int i = 1; i < daftarSetoran.length; i++) {
            if (daftarSetoran[i] > daftarSetoran[indeksTerbesar]) {
                indeksTerbesar = i;
            }
        }

        return indeksTerbesar;
    }

    private static void tampilSaldoSemuaNasabah(double[] daftarSetoran, double hargaPerKg) {
        System.out.println("\n=== SALDO SETIAP NASABAH (Rp3.000/kg) ===");
        for (int i = 0; i < daftarSetoran.length; i++) {
            double saldo = hitungSaldo(daftarSetoran[i], hargaPerKg);
            System.out.println("Nasabah ke-" + (i + 1) + " -> Saldo: Rp" + saldo);
        }
    }

    public static void main(String[] args) {
        final double HARGA_PER_KG = 3000;
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah nasabah (N): ");
        int jumlahNasabah = input.nextInt();

        double[] daftarSetoran = inputSetoran(input, jumlahNasabah);
        tampilSetoran(daftarSetoran);

        double totalBerat = totalSetoran(daftarSetoran);
        System.out.println("\nTotal berat setoran seluruh nasabah: " + totalBerat + " kg");

        tampilSaldoSemuaNasabah(daftarSetoran, HARGA_PER_KG);

        int indeksTerbanyak = nasabahTerbanyak(daftarSetoran);
        System.out.println("\nSetoran terbanyak dimiliki oleh Nasabah ke-" + (indeksTerbanyak + 1)
                + " (indeks " + indeksTerbanyak + ") dengan berat " + daftarSetoran[indeksTerbanyak] + " kg");

        input.close();
    }
}