package edu.project3.programFiles.output;

import java.util.Map;

public interface OutputGenerator {
    String FILE = "src/main/java/edu/project3/output/";

    <T> void generate(Map<T, T>... maps);
}
