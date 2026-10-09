package id.ac.upb.asetpinjam.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Parameter aturan yang berbeda untuk tiap mahasiswa, ditentukan dari digit terakhir NIM.
 * Kelas ini DISEDIAKAN dosen. Jangan diubah.
 */
public final class Varian {

    private static final int[] DENDA_PER_HARI = {5000, 7500, 10000, 2500, 6000};
    private static final int[] BATAS_DURASI_JAM = {4, 6, 8, 3, 5};
    private static final int[] KUOTA_LAPTOP = {1, 2, 3, 1, 2};

    private static Varian aktif;

    public final String nim;
    public final String nama;
    /** Tarif dasar denda per hari keterlambatan (rupiah). */
    public final int dendaPerHari;
    /** Batas durasi peminjaman ruang dalam jam (dipakai tes tersembunyi UTS/UAS). */
    public final int batasDurasiJam;
    /** Jumlah laptop yang boleh dipinjam bersamaan oleh satu peminjam. */
    public final int kuotaLaptop;

    private Varian(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        char terakhir = nim.charAt(nim.length() - 1);
        if (!Character.isDigit(terakhir)) {
            throw new IllegalStateException("Digit terakhir NIM harus angka: " + nim);
        }
        int indeks = (terakhir - '0') % 5;
        this.dendaPerHari = DENDA_PER_HARI[indeks];
        this.batasDurasiJam = BATAS_DURASI_JAM[indeks];
        this.kuotaLaptop = KUOTA_LAPTOP[indeks];
    }

    public static Varian dariNim(String nim, String nama) {
        if (nim == null || nim.isBlank() || nama == null || nama.isBlank()) {
            throw new IllegalStateException(
                    "Isi nim dan nama di core/src/main/resources/mahasiswa.properties");
        }
        return new Varian(nim.trim(), nama.trim());
    }

    /** Varian milik mahasiswa yang menjalankan kode ini (dibaca sekali dari mahasiswa.properties). */
    public static synchronized Varian aktif() {
        if (aktif == null) {
            Properties p = new Properties();
            try (InputStream in = Varian.class.getResourceAsStream("/mahasiswa.properties")) {
                if (in == null) {
                    throw new IllegalStateException("mahasiswa.properties tidak ditemukan");
                }
                p.load(in);
            } catch (IOException e) {
                throw new IllegalStateException("Gagal membaca mahasiswa.properties", e);
            }
            aktif = dariNim(p.getProperty("nim"), p.getProperty("nama"));
        }
        return aktif;
    }
}
