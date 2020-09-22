package eu.europa.ec.workshop.ut.pub.beer.controller;

import eu.europa.ec.workshop.ut.pub.beer.entity.Beer;
import eu.europa.ec.workshop.ut.pub.beer.service.BeerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/beer")
public class BeerController {

    private static final Logger LOG = LogManager.getLogger(BeerController.class);

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @ResponseStatus(OK)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Iterable<Beer> getAll() {
        LOG.debug("getAll");
        return beerService.findAll();
    }

    @ResponseStatus(OK)
    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Beer getOne(@PathVariable Long id) {
        LOG.debug("getOne {}", id);
        return beerService.findById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Beer create(@RequestBody Beer beer) {
        LOG.debug("create {}", beer);
        return beerService.create(beer);
    }

    @ResponseStatus(OK)
    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Beer update(@RequestBody Beer beer) {
        LOG.debug("update {}", beer);
        return beerService.update(beer);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        LOG.debug("delete {}", id);
        beerService.delete(id);
    }

}
