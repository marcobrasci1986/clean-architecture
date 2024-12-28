package be.avidoo.domain.aggregate.dossier;

public class Dossiernummer {
    public static Dossiernummer dossiernummer(String value) {
        return new Dossiernummer(value);
    }

    private final String value;

    public Dossiernummer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
