/* Program Description:
Name: Caitlyn Smith
Course: CISS 111-300
Email: c-smith54@hvcc.edu

Program 13: Parsing Java Source Code for {,},(,),[,]
The program must be able to analyze if the file has:
1. A proper pairing of {}, [], ().
2. That the scopes are opened and closed in a LIFO (Last in First out) fashion.
3. Your program should display improper nesting to the console.
4. Your program should prompt for a file – do NOT hard code the file to be processed.
5. Show the processing of a file that is correct and a file that has improper scoping. */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Stack;

public class SmithCaitlyn_program13 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Please select a file to parse: ");
            String input = scan.nextLine();

            //Reading source file into string
            Path path = Path.of(input);
            String parsedFile = Files.readString(path);

            //If the parsed file is in scope or improperly scoped
            if (scope(parsedFile)) {
                System.out.println("Proper Scoping");
            } else {
                System.out.println("Improper Scoping");
            }

            scan.close();
        } catch (FileNotFoundException | NoSuchFileException e) {
            System.out.println("*File Not Found*");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean scope(String parsedFile) {
        //Using a stack because it uses a LIFO data structure
        Stack<Character> stack  = new Stack<>();

        for (char brace : parsedFile.toCharArray()) {
            //Find open braces, add to the stack
            if (brace == '{' || brace == '(' || brace == '[' ) {
                stack.push(brace);
            }
            //Find and match closed braces
            //If unmatched or stack is not empty, return false
            else if ((brace == '}' && stack.pop() != '{' && !stack.empty()) ||
                     (brace == ')' && stack.pop() != '(' && !stack.empty()) ||
                     (brace == ']' && stack.pop() != '[' && !stack.empty())) {
                return false;
            }
        }
        //If stack is empty, all braces have been matched, thus Proper Scoping
        //If stack is not empty, not all braces have been matched, thus Improper Scoping
        return stack.empty();
    }
}