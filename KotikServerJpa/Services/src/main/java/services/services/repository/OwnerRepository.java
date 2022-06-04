package services.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.services.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}

