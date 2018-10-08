//1.......2.........3.........4.........5.........6.........7.........8
/**
 * This class calls text analyser which contains the rest of the code
 * @author (Subhrajyoti Mondal)
 * this class therefore has only one method which is the main
 */

public class TextDriver{
    public static void main(){
        //the below code would allow you to change the name
        //of the file anytime, wihout disturbing the rest of the code
        TextAnalyser analyser = new TextAnalyser("SampleEssay.txt");
        analyser.analyse();
        
    }
}
