# Rubrik Ulasan Kode Sejawat (minggu 15)

Setiap mahasiswa mengulas **dua pull request rekan** (ditentukan acak oleh dosen). Tulis ulasan sebagai komentar di GitHub.

| Aspek | Bobot | Contoh yang baik |
|---|---|---|
| Menemukan masalah nyata | 35% | Menunjuk baris tertentu dan menjelaskan akibatnya (aturan bisnis salah, SQL tidak aman, layer bocor) |
| Ketepatan teknis | 25% | Pernyataan benar dan bisa diverifikasi; tidak asal setuju |
| Saran yang bisa ditindaklanjuti | 20% | Menyarankan perbaikan konkret atau alternatif desain, bukan hanya "kurang bagus" |
| Bahasa dan sikap | 10% | Sopan, ilmiah, fokus ke kode bukan orangnya |
| Menanggapi ulasan yang diterima | 10% | Memperbaiki karya sendiri atau menjelaskan alasan menolak saran |

Hal yang wajib diperiksa:
- Apakah ada SQL atau logika bisnis di controller?
- Apakah aturan ambigu dicatat di `docs/asumsi.md` dan punya tes?
- Apakah kredensial bocor?
- Apakah `catatan-ai` jujur dan sesuai dengan kode?

Ulasan yang hanya berisi "LGTM" atau salinan keluaran AI tanpa menunjuk kode nyata mendapat nilai rendah.
