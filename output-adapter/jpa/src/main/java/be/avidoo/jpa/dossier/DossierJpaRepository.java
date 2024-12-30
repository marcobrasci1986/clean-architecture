package be.avidoo.jpa.dossier;

import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.domain.aggregate.dossier.DossierStatus;
import be.avidoo.domain.aggregate.dossier.Dossiernummer;
import be.avidoo.domain.aggregate.dossier.Politiezone;
import be.avidoo.domain.aggregate.dossier.PolitiezoneId;
import be.avidoo.outputport.DossierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DossierJpaRepository implements DossierRepository {

    private final DossierSpringRepository repository;
    private final PolitiezoneSpringRepository politiezoneSpringRepository;

    @Override
    public DossierId save(Dossier dossier) {
        DossierJpaEntity dossierJpaEntity = DossierJpaEntity.builder()
                .id(dossier.getId().getValue())
                .dossiernummer(dossier.getDossiernummer().getValue())
                .datumCreatie(LocalDateTime.now())
                .datumLaatsteWijziging(LocalDateTime.now())
                .status(DossierStatus.DOSSIEROPBOUW)
                .build();

        DossierJpaEntity savedDossierEntity = repository.save(dossierJpaEntity);
        return DossierId.dossierId(savedDossierEntity.getId());
    }

    @Override
    public void updatePolitiezone(Dossier dossier, PolitiezoneId politiezoneId) {
        DossierJpaEntity dossierJpaEntity = repository.findById(dossier.getId().getValue()).orElseThrow();
        PolitiezoneJpaEntity politiezoneJpaEntity = politiezoneSpringRepository.findById(politiezoneId.getValue()).orElseThrow();

        dossierJpaEntity.setPolitiezone(politiezoneJpaEntity);
        repository.save(dossierJpaEntity);
    }

    @Override
    public Optional<Dossier> findByDossierId(DossierId dossierId) {
        return repository.findById(dossierId.getValue())
                .map(this::mapToDossier);
    }

    private Dossier mapToDossier(DossierJpaEntity dossierJpaEntity) {
        Politiezone politiezone = Optional.ofNullable(dossierJpaEntity.getPolitiezone()).map(e -> {
            return Politiezone.PolitiezoneBuilder.aPolitiezone()
                    .withPolitiezoneId(PolitiezoneId.politiezoneId(e.getId()))
                    .withZone(e.getZone())
                    .build();
        }).orElse(null);

        return Dossier.builder()
                .withId(DossierId.dossierId(dossierJpaEntity.getId()))
                .withStatus(dossierJpaEntity.getStatus())
                .withDossiernummer(Dossiernummer.dossiernummer(dossierJpaEntity.getDossiernummer()))
                .withPolitiezone(politiezone)
                .withDatumCreatie(dossierJpaEntity.getDatumCreatie())
                .withDatumLaatsteWijziging(dossierJpaEntity.getDatumLaatsteWijziging())
                .build();
    }


}
