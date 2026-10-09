# Minggu 5: Abstraction

Bobot: Quiz 2%, Praktikum 1%.

## Tujuan

- Memilih antara abstract class dan interface.
- Mengimplementasikan interface.

## Yang dikerjakan

- `core/src/main/java/id/ac/upb/asetpinjam/model/Aset.java`: isi `bisaDipinjam()` (Aset sudah mengimplementasikan `DapatDipinjam`), lalu jadikan kelas `abstract` (dan `hitungDenda` abstrak).
- `core/src/main/java/id/ac/upb/asetpinjam/denda/DendaFlat.java` dan `DendaProgresif.java`: implementasikan `AturanDenda`.

## Aturan pasti (dipakai tes)

- `bisaDipinjam()` true hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT.
- `DendaFlat` = `aset.hitungDenda(hari)`.
- `DendaProgresif`: 0 hari = 0, tidak pernah lebih murah dari flat, tidak pernah turun saat hari bertambah, dan pada hari ke-30 lebih mahal dari flat.

## Keputusan Anda

- Rumus progresif (catat di asumsi).

## Tes

`core/src/test/java/id/ac/upb/asetpinjam/Minggu05AbstraksiTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Setelah Aset abstrak, tes minggu 2 tetap jalan: `TestSupport.aset(...)` otomatis memakai `Ruang`.

## Pengumpulan

- Commit dengan format `minggu-05: ringkasan`.
- Isi `catatan/minggu-05.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
