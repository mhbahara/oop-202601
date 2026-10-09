package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Kondisi;
import id.ac.upb.asetpinjam.model.StatusAset;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week2")
class Minggu02AsetTest {

    @Test
    void menyimpanKodeDanNamaDenganNilaiAwal() {
        Aset a = TestSupport.aset("A-01", "Proyektor");
        assertThat(a.getKode()).isEqualTo("A-01");
        assertThat(a.getNama()).isEqualTo("Proyektor");
        assertThat(a.getStatus()).isEqualTo(StatusAset.TERSEDIA);
        assertThat(a.getKondisi()).isEqualTo(Kondisi.BAIK);
    }

    @Test
    void kodeKosongDitolak() {
        assertThatThrownBy(() -> TestSupport.aset(null, "X")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TestSupport.aset("", "X")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TestSupport.aset("   ", "X")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void namaKosongDitolak() {
        assertThatThrownBy(() -> TestSupport.aset("A-01", null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> TestSupport.aset("A-01", " ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void setNamaMemvalidasi() {
        Aset a = TestSupport.aset("A-01", "Lama");
        a.setNama("Baru");
        assertThat(a.getNama()).isEqualTo("Baru");
        assertThatThrownBy(() -> a.setNama("")).isInstanceOf(IllegalArgumentException.class);
        assertThat(a.getNama()).isEqualTo("Baru");
    }

    @Test
    void setStatusDanKondisiMemvalidasi() {
        Aset a = TestSupport.aset("A-01", "Alat");
        a.setStatus(StatusAset.DIPINJAM);
        a.setKondisi(Kondisi.RUSAK_RINGAN);
        assertThat(a.getStatus()).isEqualTo(StatusAset.DIPINJAM);
        assertThat(a.getKondisi()).isEqualTo(Kondisi.RUSAK_RINGAN);
        assertThatThrownBy(() -> a.setStatus(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> a.setKondisi(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void semuaFieldPrivatDanKodeTidakBisaDiubah() {
        assertThat(Arrays.stream(Aset.class.getDeclaredFields()))
                .allMatch(f -> Modifier.isPrivate(f.getModifiers()), "semua field Aset private");
        assertThat(Arrays.stream(Aset.class.getMethods()).map(m -> m.getName())).doesNotContain("setKode");
    }
}
