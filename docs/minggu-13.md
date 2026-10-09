# Minggu 13: REST API Lanjutan dan Modern OOP

Bobot: Laporan 1%, Praktikum 3%, Observasi 1%.

## Tujuan

- Validasi input dan penanganan error yang seragam.
- Memakai generics, lambda, dan stream bermakna.

## Yang dikerjakan

- `AsetRequest.java`: anotasi validasi Jakarta.
- `api/.../error/GlobalExceptionHandler.java`: petakan exception ke `KesalahanApi`.
- `api/.../laporan/LaporanController.java`: `asetPerJenis` dengan stream.

## Aturan pasti (dipakai tes)

- Validasi gagal -> 400 dengan `kesalahan` berisi pesan per field (`kode`, `jenis`, dan seterusnya).
- Aturan domain dilanggar (mis. kapasitas negatif) -> 400 dengan `pesan`.
- Kode ganda -> 409. Tidak ditemukan -> 404. Semua memakai bentuk `KesalahanApi`.
- `GET /api/laporan/aset-per-jenis` -> jumlah per jenis, dibuat dengan stream.
- Dokumentasi OpenAPI tersedia di `/v3/api-docs`.

## Keputusan Anda

- Anotasi validasi mana yang dipakai untuk atribut yang bergantung pada jenis.

## Tes

`api/src/test/java/id/ac/upb/asetpinjam/api/Minggu13LanjutanApiTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Generics: tulis satu kelas atau metode generik yang bermakna (misalnya pembungkus hasil halaman) dan jelaskan alasannya di catatan.

## Pengumpulan

- Commit dengan format `minggu-13: ringkasan`.
- Isi `catatan/minggu-13.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
