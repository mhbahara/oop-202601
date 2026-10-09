package id.ac.upb.asetpinjam;

import static id.ac.upb.asetpinjam.TestSupport.pinjam;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.exception.AsetPinjamException;
import id.ac.upb.asetpinjam.exception.KuotaHabisException;
import id.ac.upb.asetpinjam.exception.PeminjamanBentrokException;
import id.ac.upb.asetpinjam.exception.StatusTidakSahException;
import id.ac.upb.asetpinjam.jadwal.JadwalPeminjaman;
import id.ac.upb.asetpinjam.model.Peminjam;
import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.StatusPeminjaman;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DIAJUKAN;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DIBATALKAN;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DIKEMBALIKAN;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DIPINJAM;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DISETUJUI;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.DITOLAK;
import static id.ac.upb.asetpinjam.model.StatusPeminjaman.TERLAMBAT;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week9")
class Minggu09ExceptionTest {

    /** Jalur sah dari DIAJUKAN menuju status tertentu. */
    private static final Map<StatusPeminjaman, List<StatusPeminjaman>> JALUR = Map.of(
            DIAJUKAN, List.of(),
            DISETUJUI, List.of(DISETUJUI),
            DITOLAK, List.of(DITOLAK),
            DIBATALKAN, List.of(DISETUJUI, DIBATALKAN),
            DIPINJAM, List.of(DISETUJUI, DIPINJAM),
            TERLAMBAT, List.of(DISETUJUI, DIPINJAM, TERLAMBAT),
            DIKEMBALIKAN, List.of(DISETUJUI, DIPINJAM, DIKEMBALIKAN));

    private Peminjaman dalamStatus(StatusPeminjaman target) {
        Peminjaman p = pinjam("x", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 8, 9);
        for (StatusPeminjaman langkah : JALUR.get(target)) {
            p.ubahStatus(langkah);
        }
        assertThat(p.getStatus()).isEqualTo(target);
        return p;
    }

    @Test
    void perpindahanSahDiterima() {
        assertThatCode(() -> dalamStatus(DIAJUKAN).ubahStatus(DISETUJUI)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(DIAJUKAN).ubahStatus(DITOLAK)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(DISETUJUI).ubahStatus(DIPINJAM)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(DISETUJUI).ubahStatus(DIBATALKAN)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(DIPINJAM).ubahStatus(DIKEMBALIKAN)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(DIPINJAM).ubahStatus(TERLAMBAT)).doesNotThrowAnyException();
        assertThatCode(() -> dalamStatus(TERLAMBAT).ubahStatus(DIKEMBALIKAN)).doesNotThrowAnyException();
    }

    @Test
    void perpindahanTidakSahMelemparStatusTidakSahException() {
        assertThatThrownBy(() -> dalamStatus(DIAJUKAN).ubahStatus(DIPINJAM)).isInstanceOf(StatusTidakSahException.class);
        assertThatThrownBy(() -> dalamStatus(DIAJUKAN).ubahStatus(DIKEMBALIKAN)).isInstanceOf(StatusTidakSahException.class);
        assertThatThrownBy(() -> dalamStatus(DITOLAK).ubahStatus(DISETUJUI)).isInstanceOf(StatusTidakSahException.class);
        assertThatThrownBy(() -> dalamStatus(DIBATALKAN).ubahStatus(DISETUJUI)).isInstanceOf(StatusTidakSahException.class);
        assertThatThrownBy(() -> dalamStatus(DIKEMBALIKAN).ubahStatus(DIPINJAM)).isInstanceOf(StatusTidakSahException.class);
        assertThatThrownBy(() -> dalamStatus(DISETUJUI).ubahStatus(DIKEMBALIKAN)).isInstanceOf(StatusTidakSahException.class);
    }

    @Test
    void statusTidakBerubahKetikaPerpindahanDitolak() {
        Peminjaman p = dalamStatus(DIAJUKAN);
        assertThatThrownBy(() -> p.ubahStatus(DIPINJAM)).isInstanceOf(StatusTidakSahException.class);
        assertThat(p.getStatus()).isEqualTo(DIAJUKAN);
    }

