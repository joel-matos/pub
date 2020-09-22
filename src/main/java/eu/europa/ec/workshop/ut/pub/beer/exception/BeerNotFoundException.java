package eu.europa.ec.workshop.ut.pub.beer.exception;

public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(Long id) {
        super("Beer not found with id " + id);
    }

}
