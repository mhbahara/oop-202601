package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 10: konteks pola Strategy. Aturan denda DISUNTIKKAN lewat konstruktor
 * (bukan dibuat di dalam kelas ini), sehingga bisa diganti tanpa mengubah kelas ini.
 */
public class LayananDenda {

    // TODO minggu 10: simpan AturanDenda dalam field final.

    /** TODO minggu 10: aturan tidak boleh null (IllegalArgumentException). */
    public LayananDenda(AturanDenda aturan) {
        throw new UnsupportedOperationException("TODO minggu 10: konstruktor LayananDenda");
    }

    public long hitung(Aset aset, int hariTerlambat) {
        throw new UnsupportedOperationException("TODO minggu 10: LayananDenda.hitung");
    }
}
