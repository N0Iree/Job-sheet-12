import java.util.Scanner;

public class TabungKerucut01 {

    static double luasLingkaran(double r) {
        return Math.PI * r * r;
    }

    static double volumeTabung(double r, double t) {
        return luasLingkaran(r) * t;
    }

    static double luasPermukaanTabung(double r, double t) {
        double luasAlas = luasLingkaran(r);
        double luasSelimut = 2 * Math.PI * r * t;
        return (2 * luasAlas) + luasSelimut;
    }

    static double volumeKerucut(double r, double t) {
        return volumeTabung(r, t) / 3.0;
    }

    static void tampilkanMenu() {
        System.out.println("\n=== MENU BANGUN RUANG (TABUNG & KERUCUT) ===");
        System.out.println("1. Hitung Luas Lingkaran");
        System.out.println("2. Hitung Volume Tabung");
        System.out.println("3. Hitung Luas Permukaan Tabung");
        System.out.println("4. Hitung Volume Kerucut");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r1 = sc.nextDouble();
                    System.out.printf("Luas Lingkaran = %.2f%n", luasLingkaran(r1));
                    break;

                case 2:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r2 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t2 = sc.nextDouble();
                    System.out.printf("Volume Tabung = %.2f%n", volumeTabung(r2, t2));
                    break;

                case 3:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r3 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t3 = sc.nextDouble();
                    System.out.printf("Luas Permukaan Tabung = %.2f%n", luasPermukaanTabung(r3, t3));
                    break;

                case 4:
                    System.out.print("Masukkan jari-jari (r): ");
                    double r4 = sc.nextDouble();
                    System.out.print("Masukkan tinggi (t): ");
                    double t4 = sc.nextDouble();
                    System.out.printf("Volume Kerucut = %.2f%n", volumeKerucut(r4, t4));
                    break;

                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}