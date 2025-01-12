package be.avidoo.querymodel.dossier;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class FindDossierDetailsQueryDto {
    private final UUID dossierId;
    private final String dossiernummer;
    private final String status;
    private final LocalDateTime datumCreatie;
    private final LocalDateTime datumLaatsteWijziging;
}