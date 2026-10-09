package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.dao.AsetDAO;
import id.ac.upb.asetpinjam.dao.JdbcAsetDAO;
import id.ac.upb.asetpinjam.dao.JdbcPeminjamanDAO;
import id.ac.upb.asetpinjam.dao.Koneksi;
import id.ac.upb.asetpinjam.dao.PeminjamanDAO;
import id.ac.upb.asetpinjam.exception.DataAksesException;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Kondisi;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Peminjam;
import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.Ruang;
import id.ac.upb.asetpinjam.model.StatusAset;
import id.ac.upb.asetpinjam.model.StatusPeminjaman;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

/** Perlu database: jalankan docker compose up -d dan atur DB_URL, DB_USER, DB_PASSWORD (lihat .env.example). */
@Tag("week11")
@EnabledIfEnvironmentVariable(named = "DB_URL", matches = ".+")
class Minggu11DaoTest {

    private AsetDAO asetDao;
    private PeminjamanDAO peminjamanDao;

    @BeforeEach
    void bersihkan() throws SQLException {
        try (Connection c = Koneksi.baru(); Statement s = c.createStatement()) {
            s.executeUpdate("DELETE FROM peminjaman");
            s.executeUpdate("DELETE FROM aset");
        }
        asetDao = new JdbcAsetDAO(Koneksi::baru);
        peminjamanDao = new JdbcPeminjamanDAO(Koneksi::baru, asetDao);
    }

    @Test
    void simpanLaluCariRuang() {
        asetDao.simpan(new Ruang("R-1", "Aula", 80));
        Aset hasil = asetDao.cariByKode("R-1").orElseThrow();
        assertThat(hasil).isInstanceOf(Ruang.class);
        assertThat(hasil.getNama()).isEqualTo("Aula");
        assertThat(((Ruang) hasil).getKapasitas()).isEqualTo(80);
    }

    @Test
    void simpanLaluCariLaptop() {
        asetDao.simpan(new Laptop("L-1", "Laptop A", "i5/16GB", "INV-1"));
        Laptop hasil = (Laptop) asetDao.cariByKode("L-1").orElseThrow();
        assertThat(hasil.getSpesifikasi()).isEqualTo("i5/16GB");
        assertThat(hasil.getNomorInventaris()).isEqualTo("INV-1");
    }

    @Test
    void kodeTidakAdaMengembalikanKosong() {
        assertThat(asetDao.cariByKode("TIDAK-ADA")).isEmpty();
    }

    @Test
    void semuaMengembalikanSemuaAset() {
        asetDao.simpan(new Ruang("R-1", "Aula", 80));
        asetDao.simpan(new Laptop("L-1", "Laptop", "i5", "INV-1"));
        assertThat(asetDao.semua()).extracting(Aset::getKode).containsExactlyInAnyOrder("R-1", "L-1");
    }

    @Test
    void perbaruiMengubahNamaStatusDanKondisi() {
        asetDao.simpan(new Ruang("R-1", "Aula", 80));
        Aset a = asetDao.cariByKode("R-1").orElseThrow();
        a.setNama("Aula Utama");
        a.setStatus(StatusAset.DIPINJAM);
        a.setKondisi(Kondisi.RUSAK_RINGAN);
        asetDao.perbarui(a);
        Aset baru = asetDao.cariByKode("R-1").orElseThrow();
        assertThat(baru.getNama()).isEqualTo("Aula Utama");
        assertThat(baru.getStatus()).isEqualTo(StatusAset.DIPINJAM);
        assertThat(baru.getKondisi()).isEqualTo(Kondisi.RUSAK_RINGAN);
    }

    @Test
    void hapusMengembalikanTrueLaluFalse() {
        asetDao.simpan(new Ruang("R-1", "Aula", 80));
        assertThat(asetDao.hapus("R-1")).isTrue();
        assertThat(asetDao.hapus("R-1")).isFalse();
        assertThat(asetDao.cariByKode("R-1")).isEmpty();
    }

    @Test
    void kodeGandaMelemparDataAksesException() {
        asetDao.simpan(new Ruang("R-1", "Aula", 80));
        assertThatThrownBy(() -> asetDao.simpan(new Ruang("R-1", "Lain", 10))).isInstanceOf(DataAksesException.class);
    }

    @Test
    void masukanBerbahayaTersimpanApaAdanyaBukanDieksekusi() {
        String jahat = "X'; DROP TABLE aset;--";
        asetDao.simpan(new Ruang(jahat, "Nama biasa", 5));
        assertThat(asetDao.cariByKode(jahat)).isPresent();
        assertThat(asetDao.semua()).hasSize(1);
    }

    @Test
    void peminjamanDisimpanDanDibacaKembali() {
        Ruang r = new Ruang("R-1", "Aula", 80);
        asetDao.simpan(r);
        Peminjaman p = TestSupport.pinjam("PJ-1", new Peminjam("P-01", "Peminjam Contoh"), r, 9, 11);
        peminjamanDao.simpan(p);
        Peminjaman hasil = peminjamanDao.cariById("PJ-1").orElseThrow();
        assertThat(hasil.getAset().getKode()).isEqualTo("R-1");
        assertThat(hasil.getPeminjam().id()).isEqualTo("P-01");
        assertThat(hasil.getMulai()).isEqualTo(TestSupport.jam(9));
        assertThat(hasil.getStatus()).isEqualTo(StatusPeminjaman.DIAJUKAN);
    }

    @Test
    void perbaruiStatusPeminjaman() {
        Ruang r = new Ruang("R-1", "Aula", 80);
        asetDao.simpan(r);
        peminjamanDao.simpan(TestSupport.pinjam("PJ-1", new Peminjam("P-01", "Peminjam Contoh"), r, 9, 11));
        assertThat(peminjamanDao.perbaruiStatus("PJ-1", StatusPeminjaman.DISETUJUI)).isTrue();
        assertThat(peminjamanDao.perbaruiStatus("TIDAK-ADA", StatusPeminjaman.DISETUJUI)).isFalse();
        assertThat(peminjamanDao.cariById("PJ-1").orElseThrow().getStatus()).isEqualTo(StatusPeminjaman.DISETUJUI);
    }
}
