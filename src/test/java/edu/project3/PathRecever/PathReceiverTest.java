package edu.project3.PathRecever;

import edu.project3.programFiles.receiver.PathFileReceiver;
import edu.project3.programFiles.receiver.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static edu.project3.programFiles.parser.PathParser.getPaths;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PathReceiverTest {
    private final Path wrongPath = Path.of("src/main/resources/project3/log55.txt");
    @Test
    @DisplayName("Path receive logs test")
    public void receive_shouldReturnListOfStringsFromPathsToFiles() {
        Receiver receiver = new PathFileReceiver(getPaths("src/main/resources/project3/**"));
        assertThat(receiver.receive().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("Path receive logs with wrong path test")
    public void receive_shouldThrowException_whenPathIsWrong() {
        Receiver receiver = new PathFileReceiver(List.of(wrongPath));
        assertThatThrownBy(receiver::receive).isInstanceOf(RuntimeException.class);
    }
}
