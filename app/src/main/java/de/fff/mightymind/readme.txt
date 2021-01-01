6 farben
rot grün orange gelb blau lila

ein runder farbiger knopf soll -
    wenn man den finger darauf hält
        - mehrere farb alternativen zeigen.

input events overview
public abstract boolean onLongClick (View v)
Called when a view has been clicked and held.

Farbwahl als zyklus:
    wenn ein knopf gedrückt wird
        gib diesem knopf die nächste farbe

noch schicker natürlich:
    farbwahl als dropdown menü bei onLongClick
a
b
e
r
 d a s ist wohl zukunftsmusik

zeige eine reihe buttons
    sind alle farben gewählt?
        zeige submit button

    onSubmitButton
        prüfe ob alle buttons eine gültige farbe haben

        prüfe gewonnen
            sind alle buttons richtig?
                sag dem user er hat gewonnen
                starte neu
        wenn nicht gewonnen
            prüfe buttons
            ist die farbe in der gesuchten kombination?
                ist die farbe an der richtigen stelle?
                    kennzeichne den button
            zeige gekennzeichnete buttons in der history
            resette die prüf-buttons

