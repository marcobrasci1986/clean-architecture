package be.avidoo.usecase.dossier.query;

import be.avidoo.core.common.query.QueryHandler;
import be.avidoo.core.common.query.QueryMessage;
import be.avidoo.core.query.dossier.FindDossierByIdQuery;
import be.avidoo.domain.aggregate.dossier.Dossier;
import be.avidoo.domain.aggregate.dossier.DossierId;
import be.avidoo.outputport.DossierRepository;
import be.avidoo.querymodel.dossier.FindDossierDetailsQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindDossierByIdQueryHandler
        implements QueryHandler<FindDossierByIdQuery, FindDossierDetailsQueryDto> {

    private final DossierRepository dossierRepository;


    @Override
    public FindDossierDetailsQueryDto handle(QueryMessage<FindDossierByIdQuery> queryMessage) {
        FindDossierByIdQuery query = queryMessage.getQuery();
        Dossier dossier = dossierRepository.findByDossierId(DossierId.dossierId(query.getDossierId())).orElseThrow();

        return FindDossierDetailsQueryDto.builder()
                .dossierId(dossier.getId().getValue())
                .dossiernummer(dossier.getDossiernummer().getValue())
                .status(dossier.getStatus())
                .datumCreatie(dossier.getDatumCreatie())
                .datumLaatsteWijziging(dossier.getDatumLaatsteWijziging())
                .build();
    }

    @Override
    public Class<FindDossierByIdQuery> getQueryClass() {
        return FindDossierByIdQuery.class;
    }
}
