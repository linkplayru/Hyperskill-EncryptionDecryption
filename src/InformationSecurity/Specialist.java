package InformationSecurity;


import algorithms.Algorithm;
import enums.Out;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Specialist {

    private Algorithm algorithm;
    private String data;
    private Out out;
    private File file;

    public Specialist(Algorithm algorithm, String data, Out out, File file) {
        this.algorithm = algorithm;
        this.data = data;
        this.out = out;
        this.file = file;
    }

    public void doWork() {
        String result = algorithm.process(data);
        if (out == Out.CONSOLE) {
            System.out.println(result);
        } else {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(result);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

}
