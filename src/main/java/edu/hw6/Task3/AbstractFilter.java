package edu.hw6.Task3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path entry) throws FileNotFoundException;

    default AbstractFilter and(AbstractFilter additionalFilter) {
        return entry -> this.accept(entry) && additionalFilter.accept(entry);
    }

    static AbstractFilter largerThan(long size) {
        return entry -> {
            try {
                return Files.size(entry) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter magicNumber(int... magicBytes) {
        return entry -> {
            try (FileInputStream inputStream = new FileInputStream(String.valueOf(entry))) {
                for (int b : magicBytes) {
                    if (inputStream.available() == 0) {
                        return false;
                    }

                    if (inputStream.read() != b) {
                        return false;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("error while check magic number");
            }
            return true;
        };
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> {
            PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
            return pathMatcher.matches(entry.getFileName());
        };
    }

    static AbstractFilter regexContains(String regex) {
        return entry -> Pattern.compile(regex).matcher(entry.getFileName().toString()).find();
    }
}
