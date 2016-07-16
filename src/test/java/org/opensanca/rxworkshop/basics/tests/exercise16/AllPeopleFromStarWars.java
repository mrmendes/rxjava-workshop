package org.opensanca.rxworkshop.basics.tests.exercise16;

import org.junit.Test;
import org.opensanca.rxworkshop.basics.starwars.RestApiCreator;
import org.opensanca.rxworkshop.basics.starwars.StarWarsAPI;
import org.opensanca.rxworkshop.basics.util.ThreadUtils;
import rx.Observable;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class AllPeopleFromStarWars {

    @Test public void find() {

        StarWarsAPI api = RestApiCreator.starWarsAPI();

        // TODO : use this api and print characters on console
        api.people()
                .flatMap( peopleResults -> Observable.from(peopleResults.results))
                .subscribe(System.out::println);

    }
}
