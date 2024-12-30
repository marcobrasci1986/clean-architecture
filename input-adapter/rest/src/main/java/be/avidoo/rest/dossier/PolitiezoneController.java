package be.avidoo.rest.dossier;

import be.avidoo.core.common.query.QueryBus;
import be.avidoo.core.query.dossier.FindPolitiezonesQuery;
import be.avidoo.querymodel.dossier.FindPolitiezoneQueryDto;
import be.avidoo.rest.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PolitiezoneController implements Api {

    private final QueryBus queryBus;

    @GetMapping(value = "/politiezones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FindPolitiezoneQueryDto>> findPolitiezones(
    ) {
        FindPolitiezonesQuery query = FindPolitiezonesQuery.builder().build();
        List<FindPolitiezoneQueryDto> response = queryBus.query(query);
        return ResponseEntity.ok(response);
    }
}
