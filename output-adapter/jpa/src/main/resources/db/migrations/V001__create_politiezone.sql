CREATE TABLE IF NOT EXISTS politiezone
(
    id                      UUID        NOT NULL PRIMARY KEY,
    zone                    varchar     NOT NULL UNIQUE,
    datum_creatie           timestamptz NOT NULL,
    datum_laatste_wijziging timestamptz NOT NULL
);

INSERT INTO politiezone(id, zone, datum_creatie, datum_laatste_wijziging)
VALUES ('5e0d813a-7377-4c96-88d8-48121e69bb98', 'Limburg', now(), now());
INSERT INTO politiezone(id, zone, datum_creatie, datum_laatste_wijziging)
VALUES ('c4682927-f312-467b-8ba8-8749db5a4429', 'Antwerpen', now(), now())

