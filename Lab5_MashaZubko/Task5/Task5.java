package m;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Task5 {
    public static void main(String args[]) throws FileNotFoundException {
        try{
            Scanner scan1 = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            System.out.print("Input your choose:\n" +
                             "1 - for input sentences in console.\n" +
                             "2 - for export txt file.\n" +
                             "\nYour input: ");
            int number = scan1.nextInt();
            
            String path = null;
            if (number == 1) {
                System.out.print("Input sentence: ");
                
                path = "/Users/masha/Desktop/Task5.txt";
                
                try (FileWriter writer = new FileWriter(path, false)) {
                    while (true) {
                        String s = scan.nextLine();
                        writer.write(s + "\n");
                        writer.flush();
                        if (s.contains("BREAK_PROGRAM")) {
                            break;
                        }
                    }
                } catch (IOException ex) {
                    
                    System.out.println(ex.getMessage());
                }
            } else if (number == 2) {
                System.out.println("Input path to file");
                path = scan.nextLine();
            }
            
            String i = "";
            
            Scanner in = new Scanner(new File(path));
            while (in.hasNext())
                i += in.nextLine() + " ";
            in.close();
            
            i = i.replace("BREAK_PROGRAM", "");
            i = i.toLowerCase();
            i = i.replaceAll("[0-9]|\\p{Punct}|[»]|[«]|[«]|\n|\r|[•]|\\s+}", "");
            String text2[] = Func(i);
            
            Map<String, String> dictionary = new HashMap<String, String>();
            
            int j = 10;
            for (char k = 'a'; k <= 'z'; k++) {
                j += 1;
                dictionary.put(Character.toString(k), Integer.toString(j) + "_");
            }
            for (char k = 'а'; k <= 'г'; k++) {
                j += 1;
                dictionary.put(Character.toString(k), Integer.toString(j) + "_");
            }
            
            j += 1;
            dictionary.put("ґ", Integer.toString(j) + "_");
            
            for (char k = 'д'; k <= 'е'; k++) {
                j += 1;
                dictionary.put(Character.toString(k), Integer.toString(j) + "_");
            }
            
            j += 1;
            dictionary.put("ё", Integer.toString(j) + "_");
            
            j += 1;
            dictionary.put("є", Integer.toString(j) + "_");
            
            for (char k = 'ж'; k <= 'и'; k++) {
                j += 1;
                dictionary.put(Character.toString(k), Integer.toString(j) + "_");
            }
            
            j += 1;
            dictionary.put("і", Integer.toString(j) + "_");
            j += 1;
            dictionary.put("ї", Integer.toString(j) + "_");
            
            for (char k = 'й'; k <= 'я'; k++) {
                j += 1;
                dictionary.put(Character.toString(k), Integer.toString(j) + "_");
            }
            
            ArrayList<ArrayList<String>> code_text = new ArrayList<ArrayList<String>>();
            
            for (String w : text2) {
                ArrayList<String> words = new ArrayList<String>();
                code_text.add(words);
                for (String w1 : w.split("")) {
                    if (dictionary.containsKey(w1)) {
                        String value = dictionary.get(w1);
                        words.add(value);
                    }
                }
            }
            
            ArrayList<String> com_words = new ArrayList<String>();
            
            for (ArrayList<String> array : code_text) {
                com_words.add(Arrays.toString(array.toArray()).replaceAll("\\[|\\]|,|\\s", ""));
            }
            
            Collections.sort(com_words);
            
            Map<String, String> replace_dict = new HashMap<String, String>();
            
            dictionary.forEach((k, v) -> {
                replace_dict.put(v, k);
            });
            
            ArrayList<ArrayList<String>> translate_words = new ArrayList<ArrayList<String>>();
            
            for (String w2 : com_words) {
                ArrayList<String> translate_word = new ArrayList<String>();
                translate_words.add(translate_word);
                for (String w3 : w2.split("_")) {
                    if (replace_dict.containsKey(w3 + "_")) {
                        String value = replace_dict.get(w3 + "_");
                        translate_word.add(value);
                    }
                }
                
            }
            
            ArrayList<String> last_text = new ArrayList<String>();
            
            for (ArrayList<String> array : translate_words) {
                last_text.add(Arrays.toString(array.toArray()).replaceAll("\\[|\\]|,|\\s", ""));
            }
            
            for (String w : last_text) {
                if (w.equals("")) {
                    continue;
                } else {
                    System.out.println(w);
                }
            }
            String file_sort = "/Users/masha/Desktop/Task5.txt";
            
            try (FileWriter writer = new FileWriter(file_sort, false)) {
                for (String w : last_text) {
                    if (w.equals("")) {
                        continue;
                    } else {
                        writer.write(w + "\n");
                        writer.flush();
                    }
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(java.util.InputMismatchException e){
            System.out.print("You must input int numbers!");
        }
        catch (NullPointerException e) {
            System.out.println("Incorrect input!");
        }
    }
    private static String[] Func (String s){
        return s.split(" ");
    }
}
