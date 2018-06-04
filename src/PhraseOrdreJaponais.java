import java.util.ArrayList;

public class PhraseOrdreJaponais {
    private ArrayList<Syllabe> phrase;

    public PhraseOrdreJaponais() {
        this.phrase = new ArrayList<>();
    }

    public void setPhrase(Syllabe syllabe) {
        try{
            this.phrase.add(syllabe);
        } catch (NullPointerException e) {
            System.out.println( "Syllable n'existe pas." );
        }
    }

    public Syllabe obtenirSyllabe( int i ) {
        Syllabe syl;
        try{
            syl = phrase.get(i);
        } catch (IndexOutOfBoundsException e) {
            syl = null;
        }
        return syl;
    }

    public int obtenirLongeurPhrase() {
        return phrase.size();
    }

    public ArrayList<Syllabe> getPhrase() {
        return phrase;
    }

}
