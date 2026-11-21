import org.jline.reader.*;
import org.jline.reader.impl.*;
import org.jline.terminal.*;
import org.jline.terminal.impl.*;

public class OcarinaCLI
{
    public static void main(String[] args)
    {
        try {
            // Create a terminal
            Terminal terminal = TerminalBuilder.builder()
                    .system(true)
                    .build();

            // Create line reader
            LineReader reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();

            // Prompt and read input
            String line = reader.readLine("JLine > ");

            // Print the result
            System.out.println("You entered: " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}