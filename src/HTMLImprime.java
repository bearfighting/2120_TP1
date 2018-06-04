public interface HTMLImprime {
    final static String TEXTE_HTML_DEBUT =
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "  <head>\n" +
        "    <title>Tp1</title>\n" +
        "  </head>\n" +
        "  <body>\n" +
        "    <hr>\n" +
        "    <table>\n";

    final static String TEXTE_HTML_FIN =
        "    </table>\n" +
        "    <hr>\n" +
        "  </body>\n" +
        "</html>";

    public String imprimerHTML ();
}
