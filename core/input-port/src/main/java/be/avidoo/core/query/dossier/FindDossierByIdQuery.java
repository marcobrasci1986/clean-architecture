package be.avidoo.core.query.dossier;

import be.avidoo.core.common.query.DossierQuery;
import be.avidoo.core.common.query.Query;
import be.avidoo.querymodel.dossier.FindDossierDetailsQueryDto;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class FindDossierByIdQuery implements Query<FindDossierDetailsQueryDto>, DossierQuery {

    private final UUID dossierId;
}
