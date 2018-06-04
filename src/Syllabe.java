import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 */
public class Syllabe {

    private final static String[] KANAS =
        {
            "A", "I", "U", "E", "O",
            "Ka", "Ki", "Ku", "Ke", "Ko",
            "Sa", "Shi", "Su", "Se", "So",
            "Ta", "Chi", "Tsu", "Te", "To",
            "Na", "Ni", "Nu", "Ne", "No",
            "Ha", "Hi", "Fu", "He", "Ho",
            "Ma", "Mi", "Mu", "Me", "Mo",
            "Ya", "Yu", "Yo",
            "Ra", "Ri", "Ru", "Re", "Ro",
            "Wa", "Wi", "We", "Wo",
            "Ga", "Gi", "Gu", "Ge", "Go",
            "Za", "Ji", "Zu", "Ze", "Zo",
            "Da", "Di", "Dzu", "De", "Do",
            "Ba", "Bi", "Bu", "Be", "Bo",
            "Pa", "Pi", "Pu", "Pe", "Po",
            "N'",
            "Kya", "Kyu", "Kyo",
            "Sha", "Shu", "Sho",
            "Cha", "Chu", "Cho",
            "Nya", "Nyu", "Nyo",
            "Hya", "Hyu", "Hyo",
            "Mya", "Myu", "Myo",
            "Rya", "Ryu", "Ryo",
            "Gya", "Gyu", "Gyo",
            "Ja", "Ju", "Jo",
            "Dja", "Dju", "Djo",
            "Bya", "Byu", "Byo",
            "Pya", "Pyu", "Pyo"
        };

    private final static String[] CARACTERE_UNICODE =
        {
            "12354", "12356", "12358", "12360", "12362",
            "12363", "12365", "12367", "12369", "12371",
            "12373", "12375", "12377", "12379", "12381",
            "12383", "12385", "12388", "12390", "12392",
            "12394", "12395", "12396", "12397", "12398",
            "12399", "12402", "12405", "12408", "12411",
            "12414", "12415", "12416", "12417", "12418",
            "12420", "12422", "12424",
            "12425", "12426", "12427", "12428", "12429",
            "12431", "12432", "12433", "12434",
            "12364", "12366", "12368", "12370", "12372",
            "12374", "12376", "12378", "12380", "12382",
            "12384", "12386", "12389", "12391", "12393",
            "12400", "12403", "12406", "12409", "12412",
            "12401", "12404", "12407", "12410", "12413",
            "12435",
            "12365, 12419", "12365, 12421", "12365, 12423",
            "12375, 12419", "12375, 12421", "12375, 12423",
            "12385, 12419", "12385, 12421", "12385, 12423",
            "12395, 12419", "12395, 12421", "12395, 12423",
            "12402, 12419", "12402, 12421", "12402, 12423",
            "12415, 12419", "12415, 12421", "12415, 12423",
            "12426, 12419", "12426, 12421", "12426, 12423",
            "12366, 12419", "12366, 12421", "12366, 12423",
            "12376, 12419", "12376, 12421", "12376, 12423",
            "12386, 12419", "12386, 12421", "12386, 12423",
            "12403, 12419", "12403, 12421", "12403, 12423",
            "12404, 12419", "12404, 12421", "12404, 12423"
        };

    private String roomaji;
    private String hiragana;

    /**
     *
     * @param roomaji
     */
    public Syllabe(String roomaji, String hiragana) {
        this.roomaji = roomaji;
        this.hiragana = hiragana;
    }

    /**
     *
     * @return
     */
    private HashMap<String, String> mettreHashMap () {
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < KANAS.length; i++) {
            map.put(KANAS[i], CARACTERE_UNICODE[i]);
        }
        return map;
    }

    /**
     * Cette methode retourne le unicode selon le format exige par HTML
     * @return
     */
    public String getHiragana() {
        return hiragana;
    }

    public String toString() {
        String s = roomaji + " " + hiragana;
        return s;
    }
}
