package be.avidoo.querymodel.dossier;

import be.avidoo.domain.aggregate.dossier.DossierStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class FindDossierDetailsQueryDto {
    private final UUID dossierId;
    private final String dossiernummer;
    private final DossierStatus status;
    private final LocalDateTime datumCreatie;
    private final LocalDateTime datumLaatsteWijziging;
}