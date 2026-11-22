import java.util.Map;

/*
    Button mapping reference (Switch 2 -> Keyboard):
        (y, x, a) -> (a, w, d)
        (l, r)    -> (j, k)
 */

public class Songs
{
    private static final Map<String, String> SONGS = Map.ofEntries(
            Map.entry("awdawd", "Zelda's Lullaby"),
            Map.entry("wadwad", "Epona's Song"),
            Map.entry("kdakda", "Saria's Song"),
            Map.entry("dkwdkw", "Sun's Song"),
            Map.entry("djkdjk", "Song of Time"),
            Map.entry("jkwjkw", "Song of Storms"),
            Map.entry("jwakwa", "Minuet of the Forest"),
            Map.entry("wdwdaw", "Prelude of Light"),
            Map.entry("kjkjdkdk", "Bolero of Fire"),
            Map.entry("jkdda", "Serenade of Water"),
            Map.entry("addjadk", "Nocturne of Shadow"),
            Map.entry("jkjdkj", "Requiem of Spirit")
    );

    public static String getSong(String sequence)
    {
        return SONGS.get(sequence);
    }

    public static void printSongs()
    {
        System.out.println();
        System.out.println("=== Songs List ===");
        System.out.println("Zelda's Lullaby: A-W-D-A-W-D");
        System.out.println("Epona's Song: W-A-D-W-A-D");
        System.out.println("Saria's Song: K-D-A-K-D-A");
        System.out.println("Sun's Song: D-K-W-D-K-W");
        System.out.println("Song of Time: D-J-K-D-J-K");
        System.out.println("Song of Storms: J-K-W-J-K-W");
        System.out.println("Minuet of the Forest: J-W-A-K-W-A");
        System.out.println("Prelude of Light: W-D-W-D-A-W");
        System.out.println("Bolero of Fire: K-J-K-J-D-K-D-K");
        System.out.println("Serenade of Water: J-K-D-D-A");
        System.out.println("Nocturne of Shadow: A-D-D-J-A-D-K");
        System.out.println("Requiem of Spirit: J-K-J-D-K-J");
        System.out.println();

        System.out.println("==== Notes ====");
        System.out.println("---(W)---------");
        System.out.println("               ");
        System.out.println("-(A)-----------");
        System.out.println("      (D)      ");
        System.out.println("---------------");
        System.out.println("           (R) ");
        System.out.println("--------(L)----");
        System.out.println("===============");
    }
}