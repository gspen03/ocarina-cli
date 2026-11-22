// JLine Tools
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

// Data Structures
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
// import java.util.HashSet;

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

        System.out.println("Play notes (A/W/D/J/K). Press 'q' to quit or 'h' for help.");

        Set<Character> validNotes = Set.of('a', 'w', 'd', 'j', 'k');

        while(true)
        {
            char ch = (char)reader.read();
            char note = Character.toLowerCase(ch);

            if(note == 'q')
                break;

            if(note == 'h')
            {
                Songs.printSongs();
                continue;
            }

            if(!validNotes.contains(note))
                continue;

            System.out.print(note + " ");
            notes.offer(note);

            // No song has more than 8 notes
            if(notes.size() > 8)
                    notes.poll();

            if(notes.size() >= 5 && notes.size() <= 8)
            {
                StringBuilder seq = new StringBuilder();
                for(char c : notes)
                    seq.append(c);

                String match = Songs.getSong(seq.toString());
                if(match != null)
                {
                    System.out.println("You played " + match + "!");
                    notes.clear();
                }
            }
        }

        terminal.close();
    }
}