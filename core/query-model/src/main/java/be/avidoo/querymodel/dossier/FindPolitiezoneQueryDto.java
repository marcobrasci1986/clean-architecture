package be.avidoo.querymodel.dossier;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class FindPolitiezoneQueryDto {
    public UUID id;
    public String zone;
}