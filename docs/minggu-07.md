# Minggu 7: Koleksi

Bobot: Quiz 2%, Praktikum 3%.

## Tujuan

- Memilih List, Map, atau Set untuk masalah nyata.
- Mengurutkan dengan Comparator.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/jadwal/JadwalPeminjaman.java`: `bentrok`, `semuaUrutMulai`, `perAset`, `hapus`.

## Aturan pasti (dipakai tes)

- Bentrok hanya untuk aset yang sama.
- Rentang yang jelas tumpang tindih atau terkandung adalah bentrok; yang terpisah jauh bukan.
- `semuaUrutMulai` menaik menurut waktu mulai.
- `perAset` mengelompokkan menurut kode aset.
- `hapus(id)` true jika ada yang terhapus.

## Keputusan Anda

- Perilaku di batas waktu (selesai sama dengan mulai). **Tuliskan tesnya sendiri** di `mahasiswa/BatasBentrokTest.java`.
- Struktur data internal (List saja, atau tambah Map/Set?). Jelaskan di catatan.

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu07JadwalTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Pengumpulan

- Commit dengan format `minggu-07: ringkasan`.
- Isi `catatan/minggu-07.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
