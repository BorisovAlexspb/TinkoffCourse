package edu.hw6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task2 {
    private static String extension;
    private static final Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    public static void cloneFile(Path path) throws FileNotFoundException {
        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }

        extension =  "." + getExtensionByStringHandling(path.getFileName().toString()).get();
        int copyNumber = 1;
        Path copiedPath = generateCopyPath(path, copyNumber);

        while (Files.exists(copiedPath)) {
            copyNumber++;
            copiedPath = generateCopyPath(path, copyNumber);
        }

        try {
            Files.copy(path, copiedPath, StandardCopyOption.COPY_ATTRIBUTES);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static Path generateCopyPath(Path path, int copyNumber) {
        String fileName = path.getFileName().toString().replace(extension, "");
        String copySuffix = (copyNumber == 1) ? " — копия" : " — копия (" + copyNumber + ")";
        String newName = fileName + copySuffix + extension;
        return path.resolveSibling(newName);
    }

    private static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
            .filter(f -> f.contains("."))
            .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
