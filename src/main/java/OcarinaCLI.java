// JLine Toolse
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

// Data Structures
import java.util.Map;
import java.util.ArrayDeque;
import java.util.Queue;

public class OcarinaCLI
{
    public static void main(String[] args) throws Exception
    {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        // Respond without hitting "enter"
        terminal.enterRawMode();

        NonBlockingReader reader = terminal.reader();
        Queue<Character> notes = new ArrayDeque<>();


    }
}