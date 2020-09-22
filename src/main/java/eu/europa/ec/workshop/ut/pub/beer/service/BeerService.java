package eu.europa.ec.workshop.ut.pub.beer.service;

import eu.europa.ec.workshop.ut.pub.beer.entity.Beer;
import eu.europa.ec.workshop.ut.pub.beer.exception.BeerNotFoundException;
import eu.europa.ec.workshop.ut.pub.beer.repository.BeerRepository;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Iterable<Beer> findAll() {
        return beerRepository.findAll();
    }

    public Beer findById(Long id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    public Beer create(Beer beer) {
        return beerRepository.save(beer);
    }

    public Beer update(Beer beer) {
        if (!beerRepository.existsById(beer.getId())) {
            throw new BeerNotFoundException(beer.getId());
        }

        return beerRepository.save(beer);
    }

    public void delete(Long id) {
        beerRepository.delete(beerRepository.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id)));
    }

}
