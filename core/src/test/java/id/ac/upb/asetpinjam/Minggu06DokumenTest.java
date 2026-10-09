package id.ac.upb.asetpinjam;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Minggu 6 tidak menguji kode, tetapi memastikan hasil kerja ada. Isi dan kualitas diagram
 * dinilai dengan rubrik (docs/minggu-06.md), bukan oleh tes ini.
 */
@Tag("week6")
class Minggu06DokumenTest {

    private static final Path UML = Path.of("..", "docs", "uml");
    private static final List<String> EKSTENSI = List.of(".png", ".svg", ".puml", ".drawio", ".mmd", ".md");

    @Test
    void classDiagramAda() throws IOException {
        assertThat(adaBerkas("class")).as("berkas bernama class* di docs/uml").isTrue();
    }

    @Test
    void sequenceDiagramAda() throws IOException {
        assertThat(adaBerkas("sequence")).as("berkas bernama sequence* di docs/uml").isTrue();
    }

    @Test
    void catatanSolidAda() throws IOException {
        Path laporan = Path.of("..", "docs", "uml", "solid.md");
        assertThat(laporan).as("docs/uml/solid.md").exists();
        assertThat(Files.readString(laporan).length()).as("solid.md minimal 300 karakter").isGreaterThan(300);
    }

    private boolean adaBerkas(String awalan) throws IOException {
        if (!Files.isDirectory(UML)) {
            return false;
        }
        try (Stream<Path> s = Files.list(UML)) {
            return s.map(p -> p.getFileName().toString().toLowerCase())
                    .anyMatch(n -> n.startsWith(awalan) && EKSTENSI.stream().anyMatch(n::endsWith));
        }
    }
}
