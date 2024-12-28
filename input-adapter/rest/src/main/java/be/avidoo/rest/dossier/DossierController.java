package be.avidoo.rest.dossier;

import be.avidoo.core.command.AanmeldenDossierCommand;
import be.avidoo.core.common.command.CommandBus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DossierController {

    private final CommandBus commandBus;

    public DossierController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @GetMapping("/create")
    public ResponseEntity<String> hello() {

        UUID id = commandBus.execute(new AanmeldenDossierCommand());
        return ResponseEntity.ok(id.toString());
    }
}
