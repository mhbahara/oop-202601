package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa ruang. Kapasitas harus lebih dari 0 (IllegalArgumentException). */
public class Ruang extends Aset {

    // TODO minggu 3: field kapasitas.

    public Ruang(String kode, String nama, int kapasitas) {
        super(kode, nama);
        throw new UnsupportedOperationException("TODO minggu 3: konstruktor Ruang");
    }

    public int getKapasitas() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    // TODO minggu 3: override getJenis(). Minggu 4: override hitungDenda(int).
}
