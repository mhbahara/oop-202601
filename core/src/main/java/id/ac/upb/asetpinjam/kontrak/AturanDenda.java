package id.ac.upb.asetpinjam.kontrak;

import id.ac.upb.asetpinjam.model.Aset;

/** DISEDIAKAN dosen (minggu 5). Satu cara menghitung denda keterlambatan (pola Strategy, minggu 10). */
public interface AturanDenda {

    /** Denda dalam rupiah untuk aset yang terlambat dikembalikan sekian hari (0 atau lebih). */
    long hitung(Aset aset, int hariTerlambat);
}
