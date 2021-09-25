package FileActions;

import Entities.Card;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    private String filename = "src/res/dataBase.txt";
    private String content = "";

    public void fileOutput(List<Card> cardList) throws IOException {
        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        for (Card card : cardList) {
            content += card.toString();
        }

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(content);
        content = "";
        fileWriter.close();
    }

    public List<String> fileInput() {
        List<String> contents = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            content = bufferedReader.readLine();
            while (content != null) {
                contents.add(content);
                content = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return contents;
    }
}
