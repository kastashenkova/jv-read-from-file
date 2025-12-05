package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (text.length() == 0) {
            return new String[0];
        }
        String[] arr = text.toString().split("\\W+");
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
