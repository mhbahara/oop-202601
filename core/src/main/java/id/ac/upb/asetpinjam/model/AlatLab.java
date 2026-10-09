package id.ac.upb.asetpinjam.model;

/** Minggu 3: alat laboratorium. Laboratorium tidak boleh kosong; risiko tidak boleh null. */
public class AlatLab extends Aset {

    // TODO minggu 3: field laboratorium dan tingkatRisiko.

    public AlatLab(String kode, String nama, String laboratorium, TingkatRisiko tingkatRisiko) {
        super(kode, nama);
        throw new UnsupportedOperationException("TODO minggu 3: konstruktor AlatLab");
    }

    public String getLaboratorium() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    public TingkatRisiko getTingkatRisiko() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    // TODO minggu 3: override getJenis(). Minggu 4: override hitungDenda(int).
}
