package id.ac.upb.asetpinjam.dao;

import id.ac.upb.asetpinjam.model.Aset;
import java.util.List;
import java.util.Optional;

/** DISEDIAKAN dosen (minggu 11). Kontrak akses data aset. */
public interface AsetDAO {

    /** Menyimpan aset baru. Kode yang sudah ada: DataAksesException. */
    void simpan(Aset aset);

    Optional<Aset> cariByKode(String kode);

    List<Aset> semua();

    /** Memperbarui nama, status, dan kondisi aset yang ada. */
    void perbarui(Aset aset);

    /** True jika ada baris yang terhapus. */
    boolean hapus(String kode);
}
