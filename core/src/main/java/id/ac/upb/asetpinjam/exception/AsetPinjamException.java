package id.ac.upb.asetpinjam.exception;

/** DISEDIAKAN dosen. Induk semua exception domain (unchecked). */
public class AsetPinjamException extends RuntimeException {

    public AsetPinjamException(String pesan) {
        super(pesan);
    }

    public AsetPinjamException(String pesan, Throwable sebab) {
        super(pesan, sebab);
    }
}
