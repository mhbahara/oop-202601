package id.ac.upb.asetpinjam;

import static id.ac.upb.asetpinjam.TestSupport.pinjam;
import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.jadwal.JadwalPeminjaman;
import id.ac.upb.asetpinjam.model.Peminjaman;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Hanya kasus yang JELAS. Perilaku di batas waktu (selesai sama dengan mulai) sengaja tidak diuji di sini:
 * itu keputusan Anda, tuliskan tesnya sendiri di folder mahasiswa/ (lihat BatasBentrokTest).
 */
@Tag("week7")
class Minggu07JadwalTest {

    private JadwalPeminjaman jadwal;

    @BeforeEach
    void siapkan() {
        jadwal = new JadwalPeminjaman(Varian.aktif().kuotaLaptop);
    }

    @Test
    void tumpangTindihSebagianBentrok() {
        jadwal.tambah(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 11));
        Peminjaman baru = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 10, 12);
        assertThat(jadwal.bentrok(baru)).isTrue();
    }

    @Test
    void terkandungSepenuhnyaBentrok() {
        jadwal.tambah(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 17));
        Peminjaman baru = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 10, 11);
        assertThat(jadwal.bentrok(baru)).isTrue();
    }

    @Test
    void terpisahJauhTidakBentrok() {
        jadwal.tambah(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 8, 9));
        Peminjaman baru = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 13, 15);
        assertThat(jadwal.bentrok(baru)).isFalse();
    }

    @Test
    void asetBerbedaTidakBentrokMeskiWaktuSama() {
        jadwal.tambah(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 11));
        Peminjaman baru = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-2"), 9, 11);
        assertThat(jadwal.bentrok(baru)).isFalse();
    }

    @Test
    void jadwalKosongTidakBentrok() {
        Peminjaman baru = pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 11);
        assertThat(jadwal.bentrok(baru)).isFalse();
    }

    @Test
    void semuaUrutMulaiTerurutMenaik() {
        var p = TestSupport.peminjam("P1");
        jadwal.tambah(pinjam("c", p, TestSupport.ruang("R-3"), 15, 16));
        jadwal.tambah(pinjam("a", p, TestSupport.ruang("R-1"), 8, 9));
        jadwal.tambah(pinjam("b", p, TestSupport.ruang("R-2"), 11, 12));
        assertThat(jadwal.semuaUrutMulai()).extracting(Peminjaman::getId).containsExactly("a", "b", "c");
    }

    @Test
    void perAsetMengelompokkanMenurutKodeAset() {
        var p = TestSupport.peminjam("P1");
        jadwal.tambah(pinjam("1", p, TestSupport.ruang("R-1"), 8, 9));
        jadwal.tambah(pinjam("2", p, TestSupport.ruang("R-1"), 10, 11));
        jadwal.tambah(pinjam("3", p, TestSupport.ruang("R-2"), 8, 9));
        Map<String, List<Peminjaman>> peta = jadwal.perAset();
        assertThat(peta).containsOnlyKeys("R-1", "R-2");
        assertThat(peta.get("R-1")).hasSize(2);
        assertThat(peta.get("R-2")).hasSize(1);
    }

    @Test
    void hapusMenghapusBerdasarkanId() {
        var p = TestSupport.peminjam("P1");
        jadwal.tambah(pinjam("1", p, TestSupport.ruang("R-1"), 8, 9));
        assertThat(jadwal.hapus("1")).isTrue();
        assertThat(jadwal.hapus("1")).isFalse();
        assertThat(jadwal.semuaUrutMulai()).isEmpty();
    }
}
