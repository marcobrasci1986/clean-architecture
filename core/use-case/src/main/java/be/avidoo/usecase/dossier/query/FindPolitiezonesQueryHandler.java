package be.avidoo.usecase.dossier.query;

import be.avidoo.core.common.query.QueryHandler;
import be.avidoo.core.common.query.QueryMessage;
import be.avidoo.core.query.dossier.FindPolitiezonesQuery;
import be.avidoo.domain.aggregate.dossier.Politiezone;
import be.avidoo.outputport.PolitiezoneRepository;
import be.avidoo.querymodel.dossier.FindPolitiezoneQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class FindPolitiezonesQueryHandler
        implements QueryHandler<FindPolitiezonesQuery, List<FindPolitiezoneQueryDto>> {

    private final PolitiezoneRepository politiezoneRepository;

    @Override
    public List<FindPolitiezoneQueryDto> handle(QueryMessage<FindPolitiezonesQuery> queryMessage) {
        List<Politiezone> byPolitiezones = politiezoneRepository.findByPolitiezones();

        return byPolitiezones.stream().map(politiezone -> FindPolitiezoneQueryDto.builder()
                        .id(politiezone.getPolitiezoneId().getValue())
                        .zone(politiezone.getZone())
                        .build())
                .toList();
    }

    @Override
    public Class<FindPolitiezonesQuery> getQueryClass() {
        return FindPolitiezonesQuery.class;
    }
}
