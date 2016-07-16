package org.opensanca.rxworkshop.basics.tests.exercise17;

import org.junit.Test;
import org.opensanca.rxworkshop.basics.starwars.ResourceIdExtractor;
import org.opensanca.rxworkshop.basics.starwars.RestApiCreator;
import org.opensanca.rxworkshop.basics.starwars.StarWarsAPI;
import org.opensanca.rxworkshop.basics.starwars.models.Movie;
import org.opensanca.rxworkshop.basics.starwars.models.People;
import org.opensanca.rxworkshop.basics.util.ThreadUtils;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class MoviesFromSomeRandomPeople {

    @Test public void find() {

        StarWarsAPI api = RestApiCreator.starWarsAPI();

        // TODO : use this api and print movie for some random hero on console.
        // These call must be chained with flatMap

//        api.people().flatMap( peopleResults -> selectRandom(peopleResults.results))
//                .doOnNext(ppl -> System.out.println(ppl))
//                .flatMap(ppl -> Observable.from(ppl.filmsResources))
//                .collect(() -> new ArrayList<Observable<Movie>>(), (movies, s) -> movies.add(api.movieById(s).first()))
//                .flatMap(movies -> Observable.from(movies))
//                .subscribe(movie -> System.out.println(movie));

        api.people()
                .flatMap(peopleResults -> selectRandom(peopleResults.results))
                .doOnNext(ppl -> System.out.println(ppl))
                .flatMap(ppl -> Observable.from(ppl.filmsResources))
                .flatMap(url -> {
                    String id = fetchFilmForUrl(url);
                    return api.movieById(id);
                })
                .subscribe(System.out::println);


    }

    private String fetchFilmForUrl(String url) {
        return ResourceIdExtractor.idFromUrl(url);
    }

    private Observable<People> selectRandom(List<People> list) {
        Random random = new Random();
        Integer chosen = random.nextInt(list.size());
        return Observable.just(list.get(chosen));
    }


//    private Observable<People> selectRandom(List<People> list) {
//        Random random = new Random();
//        People chosen = list.get(random.nextInt(list.size()));
//        return Observable.from(list).filter(s -> s.name.contentEquals(chosen.name)).distinct();
//    }


}
