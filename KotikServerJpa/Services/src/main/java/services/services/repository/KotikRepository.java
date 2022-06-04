package services.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.services.entities.Kotik;
import services.services.enumClass.Breed;
import services.services.enumClass.Color;

import java.util.Collection;

@Repository
public interface KotikRepository extends JpaRepository<Kotik, Integer> {
    Collection<Kotik> getKotikByColor(Color color);
    Collection<Kotik> getKotikByBreed(Breed breed);
}
