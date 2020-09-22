package eu.europa.ec.workshop.ut.pub.beer.repository;

import eu.europa.ec.workshop.ut.pub.beer.entity.Beer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends CrudRepository<Beer, Long> {

}
