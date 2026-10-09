package id.ac.upb.asetpinjam.factory;

import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;

/** Minggu 10: pola Factory. Satu pintu untuk membuat aset dari jenisnya. */
public final class AsetFactory {

    private AsetFactory() {
    }

    /**
     * TODO minggu 10: buat aset sesuai jenis. Urutan atribut:
     * RUANG    : [kapasitas]
     * LAPTOP   : [spesifikasi, nomorInventaris]
     * ALAT_LAB : [laboratorium, tingkatRisiko (nama enum TingkatRisiko)]
     * Jumlah atribut salah, angka tidak valid, atau jenis null: IllegalArgumentException.
     */
    public static Aset buat(JenisAset jenis, String kode, String nama, String... atribut) {
        throw new UnsupportedOperationException("TODO minggu 10: AsetFactory.buat");
    }
}
