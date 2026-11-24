import java.util.Scanner;

public class RekapLaundry01 {

    static void inputDataBerat(Scanner input, int[][] data, String[] namaLayanan, String[] namaHari) {
        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.println("Input berat cucian untuk layanan " + namaLayanan[i] + ":");
            for (int j = 0; j < namaHari.length; j++) {
                System.out.print("  " + namaHari[j] + " (kg): ");
                data[i][j] = input.nextInt();
            }
        }
    }

    static void tampilTabelData(int[][] data, String[] namaLayanan, int[] hargaPerKg, String[] namaHari) {
        System.out.println("\n=== TABEL REKAP BERAT CUCIAN (KG) ===");
        System.out.printf("%-16s %-11s", "Layanan", "Harga/kg");
        for (String hari : namaHari) {
            System.out.printf("%-8s", hari);
        }
        System.out.println();

        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.printf("%-16s Rp%-9d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < namaHari.length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] namaLayanan) {
        int idxTerbesar = 0;
        int beratTerbesar = totalPerLayanan(data, 0);

        for (int i = 1; i < namaLayanan.length; i++) {
            int totalLayanan = totalPerLayanan(data, i);
            if (totalLayanan > beratTerbesar) {
                beratTerbesar = totalLayanan;
                idxTerbesar = i;
            }
        }

        System.out.println("\nLayanan dengan total berat tertinggi: "
                + namaLayanan[idxTerbesar] + " (" + beratTerbesar + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int jumlahHari = data[0].length;
        int idxHariTerbesar = 0;
        int beratHariTerbesar = 0;

        for (int i = 0; i < data.length; i++) {
            beratHariTerbesar += data[i][0];
        }

        for (int j = 1; j < jumlahHari; j++) {
            int totalHari = 0;
            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }
            if (totalHari > beratHariTerbesar) {
                beratHariTerbesar = totalHari;
                idxHariTerbesar = j;
            }
        }

        return idxHariTerbesar;
    }

    static void tampilPendapatan(int[][] data, String[] namaLayanan, int[] hargaPerKg) {
        System.out.println("\n=== PENDAPATAN PER LAYANAN ===");
        long totalPendapatan = 0;

        for (int i = 0; i < namaLayanan.length; i++) {
            int totalBerat = totalPerLayanan(data, i);
            long pendapatan = (long) totalBerat * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-16s : %d kg x Rp%d = Rp%d%n",
                    namaLayanan[i], totalBerat, hargaPerKg[i], pendapatan);
        }

        System.out.println("Total pendapatan selama 6 hari: Rp" + totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] namaLayanan = { "Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express" };
        int[] hargaPerKg = { 6000, 8000, 5000, 12000 };
        String[] namaHari = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };
        int[][] dataCucian = new int[namaLayanan.length][namaHari.length];

        inputDataBerat(input, dataCucian, namaLayanan, namaHari);
        tampilTabelData(dataCucian, namaLayanan, hargaPerKg, namaHari);

        System.out.println("\n=== TOTAL BERAT PER LAYANAN (6 HARI) ===");
        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.println(namaLayanan[i] + ": " + totalPerLayanan(dataCucian, i) + " kg");
        }

        tampilLayananTertinggi(dataCucian, namaLayanan);

        int idxHariSibuk = hariTersibuk(dataCucian);
        System.out.println("Hari tersibuk: " + namaHari[idxHariSibuk]);

        tampilPendapatan(dataCucian, namaLayanan, hargaPerKg);

        input.close();
    }
}