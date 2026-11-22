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
        System.out.println("--- Songs List ---");
        SONGS.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("------------------");
    }
}