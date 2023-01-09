/*This is the test file for proper nesting.*/

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ProperNestingClass {
    public void properNesting() {
        try {
            String parsedFile = null;
            FileReader reader = new FileReader(parsedFile);
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] stringArray = new String[] {"a","b","c"};
    }
}