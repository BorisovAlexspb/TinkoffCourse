package edu.project3.HttpReceiver;

import edu.project3.programFiles.receiver.HtttpReceiver;
import edu.project3.programFiles.receiver.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HttpReceiverTest {
    private static final String HTTP =
        "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs";

    @Test
    @DisplayName("HTTP receive logs test")
    public void receive_shouldReturnListOfStringsFromHttp() {
        Receiver receiver = new HtttpReceiver(HTTP);
        assertThat(receiver.receive().size()).isEqualTo(51462);
    }
}
