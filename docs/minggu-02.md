# Minggu 2: Struktur OOP: Class, Object, Encapsulation

Bobot: Quiz 2%, Praktikum 1%.

## Tujuan

- Membuat class dengan field private, konstruktor, getter/setter, dan validasi.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java`: field, konstruktor, getter, setter dengan validasi.

## Aturan pasti (dipakai tes)

- Kode dan nama tidak boleh null atau kosong (`IllegalArgumentException`).
- Nilai awal: status TERSEDIA, kondisi BAIK.
- Semua field private. Kode tidak boleh punya setter.
- `setStatus` dan `setKondisi` menolak null.

## Keputusan Anda

- Apakah kode dinormalisasi (trim, huruf besar)? Catat di asumsi bila ya.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu02AsetTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Pengumpulan

- Commit dengan format `minggu-02: ringkasan`.
- Isi `catatan/minggu-02.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
