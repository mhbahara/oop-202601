package id.ac.upb.asetpinjam.api.aset;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Minggu 12: logika aplikasi di antara controller dan repository.
 * Gunakan AsetFactory dari modul core untuk membuat objek aset (jangan membuat sendiri per jenis di sini).
 */
@Service
public class AsetService {

    private final AsetRepository repository;

    public AsetService(AsetRepository repository) {
        this.repository = repository;
    }

    /**
     * TODO minggu 12: buat aset dari permintaan lalu simpan.
     * Minggu 13: kode yang sudah ada melempar AsetSudahAdaException.
     */
    public AsetResponse buat(AsetRequest permintaan) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetService.buat");
    }

    /** TODO minggu 12: tidak ketemu melempar AsetTidakDitemukanException. */
    public AsetResponse cari(String kode) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetService.cari");
    }

    /** TODO minggu 12. */
    public List<AsetResponse> semua() {
        throw new UnsupportedOperationException("TODO minggu 12: AsetService.semua");
    }

    /** TODO minggu 12: tidak ketemu melempar AsetTidakDitemukanException. */
    public void hapus(String kode) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetService.hapus");
    }
}
