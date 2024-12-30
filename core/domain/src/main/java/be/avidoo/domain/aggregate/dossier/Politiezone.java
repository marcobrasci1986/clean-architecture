package be.avidoo.domain.aggregate.dossier;

public class Politiezone {

    private final PolitiezoneId politiezoneId;
    private final String zone;

    public Politiezone(PolitiezoneId politiezoneId, String zone) {
        this.politiezoneId = politiezoneId;
        this.zone = zone;
    }

    public PolitiezoneId getPolitiezoneId() {
        return politiezoneId;
    }

    public String getZone() {
        return zone;
    }

    public static final class PolitiezoneBuilder {
        private PolitiezoneId politiezoneId;
        private String zone;

        private PolitiezoneBuilder() {
        }

        public static PolitiezoneBuilder aPolitiezone() {
            return new PolitiezoneBuilder();
        }

        public PolitiezoneBuilder withPolitiezoneId(PolitiezoneId politiezoneId) {
            this.politiezoneId = politiezoneId;
            return this;
        }

        public PolitiezoneBuilder withZone(String zone) {
            this.zone = zone;
            return this;
        }

        public Politiezone build() {
            return new Politiezone(politiezoneId, zone);
        }
    }
}
