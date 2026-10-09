package id.ac.upb.asetpinjam.minggu01;

import id.ac.upb.asetpinjam.config.Varian;

/** Minggu 1, gaya OOP: data dan perilaku dibungkus dalam sebuah class. */
public class HelloOOP {

    // TODO minggu 1: tambahkan field private untuk nama dan nim.

    public HelloOOP(String nama, String nim) {
        throw new UnsupportedOperationException("TODO minggu 1: konstruktor HelloOOP");
    }

    /** TODO minggu 1: sapaan memuat "Aset-Pinjam", nama, dan NIM. */
    public String sapa() {
        throw new UnsupportedOperationException("TODO minggu 1: HelloOOP.sapa");
    }

    public static void main(String[] args) {
        Varian v = Varian.aktif();
        System.out.println(new HelloOOP(v.nama, v.nim).sapa());
    }
}
