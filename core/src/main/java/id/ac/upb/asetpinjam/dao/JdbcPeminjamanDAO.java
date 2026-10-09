package id.ac.upb.asetpinjam.dao;

import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.StatusPeminjaman;
import java.sql.Connection;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Minggu 11. Aturan sama dengan JdbcAsetDAO. Aset dimuat lewat AsetDAO yang diberikan,
 * peminjam dari tabel peminjam (join atau query terpisah, keputusan Anda).
 */
public class JdbcPeminjamanDAO implements PeminjamanDAO {

    private final Supplier<Connection> sumberKoneksi;
    private final AsetDAO asetDao;

    public JdbcPeminjamanDAO(Supplier<Connection> sumberKoneksi, AsetDAO asetDao) {
        this.sumberKoneksi = sumberKoneksi;
        this.asetDao = asetDao;
    }

    @Override
    public void simpan(Peminjaman peminjaman) {
        throw new UnsupportedOperationException("TODO minggu 11: simpan");
    }

    @Override
    public Optional<Peminjaman> cariById(String id) {
        throw new UnsupportedOperationException("TODO minggu 11: cariById");
    }

    @Override
    public boolean perbaruiStatus(String id, StatusPeminjaman status) {
        throw new UnsupportedOperationException("TODO minggu 11: perbaruiStatus");
    }
}
