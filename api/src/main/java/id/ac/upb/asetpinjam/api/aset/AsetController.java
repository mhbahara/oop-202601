package id.ac.upb.asetpinjam.api.aset;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Minggu 12. Kontrak HTTP:
 * POST   /api/aset         -> 201 + AsetResponse
 * GET    /api/aset         -> 200 + daftar AsetResponse
 * GET    /api/aset/{kode}  -> 200 + AsetResponse, atau 404
 * DELETE /api/aset/{kode}  -> 204, atau 404
 * Controller TIDAK berisi logika bisnis; panggil AsetService.
 */
@RestController
@RequestMapping("/api/aset")
public class AsetController {

    private final AsetService service;

    public AsetController(AsetService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AsetResponse> buat(@RequestBody AsetRequest permintaan) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetController.buat");
    }

    @GetMapping
    public List<AsetResponse> semua() {
        throw new UnsupportedOperationException("TODO minggu 12: AsetController.semua");
    }

    @GetMapping("/{kode}")
    public AsetResponse cari(@PathVariable String kode) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetController.cari");
    }

    @DeleteMapping("/{kode}")
    public ResponseEntity<Void> hapus(@PathVariable String kode) {
        throw new UnsupportedOperationException("TODO minggu 12: AsetController.hapus");
    }
}
