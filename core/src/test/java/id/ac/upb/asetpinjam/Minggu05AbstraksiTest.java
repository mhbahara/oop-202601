package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.denda.DendaFlat;
import id.ac.upb.asetpinjam.denda.DendaProgresif;
import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;
import id.ac.upb.asetpinjam.model.AlatLab;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Kondisi;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Ruang;
import id.ac.upb.asetpinjam.model.StatusAset;
import id.ac.upb.asetpinjam.model.TingkatRisiko;
import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week5")
class Minggu05AbstraksiTest {

    private final List<Aset> semuaJenis = List.of(
            new Ruang("R-01", "Aula", 40),
            new Laptop("L-01", "Laptop", "i5", "INV-1"),
            new AlatLab("T-01", "Alat", "Lab", TingkatRisiko.SEDANG));

    @Test
    void asetMenjadiClassAbstrak() {
        assertThat(Modifier.isAbstract(Aset.class.getModifiers())).isTrue();
    }

    @Test
    void asetMengimplementasikanDapatDipinjam() {
        assertThat(DapatDipinjam.class.isAssignableFrom(Aset.class)).isTrue();
    }

    @Test
    void bisaDipinjamHanyaJikaTersediaDanTidakRusakBerat() {
        for (Aset a : semuaJenis) {
            assertThat(a.bisaDipinjam()).isTrue();
            a.setStatus(StatusAset.DIPINJAM);
            assertThat(a.bisaDipinjam()).isFalse();
            a.setStatus(StatusAset.TERSEDIA);
            a.setKondisi(Kondisi.RUSAK_BERAT);
            assertThat(a.bisaDipinjam()).isFalse();
            a.setKondisi(Kondisi.RUSAK_RINGAN);
            assertThat(a.bisaDipinjam()).isTrue();
        }
    }

    @Test
    void dendaFlatSamaDenganHitungDendaAset() {
        AturanDenda flat = new DendaFlat();
        for (Aset a : semuaJenis) {
            assertThat(flat.hitung(a, 5)).isEqualTo(a.hitungDenda(5));
        }
    }

    @Test
    void dendaProgresifMemenuhiSyaratMinimal() {
        AturanDenda flat = new DendaFlat();
        AturanDenda progresif = new DendaProgresif();
        for (Aset a : semuaJenis) {
            assertThat(progresif.hitung(a, 0)).isZero();
            long sebelumnya = 0;
            for (int hari = 1; hari <= 30; hari++) {
                long nilai = progresif.hitung(a, hari);
                assertThat(nilai).as("progresif >= flat pada hari %d", hari).isGreaterThanOrEqualTo(flat.hitung(a, hari));
                assertThat(nilai).as("tidak turun pada hari %d", hari).isGreaterThanOrEqualTo(sebelumnya);
                sebelumnya = nilai;
            }
            assertThat(progresif.hitung(a, 30)).as("makin lama makin berat").isGreaterThan(flat.hitung(a, 30));
        }
    }
}
