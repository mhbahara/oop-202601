# Minggu 3: Inheritance

Bobot: Quiz 2%, Praktikum 1%.

## Tujuan

- Membuat hierarki class dan memakai ulang kode induk.
- Menjelaskan satu keterbatasan inheritance.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/model/Ruang.java`, `Laptop.java`, `AlatLab.java`: field, konstruktor (panggil `super`), getter, dan `getJenis()`.

## Aturan pasti (dipakai tes)

- Kapasitas ruang harus > 0.
- Spesifikasi dan nomor inventaris laptop tidak boleh kosong.
- Laboratorium tidak boleh kosong dan tingkat risiko tidak boleh null.
- `getJenis()` mengembalikan RUANG, LAPTOP, dan ALAT_LAB sesuai kelasnya.
- Validasi dari `Aset` tetap berlaku di subclass.

## Keputusan Anda

- Mana yang seharusnya field di induk dan mana di subclass.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu03HierarkiTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Di catatan, tulis satu contoh di sistem ini di mana inheritance kurang tepat dibanding komposisi.

## Pengumpulan

- Commit dengan format `minggu-03: ringkasan`.
- Isi `catatan/minggu-03.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
