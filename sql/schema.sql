-- Skema dasar Aset-Pinjam. Mahasiswa boleh menambah kolom/tabel (catat di docs/asumsi.md).
CREATE TABLE IF NOT EXISTS aset (
    kode              VARCHAR(30) PRIMARY KEY,
    nama              VARCHAR(100) NOT NULL,
    jenis             VARCHAR(20)  NOT NULL CHECK (jenis IN ('RUANG', 'LAPTOP', 'ALAT_LAB')),
    status            VARCHAR(20)  NOT NULL DEFAULT 'TERSEDIA',
    kondisi           VARCHAR(20)  NOT NULL DEFAULT 'BAIK',
    kapasitas         INTEGER,
    spesifikasi       VARCHAR(200),
    nomor_inventaris  VARCHAR(50),
    laboratorium      VARCHAR(100),
    tingkat_risiko    VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS peminjam (
    id    VARCHAR(30) PRIMARY KEY,
    nama  VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS peminjaman (
    id           VARCHAR(40) PRIMARY KEY,
    peminjam_id  VARCHAR(30) NOT NULL REFERENCES peminjam (id),
    aset_kode    VARCHAR(30) NOT NULL REFERENCES aset (kode),
    mulai        TIMESTAMP   NOT NULL,
    selesai      TIMESTAMP   NOT NULL,
    status       VARCHAR(20) NOT NULL DEFAULT 'DIAJUKAN',
    CHECK (selesai > mulai)
);
