package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {
    final Path filePath = Path.of("src/test/java/edu/hw6/task4/file.txt");

    @BeforeEach
    void createFile() {
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void deleteFile() throws IOException {
        Files.deleteIfExists(filePath);
    }

    @Test
    @DisplayName("Проверка записи сообщения в файл")
    void testWriteToFile() throws IOException {
        // Arrange
        String expectedMessage = "Programming is learned by writing programs. ― Brian Kernighan";

        // Act
        Task4.writeToFile(filePath, expectedMessage);
        String actualMessage = Files.readAllLines(filePath).get(0);

        // Assert
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
