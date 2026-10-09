package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.katalog.KatalogAset;
import id.ac.upb.asetpinjam.model.AlatLab;
import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Ruang;
import id.ac.upb.asetpinjam.model.TingkatRisiko;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/** Tarif: Ruang 1x, Laptop 2x, AlatLab 4x dari Varian.dendaPerHari, dikali jumlah hari. */
@Tag("week4")
class Minggu04PolimorfismeTest {

    private final long tarif = Varian.aktif().dendaPerHari;

    private final Aset ruang = new Ruang("R-01", "Ruang Rapat", 10);
    private final Aset laptop = new Laptop("L-01", "Laptop Dosen", "i5", "INV-1");
    private final Aset alat = new AlatLab("T-01", "Spektrometer Lab", "Lab Kimia", TingkatRisiko.TINGGI);

    @Test
    void dendaRuang() {
        assertThat(ruang.hitungDenda(3)).isEqualTo(3 * tarif);
    }

    @Test
    void dendaLaptopDuaKaliLipat() {
        assertThat(laptop.hitungDenda(3)).isEqualTo(3 * 2 * tarif);
    }

    @Test
    void dendaAlatLabEmpatKaliLipat() {
        assertThat(alat.hitungDenda(2)).isEqualTo(2 * 4 * tarif);
    }

    @Test
    void nolHariBerartiNolDenda() {
        assertThat(ruang.hitungDenda(0)).isZero();
        assertThat(laptop.hitungDenda(0)).isZero();
        assertThat(alat.hitungDenda(0)).isZero();
    }

    @Test
    void hariNegatifDitolak() {
        assertThatThrownBy(() -> ruang.hitungDenda(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> laptop.hitungDenda(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> alat.hitungDenda(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void overloadingCariDenganKataSaja() {
        KatalogAset k = isiKatalog();
        assertThat(k.cari("lab")).extracting(Aset::getKode).containsExactlyInAnyOrder("L-01", "T-01");
    }

    @Test
    void overloadingCariDenganKataDanJenis() {
        KatalogAset k = isiKatalog();
        assertThat(k.cari("lab", JenisAset.ALAT_LAB)).extracting(Aset::getKode).containsExactly("T-01");
        assertThat(k.cari("lab", JenisAset.RUANG)).isEmpty();
    }

    @Test
    void cariTanpaHasilMengembalikanDaftarKosong() {
        assertThat(isiKatalog().cari("tidak-ada-yang-begini")).isEmpty();
    }

    private KatalogAset isiKatalog() {
        KatalogAset k = new KatalogAset();
        k.tambah(ruang);
        k.tambah(new Laptop("L-01", "Laptop LAB Komputer", "i5", "INV-2"));
        k.tambah(alat);
        return k;
    }
}
