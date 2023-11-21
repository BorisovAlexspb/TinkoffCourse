package edu.project3.programFiles.output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AdocOutputGenerator<T> implements OutputGenerator {
    private static final String TABLE_BORDER = "[options=\"header\"]\n|=====\n";
    private static final int SIZE_LIMIT = 3;

    @SuppressWarnings("checkstyle:MagicNumber")
    public <T> void generate(Map<T, T>... maps) {
        try (FileWriter writer = new FileWriter(FILE + "output.adoc")) {

            writer.write("==== Общая информация\n\n");
            writer.write(TABLE_BORDER);
            writer.write("| Метрика | Значение\n");
            writeTable(writer, maps[0]);

            writer.write("\n==== Запрашиваемые ресурсы\n\n");
            writer.write(TABLE_BORDER);
            writer.write("| Ресурс | Количество\n");
            writeTable(writer, maps[1]);

            writer.write("\n==== Коды ответа\n\n");
            writer.write(TABLE_BORDER);
            writer.write("| Код | Имя | Количество\n");
            writeTable(writer, maps[2]);

        } catch (IOException e) {
            throw new RuntimeException("IO exception in Adoc Generator@!");
        }
    }

    private static <T> void writeTable(FileWriter writer, Map<T, T> data) throws IOException {
        writer.write("|:" + "-:|".repeat(SIZE_LIMIT) + "\n");
        for (Map.Entry entry : data.entrySet()) {
            writer.write("| " + entry.getKey() + " | " + entry.getValue() + "\n");
        }
        writer.write("|=====\n");
    }
}
