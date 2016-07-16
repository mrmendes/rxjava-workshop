package org.opensanca.rxworkshop.basics.tests.exercise09;

import org.junit.Test;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithConcatOperator {

    @Test public void verifyConcatOperator() {
        List<String> sp = Arrays.asList("Corinthians", "Palmeiras", "Santos");
        List<String> rj = Arrays.asList("Flamengo", "Vasco", "Botafogo");

        Observable.concat(Observable.from(sp), Observable.from(rj)).subscribe(System.out::println);

        // TODO apply concat, assert emissions

    }
}
