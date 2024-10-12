package ru.nsu.zarcer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Finder class overall.
 */
public class Finder {

    /**Find substring in string, returns list of indexes.
     *
     * @param readerr reader stream, goes through shell methods
     *
     * @param subName substring
     *
     * @return list of indexes
     *
     * @throws IOException throws exception without catching
     *
     */
    private static ArrayList<Integer> find(Reader readerr, String subName) throws IOException {
        int length = subName.length();
        ArrayList<Integer> output = new ArrayList<>();
        char[] buffer = new char[length];
        int charRead;
        if ((charRead = readerr.read(buffer)) != -1) {
            int indexRead = charRead - 1;
            String temp = new String(buffer);
            while (true) {
                if (temp.indexOf(subName) != -1) {
                    output.add(indexRead - length + 1);
                }
                charRead = readerr.read();
                indexRead++;
                if (charRead == -1) {
                    break;
                }
                buffer[length - 1] = (char) charRead;
                temp = temp.substring(1) + buffer[length - 1];
            }
        }
        return output;
    }

    /**Shell method for find, uses files.
     *
     * @param fileName name of file
     *
     * @param subName substring
     *
     * @return list of indexes
     *
     * @throws IOException rethrow exception
     *
     */
    public static ArrayList<Integer> findFile(String fileName, String subName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName
                , StandardCharsets.UTF_8))) {
            return find(br, subName);
        } catch (IOException e) {
            throw e;
        }
    }

    /**Shell method for find using resources.
     *
     * @param fileName name of file
     *
     * @param subName substring
     *
     * @return list of indexes
     *
     * @throws IOException rethrow exception
     *
     */
    public static ArrayList<Integer> findRecourse(String fileName, String subName) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (Finder.class.getResourceAsStream("/" + fileName)
                        , StandardCharsets.UTF_8))) {
            return find(br, subName);
        } catch (IOException e) {
            throw e;
        }
    }
}