    @Test
    void pesanStatusTidakSahMenyebutAsalDanTujuan() {
        assertThatThrownBy(() -> dalamStatus(DIAJUKAN).ubahStatus(DIPINJAM))
                .hasMessageContaining("DIAJUKAN")
                .hasMessageContaining("DIPINJAM")
                .satisfies(e -> assertThat(e.getMessage()).doesNotContain("TODO"));
    }

    @Test
    void ajukanTanpaBentrokMenambahkan() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(Varian.aktif().kuotaLaptop);
        jadwal.ajukan(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 8, 9));
        jadwal.ajukan(pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 13, 14));
        assertThat(jadwal.semuaUrutMulai()).hasSize(2);
    }

    @Test
    void ajukanBentrokMelemparExceptionDanTidakMenambahkan() {
        JadwalPeminjaman jadwal = new JadwalPeminjaman(Varian.aktif().kuotaLaptop);
        jadwal.ajukan(pinjam("1", TestSupport.peminjam("P1"), TestSupport.ruang("R-1"), 9, 11));
        Peminjaman bentrok = pinjam("2", TestSupport.peminjam("P2"), TestSupport.ruang("R-1"), 10, 12);
        assertThatThrownBy(() -> jadwal.ajukan(bentrok))
                .isInstanceOf(PeminjamanBentrokException.class)
                .hasMessageContaining("R-1")
                .satisfies(e -> assertThat(e.getMessage()).doesNotContain("TODO"));
        assertThat(jadwal.semuaUrutMulai()).hasSize(1);
    }

    @Test
    void kuotaLaptopHabisMelemparKuotaHabisException() {
        int kuota = Varian.aktif().kuotaLaptop;
        JadwalPeminjaman jadwal = new JadwalPeminjaman(kuota);
        Peminjam budi = TestSupport.peminjam("P-BUDI");
        for (int i = 1; i <= kuota; i++) {
            Peminjaman p = pinjam("k" + i, budi, TestSupport.laptop("L-" + i), 8, 9);
            p.ubahStatus(DISETUJUI);
            jadwal.tambah(p);
        }
        Peminjaman lagi = pinjam("lebih", budi, TestSupport.laptop("L-LEBIH"), 8, 9);
        assertThatThrownBy(() -> jadwal.ajukan(lagi))
                .isInstanceOf(KuotaHabisException.class)
                .hasMessageContaining("P-BUDI")
                .hasMessageContaining(String.valueOf(kuota))
                .satisfies(e -> assertThat(e.getMessage()).doesNotContain("TODO"));
    }

    @Test
    void kuotaLaptopTidakMenghalangiRuangAtauPeminjamLain() {
        int kuota = Varian.aktif().kuotaLaptop;
        JadwalPeminjaman jadwal = new JadwalPeminjaman(kuota);
        Peminjam budi = TestSupport.peminjam("P-BUDI");
        for (int i = 1; i <= kuota; i++) {
            Peminjaman p = pinjam("k" + i, budi, TestSupport.laptop("L-" + i), 8, 9);
            p.ubahStatus(DISETUJUI);
            jadwal.tambah(p);
        }
        assertThatCode(() -> jadwal.ajukan(pinjam("r", budi, TestSupport.ruang("R-9"), 8, 9))).doesNotThrowAnyException();
        assertThatCode(() -> jadwal.ajukan(pinjam("o", TestSupport.peminjam("P-ANI"), TestSupport.laptop("L-ANI"), 8, 9)))
                .doesNotThrowAnyException();
    }

    @Test
    void semuaExceptionDomainTurunanAsetPinjamException() {
        assertThat(AsetPinjamException.class)
                .isAssignableFrom(PeminjamanBentrokException.class)
                .isAssignableFrom(KuotaHabisException.class)
                .isAssignableFrom(StatusTidakSahException.class);
    }
}
