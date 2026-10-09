package id.ac.upb.asetpinjam.kontrak;

/** DISEDIAKAN dosen (minggu 5). Aset yang mengimplementasikan ini dapat ditanya apakah boleh dipinjam. */
public interface DapatDipinjam {

    /** True jika status TERSEDIA dan kondisi bukan RUSAK_BERAT. */
    boolean bisaDipinjam();
}
