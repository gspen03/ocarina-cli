// JLine Tools
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

// Data Structures
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
// import java.util.HashSet;

// Database
import db.DatabaseManager;

public class OcarinaCLI
{
    public static void main(String[] args) throws Exception
    {
        try(DatabaseManager db = new DatabaseManager();
            Terminal terminal = TerminalBuilder.builder()
                    .system(true)
                    .build())
        {
            // Respond without hitting "enter"
            terminal.enterRawMode();

            NonBlockingReader reader = terminal.reader();
            Deque<Character> notes = new ArrayDeque<>();

            System.out.println("Play notes (A/W/D/J/K). Press 'q' to quit or 'h' for help.");

            Set<Character> validNotes = Set.of('a', 'w', 'd', 'j', 'k');

            // flag for displaying "listening"
            boolean hasPrompted = false;

            while (true) {

                if(!hasPrompted)
                {
                    System.out.print("Listening: ");
                    hasPrompted = true;
                }


                char ch = (char) reader.read();
                char note = Character.toLowerCase(ch);

                if (note == 'q')
                    break;

                if (note == 'h') {
                    db.printSongs();
                    continue;
                }

                if (!validNotes.contains(note))
                    continue;

                System.out.print(note + " ");
                notes.addFirst(note);

                // No song has more than 8 notes
                if (notes.size() > 8)
                    notes.removeLast();

                StringBuilder seq = new StringBuilder();
                for (char c : notes) {
                    seq.insert(0, c);
                    String match = db.getSong(seq.toString());

                    if (match != null) {
                        System.out.println("\nYou played: " + match + "!");
                        notes.clear();
                        hasPrompted = false;
                        break;
                    }
                }
            }
        }
        // terminal.close();
    }
}