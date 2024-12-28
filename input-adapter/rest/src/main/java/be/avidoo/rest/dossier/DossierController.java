package be.avidoo.rest.dossier;

import be.avidoo.core.command.AanmeldenDossierCommand;
import be.avidoo.core.common.command.CommandBus;
import be.avidoo.core.common.query.QueryBus;
import be.avidoo.core.query.dossier.FindDossierByIdQuery;
import be.avidoo.querymodel.dossier.FindDossierDetailsQueryDto;
import be.avidoo.rest.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DossierController implements Api {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @PostMapping("/dossier")
    public ResponseEntity<String> createDossier() {

        UUID id = commandBus.execute(new AanmeldenDossierCommand());
        return ResponseEntity.ok(id.toString());
    }

    @GetMapping(value = "/dossier/{dossierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindDossierDetailsQueryDto> findById(
            @PathVariable("dossierId") UUID dossierId
    ) {
        FindDossierByIdQuery query = FindDossierByIdQuery.builder().dossierId(dossierId).build();
        FindDossierDetailsQueryDto response = queryBus.query(query);
        return ResponseEntity.ok(response);
    }
}
