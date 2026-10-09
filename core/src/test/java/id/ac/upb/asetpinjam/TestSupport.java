package id.ac.upb.asetpinjam;

import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.Laptop;
import id.ac.upb.asetpinjam.model.Peminjam;
import id.ac.upb.asetpinjam.model.Peminjaman;
import id.ac.upb.asetpinjam.model.Ruang;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;

/** Pembantu tes. DISEDIAKAN dosen. Jangan diubah. */
public final class TestSupport {

    private TestSupport() {
    }

    /**
     * Aset umum untuk tes tingkat Aset. Saat Aset masih konkret (minggu 2-4) dipakai Aset langsung;
     * setelah menjadi abstrak (minggu 5) dipakai Ruang.
     */
    public static Aset aset(String kode, String nama) {
        try {
            if (!Modifier.isAbstract(Aset.class.getModifiers())) {
                return Aset.class.getConstructor(String.class, String.class).newInstance(kode, nama);
            }
        } catch (ReflectiveOperationException e) {
            Throwable sebab = e.getCause() != null ? e.getCause() : e;
            if (sebab instanceof RuntimeException re) {
                throw re;
            }
            throw new IllegalStateException(sebab);
        }
        return new Ruang(kode, nama, 10);
    }

    public static Ruang ruang(String kode) {
        return new Ruang(kode, "Ruang " + kode, 20);
    }

    public static Laptop laptop(String kode) {
        return new Laptop(kode, "Laptop " + kode, "i5/16GB", "INV-" + kode);
    }

    public static Peminjam peminjam(String id) {
        return new Peminjam(id, "Peminjam " + id);
    }

    /** 2 Maret 2026 pukul {@code jam}:00. */
    public static LocalDateTime jam(int jam) {
        return LocalDateTime.of(2026, 3, 2, jam, 0);
    }

    public static Peminjaman pinjam(String id, Peminjam p, Aset a, int dariJam, int sampaiJam) {
        return new Peminjaman(id, p, a, jam(dariJam), jam(sampaiJam));
    }
}
