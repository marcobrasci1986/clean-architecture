package be.avidoo.core.dossier;

public class Dossiernummer {
    public static Dossiernummer dossiernummer(String value) {
        return new Dossiernummer(value);
    }

    private String value;

    public Dossiernummer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
