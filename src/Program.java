import java.io.*;
import java.util.*;

public class Program {
    static Scanner reader = null;
    static PrintWriter writer = null;

    public static void main(String[] args) {
        try {
            reader = new Scanner(new File("C:\\Users\\Anastasia\\Documents\\Fall2018\\Compilers\\Assignment1_version2\\input.txt"));
            if (reader == null) {
                throw new IOException();
            }
            writer = new PrintWriter("C:\\Users\\Anastasia\\Documents\\Fall2018\\Compilers\\Assignment1_version2\\output.txt");
            if (writer == null) {
                throw new IOException();
            }

            while (reader.hasNextLine()) {
                Parser parser = new Parser(reader.nextLine());
                Expression expressionTree = parser.parse();
                writer.print(Long.toString(expressionTree.calculate())+'\n');
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
