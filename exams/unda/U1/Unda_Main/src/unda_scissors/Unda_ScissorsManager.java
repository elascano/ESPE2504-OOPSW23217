package unda_scissors;

import java.io.*;
import java.util.ArrayList;

public class Unda_ScissorsManager {
    private ArrayList<Unda_Scissors> scissorsList = new ArrayList<>();
    private final String filePath = "data/scissors.csv";

    public void addScissors(Unda_Scissors s) {
        scissorsList.add(s);
    }

    public void saveToCSV() throws IOException {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }

        FileWriter writer = new FileWriter(filePath);
        for (Unda_Scissors s : scissorsList) {
            writer.write(s.toCSV() + "\n");
        }
        writer.close();
    }

    public void loadFromCSV() throws IOException {
        scissorsList.clear();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            scissorsList.add(Unda_Scissors.fromCSV(line));
        }
        reader.close();
    }

    public void showAll() {
        for (Unda_Scissors s : scissorsList) {
            System.out.println(s);
        }
    }
}
