package be.avidoo.jpa.dossier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PolitiezoneSpringRepository extends JpaRepository<PolitiezoneJpaEntity, UUID> {

}
