package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.minggu01.HelloFungsional;
import id.ac.upb.asetpinjam.minggu01.HelloOOP;
import id.ac.upb.asetpinjam.minggu01.HelloProsedural;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("week1")
class Minggu01Test {

    @Test
    void dataMahasiswaSudahDiisi() {
        Varian v = Varian.aktif();
        assertThat(v.nim).isNotBlank();
        assertThat(v.nama).isNotBlank();
    }

    @Test
    void gayaProsedural() {
        String s = HelloProsedural.sapa("Budi", "2310112345");
        assertThat(s).contains("Aset-Pinjam", "Budi", "2310112345");
    }

    @Test
    void gayaOOP() {
        String s = new HelloOOP("Budi", "2310112345").sapa();
        assertThat(s).contains("Aset-Pinjam", "Budi", "2310112345");
    }

    @Test
    void gayaFungsional() {
        String s = HelloFungsional.pembuatSapaan("2310112345").apply("Budi");
        assertThat(s).contains("Aset-Pinjam", "Budi", "2310112345");
    }

    @Test
    void ketigaGayaMenghasilkanIsiSama() {
        String a = HelloProsedural.sapa("Sari", "77");
        String b = new HelloOOP("Sari", "77").sapa();
        String c = HelloFungsional.pembuatSapaan("77").apply("Sari");
        assertThat(a).isEqualTo(b).isEqualTo(c);
    }
}
