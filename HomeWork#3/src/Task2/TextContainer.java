package Task2;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "/Users/maryklymenko/IdeaProjects/HomeWork#3/src/Task2/NewFile")
public class TextContainer {

    String text = "The Java language has undergone several changes since JDK 1.0 as well as numerous additions of " +
            "classes and packages to the standard library. " +
            "Since J2SE 1.4, the evolution of the Java language has been governed by the Java Community Process (JCP), " +
            "which uses Java Specification Requests (JSRs) to propose and specify additions and changes to the Java " +
            "platform. The language is specified by the Java Language Specification (JLS); changes to the JLS are " +
            "managed under JSR 901";

    @Saver
    public void save(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(text);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

