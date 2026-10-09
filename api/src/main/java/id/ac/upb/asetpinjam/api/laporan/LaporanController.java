package id.ac.upb.asetpinjam.api.laporan;

import id.ac.upb.asetpinjam.api.aset.AsetRepository;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Minggu 13: laporan memakai stream. */
@RestController
@RequestMapping("/api/laporan")
public class LaporanController {

    private final AsetRepository repository;

    public LaporanController(AsetRepository repository) {
        this.repository = repository;
    }

    /**
     * TODO minggu 13: jumlah aset per jenis, mis. {"RUANG":2,"LAPTOP":1}. Jenis yang belum punya aset
     * boleh tidak muncul. Gunakan stream dengan Collectors.groupingBy dan counting.
     */
    @GetMapping("/aset-per-jenis")
    public Map<String, Long> asetPerJenis() {
        throw new UnsupportedOperationException("TODO minggu 13: LaporanController.asetPerJenis");
    }
}
