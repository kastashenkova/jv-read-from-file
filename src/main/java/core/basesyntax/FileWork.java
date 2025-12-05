package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public String[] readFromFile(String fileName) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String text = null;
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] arr = text.split("\\W+");
        String[] res = {};
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].toLowerCase().compareTo(arr[i - 1].toLowerCase()) < 0) {
                res = Arrays.copyOf(res, res.length + 2);
                res[res.length - 2] = arr[i].toLowerCase();
                res[res.length - 1] = arr[i - 1].toLowerCase();
            }
        }
        Arrays.sort(res);
        return res;
    }
}
