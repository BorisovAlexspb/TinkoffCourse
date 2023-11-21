package edu.project3.programFiles.receiver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PathFileReceiver implements Receiver {

    private final List<Path> paths;

    public PathFileReceiver(List<Path> paths) {
        this.paths = paths;
    }

    @Override
    public List<String> receive() {
        List<String> logInfos = new ArrayList<>();
        for (Path path : paths) {
            try {
                logInfos.addAll(Files.readAllLines(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return logInfos;
    }
}
