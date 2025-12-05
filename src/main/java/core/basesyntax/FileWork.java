package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        String text;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            text = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arr = text.split("\\W+");
        String[] res = {};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].startsWith("w")) {
                res = Arrays.copyOf(res, res.length + 1);
                res[res.length - 1] = arr[i].toLowerCase();
            }
        }
        Arrays.sort(res);
        return res;
    }
}
