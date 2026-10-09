package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.model.JenisAset;

/**
 * Badan permintaan untuk membuat aset. Atribut yang dipakai bergantung pada jenis:
 * RUANG: kapasitas; LAPTOP: spesifikasi, nomorInventaris; ALAT_LAB: laboratorium, tingkatRisiko.
 *
 * <p>Minggu 13: tambahkan anotasi validasi Jakarta (@NotBlank, @NotNull, dan seterusnya) pada komponen record.
 */
public record AsetRequest(
        JenisAset jenis,
        String kode,
        String nama,
        Integer kapasitas,
        String spesifikasi,
        String nomorInventaris,
        String laboratorium,
        String tingkatRisiko) {
}
