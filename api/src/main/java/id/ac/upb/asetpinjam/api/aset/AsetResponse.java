package id.ac.upb.asetpinjam.api.aset;

import id.ac.upb.asetpinjam.model.Aset;
import id.ac.upb.asetpinjam.model.JenisAset;
import id.ac.upb.asetpinjam.model.Kondisi;
import id.ac.upb.asetpinjam.model.StatusAset;

/** DISEDIAKAN dosen. Bentuk JSON respons: kode, nama, jenis, status, kondisi. */
public record AsetResponse(String kode, String nama, JenisAset jenis, StatusAset status, Kondisi kondisi) {

    public static AsetResponse dari(Aset aset) {
        return new AsetResponse(aset.getKode(), aset.getNama(), aset.getJenis(), aset.getStatus(), aset.getKondisi());
    }
}
