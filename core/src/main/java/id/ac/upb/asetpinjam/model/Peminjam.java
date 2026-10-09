package id.ac.upb.asetpinjam.model;

/** DISEDIAKAN dosen. Peminjam (mahasiswa atau dosen). */
public record Peminjam(String id, String nama) {
    public Peminjam {
        if (id == null || id.isBlank() || nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("id dan nama peminjam wajib diisi");
        }
    }
}
