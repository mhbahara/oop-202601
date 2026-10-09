package id.ac.upb.asetpinjam.dao;

import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.StatusPeminjaman;
import java.util.Optional;

/** DISEDIAKAN dosen (minggu 11). */
public interface PeminjamanDAO {

    /** Menyimpan peminjaman baru. Peminjam dan aset harus sudah ada di database. */
    void simpan(Peminjaman peminjaman);

    Optional<Peminjaman> cariById(String id);

    /** False jika id tidak ditemukan. */
    boolean perbaruiStatus(String id, StatusPeminjaman status);
}
