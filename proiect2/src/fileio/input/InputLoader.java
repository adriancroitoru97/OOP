package fileio.input;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public final class InputLoader {

    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Reads data from json file (using Jackson) and loads it into
     * an Input object, which will be used for loading the database
     *
     * @return the Input object
     */
    public Input readData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(inputPath), Input.class);
        } catch (Exception e) {
            System.out.println("READ FROM JSON FAILED!");
        }

        return null;
    }
}
