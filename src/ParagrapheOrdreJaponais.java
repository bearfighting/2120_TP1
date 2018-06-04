import java.util.ArrayList;

public class ParagrapheOrdreJaponais implements HTMLImprime {

    private ArrayList<PhraseOrdreJaponais> paragraphe ;

    public ParagrapheOrdreJaponais() {
        this.paragraphe = new ArrayList<>();
    }

    public void setParagraphe(PhraseOrdreJaponais phrase) {
        this.paragraphe.add(0, phrase);
    }

    public String imprimerHTML() {
        String sortie = HTMLImprime.TEXTE_HTML_DEBUT + obtenirTableSortie() + HTMLImprime.TEXTE_HTML_FIN;
        return sortie;
    }

    private int obtenirLongeurMaxPhrase() {
        int longeurMax = 0;
        for (int i = 0; i < paragraphe.size(); i++) {
            if (paragraphe.get(i).obtenirLongeurPhrase() > longeurMax) {
                longeurMax = paragraphe.get(i).obtenirLongeurPhrase();
            }
        }
        return longeurMax;
    }

    private String formerHiragana(String hiragana) {
        String hiraganaForme;
        if (hiragana.length() == 5) {
            hiraganaForme = " <td>&#" + hiragana + ";</td>";
        } else {
            hiraganaForme = " <td>&#" + hiragana.substring(0,hiragana.indexOf(","))
                + "," + " <td>&#" + hiragana.substring(hiragana.indexOf(" " + 1)) + ";</td>s";
        }
        return hiraganaForme;
    }

    private String obtenirTableSortie() {
        String sortie = "";

        for(int i = 0; i < obtenirLongeurMaxPhrase(); i++) {
            sortie = sortie + "    <tr>";
            for(int j = 0; j < paragraphe.size(); j++) {
                if(i < paragraphe.get(j).obtenirLongeurPhrase()) {
                    sortie = sortie + formerHiragana(paragraphe.get(j).obtenirSyllabe(i).getHiragana());
                } else {
                    sortie = sortie + " <td></td>        ";
                }
            }
            sortie = sortie + " </tr>\n";
        }

        return sortie;
    }

    public int obtenirLongeurParagraphe() {
        return paragraphe.size();
    }

    public PhraseOrdreJaponais obtenirPhrase(int j) {
        return paragraphe.get(j);
    }

}
