package be.avidoo.domain.dossier;

record Dossiernummer(String value) {
    static Dossiernummer dossiernummer(String value) {
        return new Dossiernummer(value);
    }

}
