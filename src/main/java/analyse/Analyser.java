package analyse;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Interface für die Implementierung jedes Analysetyps
 *
 * Created by florian on 23.11.15.
 */
public interface Analyser <T> {

    void setValue(String val);
    /**
     * analysieren Methode, der das Bild und der Bereich, der analysiert werden soll, übergeben werden und gibt das Ergebnis generisch zurück
     * @param image zu analysierendes Bild
     * @param rectangle zu analysierender Bereich
     * @param <T> Ergebnistyp
     * @return generisches Analyse-Ergebis
     */
    <T> T analyse(BufferedImage image, Rectangle rectangle);
}
