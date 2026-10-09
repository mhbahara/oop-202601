package id.ac.upb.asetpinjam.dao;

import id.ac.upb.asetpinjam.model.Aset;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Minggu 11: implementasi JDBC. WAJIB PreparedStatement (tidak boleh menggabung string SQL dengan input),
 * try-with-resources, dan SQLException dibungkus DataAksesException.
 * Pembuatan objek dari baris database gunakan AsetFactory (minggu 10).
 */
public class JdbcAsetDAO implements AsetDAO {

    private final Supplier<Connection> sumberKoneksi;

    public JdbcAsetDAO(Supplier<Connection> sumberKoneksi) {
        this.sumberKoneksi = sumberKoneksi;
    }

    @Override
    public void simpan(Aset aset) {
        throw new UnsupportedOperationException("TODO minggu 11: simpan");
    }

    @Override
    public Optional<Aset> cariByKode(String kode) {
        throw new UnsupportedOperationException("TODO minggu 11: cariByKode");
    }

    @Override
    public List<Aset> semua() {
        throw new UnsupportedOperationException("TODO minggu 11: semua");
    }

    @Override
    public void perbarui(Aset aset) {
        throw new UnsupportedOperationException("TODO minggu 11: perbarui");
    }

    @Override
    public boolean hapus(String kode) {
        throw new UnsupportedOperationException("TODO minggu 11: hapus");
    }
}
