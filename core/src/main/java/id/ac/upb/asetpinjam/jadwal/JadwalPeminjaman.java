package id.ac.upb.asetpinjam.jadwal;

import id.ac.upb.asetpinjam.model.Peminjaman;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Jadwal peminjaman di memori.
 *
 * <p>Minggu 7: bentrok, semuaUrutMulai, perAset, hapus. Minggu 9: ajukan (melempar exception).
 * tambah() DISEDIAKAN dan sengaja TIDAK memeriksa apa pun.
 */
public class JadwalPeminjaman {

    private final List<Peminjaman> daftar = new ArrayList<>();
    private final int kuotaLaptop;

    public JadwalPeminjaman(int kuotaLaptop) {
        this.kuotaLaptop = kuotaLaptop;
    }

    protected int kuotaLaptop() {
        return kuotaLaptop;
    }

    protected List<Peminjaman> daftarMutable() {
        return daftar;
    }

    /** Menambah apa adanya tanpa pemeriksaan. */
    public void tambah(Peminjaman p) {
        daftar.add(p);
    }

    /**
     * TODO minggu 7: true jika {@code baru} bentrok dengan peminjaman yang sudah ada untuk ASET YANG SAMA.
     * Definisi "bentrok" di batas waktu (selesai sama dengan mulai) adalah KEPUTUSAN ANDA (docs/asumsi.md).
     */
    public boolean bentrok(Peminjaman baru) {
        throw new UnsupportedOperationException("TODO minggu 7: bentrok");
    }

    /** TODO minggu 7: semua peminjaman, diurutkan menurut waktu mulai (gunakan Comparator). */
    public List<Peminjaman> semuaUrutMulai() {
        throw new UnsupportedOperationException("TODO minggu 7: semuaUrutMulai");
    }

    /** TODO minggu 7: peminjaman dikelompokkan menurut kode aset. */
    public Map<String, List<Peminjaman>> perAset() {
        throw new UnsupportedOperationException("TODO minggu 7: perAset");
    }

    /** TODO minggu 7: hapus peminjaman berdasarkan id. True jika ada yang terhapus. */
    public boolean hapus(String id) {
        throw new UnsupportedOperationException("TODO minggu 7: hapus");
    }

    /**
     * TODO minggu 9: periksa lalu tambahkan.
     * Bentrok: PeminjamanBentrokException. Peminjam sudah memegang {@link #kuotaLaptop()} laptop yang
     * aktif (status DISETUJUI atau DIPINJAM) dan mengajukan laptop lagi: KuotaHabisException.
     */
    public void ajukan(Peminjaman baru) {
        throw new UnsupportedOperationException("TODO minggu 9: ajukan");
    }
}
