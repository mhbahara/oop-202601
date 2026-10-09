package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.denda.DendaFlat;
import id.ac.upb.asetpinjam.denda.DendaProgresif;
import id.ac.upb.asetpinjam.denda.LayananDenda;
import id.ac.upb.asetpinjam.factory.AsetFactory;
import id.ac.upb.asetpinjam.model.AlatLab;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Ruang;
import id.ac.upb.asetpinjam.model.TingkatRisiko;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week10")
class Minggu10PatternTest {

    @Test
    void factoryMembuatRuang() {
        Aset a = AsetFactory.buat(JenisAset.RUANG, "R-1", "Aula", "80");
        assertThat(a).isInstanceOf(Ruang.class);
        assertThat(((Ruang) a).getKapasitas()).isEqualTo(80);
    }

    @Test
    void factoryMembuatLaptop() {
        Aset a = AsetFactory.buat(JenisAset.LAPTOP, "L-1", "Laptop", "i7/32GB", "INV-7");
        assertThat(a).isInstanceOf(Laptop.class);
        assertThat(((Laptop) a).getNomorInventaris()).isEqualTo("INV-7");
    }

    @Test
    void factoryMembuatAlatLab() {
        Aset a = AsetFactory.buat(JenisAset.ALAT_LAB, "T-1", "Alat", "Lab Fisika", "TINGGI");
        assertThat(a).isInstanceOf(AlatLab.class);
        assertThat(((AlatLab) a).getTingkatRisiko()).isEqualTo(TingkatRisiko.TINGGI);
    }

    @Test
    void factoryMenolakMasukanTidakValid() {
        assertThatThrownBy(() -> AsetFactory.buat(null, "X", "Y")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AsetFactory.buat(JenisAset.RUANG, "R-1", "Aula")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AsetFactory.buat(JenisAset.RUANG, "R-1", "Aula", "banyak")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AsetFactory.buat(JenisAset.LAPTOP, "L-1", "L", "hanya-satu")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AsetFactory.buat(JenisAset.ALAT_LAB, "T-1", "A", "Lab", "SANGAT-TINGGI")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void layananDendaMemakaiStrategiYangDisuntikkan() {
        Aset a = new Ruang("R-1", "Aula", 10);
        assertThat(new LayananDenda((aset, hari) -> 42L).hitung(a, 3)).isEqualTo(42L);
        assertThat(new LayananDenda(new DendaFlat()).hitung(a, 3)).isEqualTo(a.hitungDenda(3));
        assertThat(new LayananDenda(new DendaProgresif()).hitung(a, 30)).isGreaterThan(a.hitungDenda(30));
    }

    @Test
    void layananDendaMenolakStrategiNull() {
        assertThatThrownBy(() -> new LayananDenda(null)).isInstanceOf(IllegalArgumentException.class);
    }

    /** Syarat tugas: minimal 8 tes milik Anda sendiri di folder mahasiswa/. */
    @Test
    void minimalDelapanTesBuatanSendiri() throws IOException {
        Path folder = Path.of("src", "test", "java", "id", "ac", "upb", "asetpinjam", "mahasiswa");
        Pattern anotasi = Pattern.compile("(?m)^\\s*@Test\\b");
        long jumlah;
        try (Stream<Path> berkas = Files.walk(folder)) {
            jumlah = berkas.filter(p -> p.toString().endsWith(".java"))
                    .mapToLong(p -> {
                        try {
                            return anotasi.matcher(Files.readString(p)).results().count();
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }).sum();
        }
        assertThat(jumlah).as("jumlah @Test di folder mahasiswa/ (belum termasuk yang @Disabled bawaan)").isGreaterThanOrEqualTo(9);
    }
}
