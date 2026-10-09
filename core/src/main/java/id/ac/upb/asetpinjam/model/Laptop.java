package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa laptop. Spesifikasi dan nomor inventaris tidak boleh kosong. */
public class Laptop extends Aset {

    // TODO minggu 3: field spesifikasi dan nomorInventaris.

    public Laptop(String kode, String nama, String spesifikasi, String nomorInventaris) {
        super(kode, nama);
        throw new UnsupportedOperationException("TODO minggu 3: konstruktor Laptop");
    }

    public String getSpesifikasi() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    public String getNomorInventaris() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    // TODO minggu 3: override getJenis(). Minggu 4: override hitungDenda(int).
}
