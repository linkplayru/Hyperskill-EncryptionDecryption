package utils;

import enums.Algorithm;
import enums.Mode;
import enums.Out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Arguments {

    public static Arguments read(String[] args) {
        //get arguments in arrayList
        ArrayList<String> argsList = new ArrayList<>();
        for (int i=0; i<args.length; i++) {
            argsList.add(args[i]);
        }
        //defaults
        Mode mode = Mode.ENCODE;
        Algorithm algorithm = Algorithm.SHIFT;
        int key = 0;
        String data = "";
        Out out = Out.CONSOLE;
        File file = null;
        //mode
        if (argsList.contains("-mode") && argsList.get(argsList.indexOf("-mode")+1).equals("dec")) {
            mode = Mode.DECODE;
        }
        //algorithm
        if (argsList.contains("-alg") && argsList.get(argsList.indexOf("-alg")+1).equals("unicode")) {
            algorithm = Algorithm.UNICODE;
        }
        //key
        if (argsList.contains("-key")) {
            try {
                key = Integer.parseInt(argsList.get(argsList.indexOf("-key") + 1));
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
        }
        //data
        if (argsList.contains("-data")) {
            data = argsList.get(argsList.indexOf("-data")+1);
        } else if (argsList.contains("-in")) {
            try (Scanner s = new Scanner(new File(argsList.get(argsList.indexOf("-in")+1)))) {
                data = s.nextLine();
            } catch (FileNotFoundException e) {
                System.out.println("Error");
            }
        }
        //out
        if (argsList.contains("-out")) {
            out = Out.FILE;
            file = new File(argsList.get(argsList.indexOf("-out")+1));
        }
        return new Arguments(mode, algorithm, key, data, out, file);
    }

    private Mode mode;
    private Algorithm algorithm;
    private int key;
    private String data;
    private Out out;
    private File file;

    private Arguments(Mode mode, Algorithm algorithm, int key, String data, Out out, File file) {
        this.mode = mode;
        this.algorithm = algorithm;
        this.key = key;
        this.data = data;
        this.out = out;
        this.file = file;
    }

    public Mode getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public Out getOut() {
        return out;
    }

    public File getFile() {
        return file;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

}