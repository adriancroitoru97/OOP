package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import common.Constants;
import database.Child;
import database.Database;
import fileio.input.Input;
import fileio.input.InputLoader;
import fileio.output.ChildSerializer;
import fileio.output.Writer;
import simulator.Simulator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public final class Tests {

    private Tests() {
    }

    /**
     * Takes every test file and calls the `action` method for each one.
     */
    public static void runAll() throws IOException {
        File directory = new File(Constants.TESTS_PATH);
        Path path = Paths.get(Constants.RESULT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        File outputDirectory = new File(Constants.RESULT_PATH);
        if (outputDirectory.listFiles() != null) {
            for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
                if (!file.delete()) {
                    System.out.println("DELETE FAILED!");
                }
            }
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String testNumber = file.getName().substring(Constants.TEST_STRING_LENGTH);
            String filepath = Constants.OUTPUT_PATH + testNumber;
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }
    }

    /**
     * Read the json input file and loads the data in an Input object
     * This object is provided as a parameter for the database and the simulator,
     * which will simulate the flow of the program. The result (the writer object)
     * is written in a json file (using Jackson).
     *
     * @param filePath1 the input file
     * @param filePath2 the output file
     */
    public static void action(final String filePath1,
                              final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        Input input = inputLoader.readData();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(Child.class, new ChildSerializer());
        objectMapper.registerModule(module);

        Writer writer = new Writer();

        if (input != null) {
            Database database = Database.getDatabase();
            database.setDatabase(input);

            Simulator simulator = Simulator.getSimulator();
            simulator.setSimulator(database, input, writer, objectMapper);
            simulator.run();

            objectMapper.writeValue(new File(filePath2), writer);
        }
    }
}
