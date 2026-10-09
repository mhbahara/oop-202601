# Minggu 4: Polymorphism

Bobot: Quiz 2%, Praktikum 1%.

## Tujuan

- Memakai overriding dan dynamic binding.
- Membedakan overloading dan overriding.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java` dan tiga subclass: override `hitungDenda(int)`.
- `core/src/main/java/id/ac/upb/asetpinjam/katalog/KatalogAset.java`: dua overload `cari(...)`.

## Aturan pasti (dipakai tes)

- Denda = hari x multiplier jenis x tarif varian Anda. Ruang 1x, Laptop 2x, AlatLab 4x.
- 0 hari = 0. Hari negatif: `IllegalArgumentException`.
- `cari(kata)` mencocokkan nama yang memuat kata tanpa membedakan huruf besar atau kecil.
- `cari(kata, jenis)` sama, tetapi hanya untuk jenis tersebut.

## Keputusan Anda

- Tidak ada. Aturan minggu ini pasti.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu04PolimorfismeTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Tarif dasar dibaca dari `Varian.aktif().dendaPerHari`.

## Pengumpulan

- Commit dengan format `minggu-04: ringkasan`.
- Isi `catatan/minggu-04.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
