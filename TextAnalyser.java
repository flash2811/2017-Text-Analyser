//1.......2.........3.........4.........5.........6.........7.........8
import java.util.*;
import java.io.*;
/**
 * This program reads a txt file which has an essay
 * it then does multiple statistics
 * such as finding the number of words, how 'the' and 'and' was used
 * the following features were used
 * methods, loops, nested loops, branching, file i/o, 2 classes
 * 1d arrays, acess modifiers(overloaded constructor)
 * it also uses arraylists
 * @author (Subhrajyoti Mondal)
 */
public class TextAnalyser{
    private List<String> _lines = 
        new ArrayList<String>();
    private String _fileName;

    /**
     * overloaded constructor
     */
    public TextAnalyser(String fileName){
        _fileName = fileName;
    }

    /**
     * prints all the results of the statistics
     */
    public void analyse(){
        readFile(_fileName);
        System.out.println("Number of Sentences: " 
            + (countSymbols(".") + countSymbols("?")));
        System.out.println("Number of Words: "
            + totalWords());
        System.out.println("Number of Charecters: " 
            + countChars());
        System.out.println("Number of Times 'the' Used: " 
            + countWord("the"));
        System.out.println("Number of Times 'and' Used: "
            + countWord("and"));
    }

    /**
     * reads in the file using bufferedreader
     * and stores it into a arraylist
     */    
    private void readFile(String fileName){
        BufferedReader br = null;
        //String [] word = null;
        int i = 0;
        String s = "";
        //my computer as the file was large and the OS is 64bit
        //so I used buffered reader
        //I found this from the below link
        //https://stackoverflow.com/questions/19813760/
        //scanner-reading-large-file
        try {
            br = 
            new BufferedReader(new FileReader(fileName));
            while ((s = br.readLine())!= null) {
                //this loops until there is not next line
                _lines.add(s);
                i++;
            }
        } 
        catch (IOException  e) {
            e.printStackTrace();  
        }
    }

    /**
     * the method checks how many words are present in the text file 
     */
    private int totalWords(){
        int wordCount = 0;
        for (int i = 0; i < _lines.size(); i++) {
            String line = _lines.get(i);
            String arraySplitter[]= line.trim().split(" ");
            wordCount += arraySplitter.length; 
        }
        return wordCount;
    }

    /**
     * this method checks for a specific word
     * and sees how many times the said word can be found in the essay
     */
    private int countWord(String word){
        int count = 0;
        for (int i = 0; i < _lines.size(); i++) {
            String line = _lines.get(i);
            String arraySplitter[]= line.trim().split(" ");
            for(int j = 0; j < arraySplitter.length; j++){
                //toLowerCase allows me to check for 
                //all forms of 'the'
                if(arraySplitter[j].toLowerCase().
                equals(word.toLowerCase())){
                    count++;
                }
            }
        }       
        return count;
    }

    /**
     * this method checks how many sentences the essay  has
     * this is doone by checking how many . are present in the essay
     */
    private int countSymbols(String symbol){
        int count = 0;
        for(int i = 0; i < _lines.size(); i++){
            String line = _lines.get(i);
            for(int j = 0; j < line.length(); j++){
                if(line.substring(j,j+1).equals(symbol)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * this method just counts the number of characters in the essay
     * this is done by checking the length of each line
     * found from the text file
     */
    public int countChars(){
        int count = 0;
        for(int i = 0; i < _lines.size(); i++){
            String line = _lines.get(i);
            count += line.length();
        }
        return count;
    }
}