CREATE TABLE IF NOT EXISTS dossier
(
    id                      UUID         NOT NULL PRIMARY KEY,
    dossiernummer           varchar(255) NOT NULL UNIQUE,
    status                  varchar      NOT NULL,
    datum_creatie           timestamptz  NOT NULL,
    datum_laatste_wijziging timestamptz  NOT NULL

)
