package be.avidoo.usecase.dossier.query;

import be.avidoo.core.common.query.QueryHandler;
import be.avidoo.core.common.query.QueryMessage;
import be.avidoo.core.query.dossier.FindDossierByIdQuery;
import be.avidoo.domain.dossier.DossierAggregate;
import be.avidoo.domain.dossier.DossierRepository;
import be.avidoo.querymodel.dossier.FindDossierDetailsQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindDossierByIdQueryHandler
        implements QueryHandler<FindDossierByIdQuery, FindDossierDetailsQueryDto> {

    private final DossierRepository dossierRepository;


    @Override
    public FindDossierDetailsQueryDto handle(QueryMessage<FindDossierByIdQuery> queryMessage) {
        FindDossierByIdQuery query = queryMessage.getQuery();
        DossierAggregate dossier = dossierRepository.findByDossierId(query.getDossierId()).orElseThrow();

        return FindDossierDetailsQueryDto.builder()
                .dossierId(dossier.getId())
                .dossiernummer(dossier.getDossiernummer())
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
