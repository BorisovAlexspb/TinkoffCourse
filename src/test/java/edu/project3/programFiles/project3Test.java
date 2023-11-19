package edu.project3.programFiles;

import edu.project3.programFiles.parser.WebLogParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

class project3Test {
    @Test
    void parseOptionalArgumentDateFromTest() {
        var expect = LocalDate.of(2023, 8, 31);
        var res = WebLogParser.parseOptionalArgumentDateFrom("2023-08-31");
        Assertions.assertThat(res).isEqualTo(expect);
    }

    @Test
    void parseOptionalArgumentDateToTest() {
        var expect = LocalDate.of(2023, 8, 31);
        var res = WebLogParser.parseOptionalArgumentDateTo("2023-08-31");
        Assertions.assertThat(res).isEqualTo(expect);
    }

    @Test
    void parseEntryTest() {
        var res = WebLogParser.parseEntry(
            "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0");
        Assertions.assertThat(res.getIpAddress()).isEqualTo("93.180.71.3");
        Assertions.assertThat(res.getAccessTime()).isEqualTo(LocalDateTime.of(2015, 5, 17, 8, 5, 32));
        Assertions.assertThat(res.getRequest()).isEqualTo("GET /downloads/product_1 HTTP/1.1");
        Assertions.assertThat(res.getStatusCode()).isEqualTo(304);
        Assertions.assertThat(res.getBytesReturned()).isEqualTo(0);

    }
}
