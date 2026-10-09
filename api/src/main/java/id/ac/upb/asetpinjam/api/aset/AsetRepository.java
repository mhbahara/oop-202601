package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.model.Aset;
import java.util.List;
import java.util.Optional;

/** DISEDIAKAN dosen. Kontrak penyimpanan aset untuk lapisan API. Minggu 14: tulis implementasi JDBC. */
public interface AsetRepository {

    void simpan(Aset aset);

    Optional<Aset> cariByKode(String kode);

    List<Aset> semua();

    /** True jika ada yang terhapus. */
    boolean hapus(String kode);
}
