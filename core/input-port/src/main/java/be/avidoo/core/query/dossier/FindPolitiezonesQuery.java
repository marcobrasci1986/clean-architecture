package be.avidoo.core.query.dossier;

import be.avidoo.core.common.query.Query;
import be.avidoo.querymodel.dossier.FindPolitiezoneQueryDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class FindPolitiezonesQuery implements Query<List<FindPolitiezoneQueryDto>> {

}
