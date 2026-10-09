package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.model.AlatLab;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Ruang;
import id.ac.upb.asetpinjam.model.TingkatRisiko;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week3")
class Minggu03HierarkiTest {

    @Test
    void ruangAdalahAsetDenganKapasitas() {
        Ruang r = new Ruang("R-01", "Aula", 120);
        assertThat(r).isInstanceOf(Aset.class);
        assertThat(r.getKode()).isEqualTo("R-01");
        assertThat(r.getKapasitas()).isEqualTo(120);
        assertThat(r.getJenis()).isEqualTo(JenisAset.RUANG);
    }

    @Test
    void kapasitasHarusPositif() {
        assertThatThrownBy(() -> new Ruang("R-01", "Aula", 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ruang("R-01", "Aula", -5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void laptopMenyimpanSpesifikasiDanNomorInventaris() {
        Laptop l = new Laptop("L-01", "Laptop A", "i5/16GB", "INV-9");
        assertThat(l).isInstanceOf(Aset.class);
        assertThat(l.getSpesifikasi()).isEqualTo("i5/16GB");
        assertThat(l.getNomorInventaris()).isEqualTo("INV-9");
        assertThat(l.getJenis()).isEqualTo(JenisAset.LAPTOP);
    }

    @Test
    void laptopMenolakDataKosong() {
        assertThatThrownBy(() -> new Laptop("L-01", "A", "", "INV")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Laptop("L-01", "A", "i5", " ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void alatLabMenyimpanLaboratoriumDanRisiko() {
        AlatLab a = new AlatLab("T-01", "Osiloskop", "Lab Elektronika", TingkatRisiko.SEDANG);
        assertThat(a).isInstanceOf(Aset.class);
        assertThat(a.getLaboratorium()).isEqualTo("Lab Elektronika");
        assertThat(a.getTingkatRisiko()).isEqualTo(TingkatRisiko.SEDANG);
        assertThat(a.getJenis()).isEqualTo(JenisAset.ALAT_LAB);
    }

    @Test
    void alatLabMenolakDataKosong() {
        assertThatThrownBy(() -> new AlatLab("T-01", "X", "", TingkatRisiko.RENDAH))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AlatLab("T-01", "X", "Lab", null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validasiWarisanTetapBerlaku() {
        assertThatThrownBy(() -> new Ruang("", "Aula", 10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void semuaJenisBisaDiperlakukanSebagaiAset() {
        List<Aset> daftar = List.of(
                new Ruang("R-01", "Aula", 50),
                new Laptop("L-01", "Laptop", "i7", "INV-1"),
                new AlatLab("T-01", "Mikroskop", "Lab Bio", TingkatRisiko.TINGGI));
        assertThat(daftar).extracting(Aset::getJenis)
                .containsExactly(JenisAset.RUANG, JenisAset.LAPTOP, JenisAset.ALAT_LAB);
    }
}
