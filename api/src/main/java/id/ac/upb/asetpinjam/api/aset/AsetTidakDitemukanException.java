package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.exception.AsetPinjamException;

/** DISEDIAKAN dosen. Dipetakan ke HTTP 404 oleh GlobalExceptionHandler (minggu 12-13). */
public class AsetTidakDitemukanException extends AsetPinjamException {

    public AsetTidakDitemukanException(String kode) {
        super("Aset dengan kode " + kode + " tidak ditemukan");
    }
}
