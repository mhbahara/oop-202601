# Minggu 12: REST API Dasar dengan Spring Boot

Bobot: Quiz 1%, Praktikum 3%, Observasi 1%.

## Tujuan

- Memahami alur controller, service, repository.
- Membuat endpoint REST.

## Yang dikerjakan

- `api/src/main/java/id/ac/upb/asetpinjam/api/aset/AsetController.java` dan `AsetService.java`.

## Aturan pasti (dipakai tes)

- POST /api/aset -> 201 dan isi aset. GET /api/aset -> daftar. GET /api/aset/{kode} -> 200 atau 404. DELETE /api/aset/{kode} -> 204 atau 404.
- Controller tidak berisi logika bisnis. Pembuatan objek aset lewat `AsetFactory` dari modul core.
- JSON respons: kode, nama, jenis, status, kondisi.
- Repository untuk minggu ini adalah `InMemoryAsetRepository` (disediakan).

## Keputusan Anda

- Cara memetakan `AsetRequest` ke atribut `AsetFactory` (kelola atribut yang null).

## Tes

`api/src/test/java/id/ac/upb/asetpinjam/api/Minggu12AsetApiTest.java`

Jalankan: `bash scripts/uji.sh` (atau `.\scripts\uji.ps1` di PowerShell).

## Catatan

- Jalankan: `mvn -pl api spring-boot:run`, lalu buka http://localhost:8080/swagger-ui.html.

## Pengumpulan

- Commit dengan format `minggu-12: ringkasan`.
- Isi `catatan/minggu-12.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
