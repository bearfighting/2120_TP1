import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 */
public class Principal {
    final static String MSG_SOL_FIC_LIRE = "Veuillez entrez le nom et le routier de fichier a lire : ";
    final static String MSG_SOL_FIC_ECRIRE = "Veuillez entrez le nom et le routier de fichier a ecrire : ";
    final static String[] CARACTERE_VOYELLE = {"A", "E", "U", "I", "O", "n'"};
    final static String[] KANAS =
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

    final static String[] CARACTERE_UNICODE =
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

    final static HashMap<String, String> mettreHashMap(String[] cle, String[] objet) {
        HashMap<String, String> map = new HashMap();
        for (int i = 0; i < cle.length; i++) {
            map.put(cle[i].toLowerCase(), objet[i]);
        }
        return map;
    }

    final static String obtenirHiragana(String roomaji) throws SyllabeNonExisteeException {
        HashMap<String, String> map;
        map = mettreHashMap(KANAS, CARACTERE_UNICODE);
        if (!map.containsKey(roomaji)) {
            throw new SyllabeNonExisteeException("Le syllabe n'existe pas dans le japonais.");
        }
        String unicode = map.get(roomaji);
        return unicode;
    }

    /**
     * @param sol
     * @return
     */
    public static String lireNomFichier(String sol) {
        String nomFichier = "";
        System.out.print(sol);
        Scanner entree = new Scanner(System.in);
        if (entree.hasNextLine()) {
            nomFichier = entree.nextLine();
            //System.out.println(nomFichier);
        }
        return nomFichier;
    }

    /**
     * @param nomFichierLire
     * @return
     * @throws IOException
     */
    private static String lireFichier(String nomFichierLire) throws IOException {
        String stringEntree = "";
        FileInputStream entree;

        entree = new FileInputStream(nomFichierLire);

        byte[] volume = new byte[entree.available()];
        entree.read(volume);
        stringEntree = new String(volume);
        entree.close();

        return stringEntree;
    }

    /**
     * @param contenuEntree
     * @return
     */
    public static String traiterStringEntree(String contenuEntree) {
        contenuEntree = contenuEntree.replace(" ", "");
        for (int i = 0; i < CARACTERE_VOYELLE.length; i++) {
            contenuEntree = contenuEntree.replace(CARACTERE_VOYELLE[i].toLowerCase(), CARACTERE_VOYELLE[i].toLowerCase() + ",");
        }

        return contenuEntree;
    }

    public static void formerParagraphe(ParagrapheOrdreJaponais paragraphe, String[] phrasesChainnees)
        throws SyllabeNonExisteeException{

        for (int i = 0; i < phrasesChainnees.length; i++) {
            String[] syls = phrasesChainnees[i].split(",");
            PhraseOrdreJaponais phrase = new PhraseOrdreJaponais();

            formerPhrase(phrase, syls);
            paragraphe.setParagraphe(phrase);
        }
    }

    public static void formerPhrase(PhraseOrdreJaponais phrase, String[] syls) throws SyllabeNonExisteeException {
        for (int j = 0; j < syls.length; j++) {
            if (syls[j] != null) {
                String hira = "";

                hira = obtenirHiragana(syls[j]);

                Syllabe syl = new Syllabe(syls[j], hira);
                phrase.setPhrase(syl);
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String nomFichierLire = "";
        String contenuEntree = "";
        String nomFichierEcrire = "";
        String sortieHtml = "";
        FileWriter fichierEcrire;
        ParagrapheOrdreJaponais paragraphe = new ParagrapheOrdreJaponais();
        try {
            nomFichierLire = lireNomFichier(MSG_SOL_FIC_LIRE);
            contenuEntree = traiterStringEntree(lireFichier(nomFichierLire));
            String[] phrasesChainnees = contenuEntree.split("\n");
            formerParagraphe(paragraphe, phrasesChainnees);
            sortieHtml = paragraphe.imprimerHTML();
            System.out.println(sortieHtml);
            nomFichierEcrire = lireNomFichier(MSG_SOL_FIC_ECRIRE);
            fichierEcrire = new FileWriter(nomFichierEcrire);
            fichierEcrire.write(sortieHtml);
            fichierEcrire.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        } catch (SyllabeNonExisteeException e) {
            System.out.println( "I y a le syllabe qui n'existe pas dans le Japonais." );
        } catch (IOException e) {
            System.err.println( e.getMessage() );
        }
    }
}
