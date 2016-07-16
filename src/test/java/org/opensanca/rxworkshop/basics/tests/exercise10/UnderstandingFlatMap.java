package org.opensanca.rxworkshop.basics.tests.exercise10;

import org.junit.Test;
import rx.Observable;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class UnderstandingFlatMap {

    @Test public void verifyFlatMapOperator() {

        List<String> ZL = Arrays.asList("Itaquera", "Vila Prudente", "Tatuapé");
        List<String> ZS = Arrays.asList("Jardins", "Itaim Bibi", "Jardim Europa");

        Observable.just(ZL, ZS)
                .flatMap(strings -> Observable.from(strings))
                .subscribe(System.out::println);

        System.out.println("======");
        Observable.just(ZL, ZS)
                .flatMap(strings -> Observable.from(strings).filter(s -> s.contains("i")))
                .subscribe(System.out::println);

        // TODO apply flatMap, assert emissions

    }

    @Test public void verifyFlatMapOperatorRandomNeighbor() {

        List<String> ZL = Arrays.asList("Itaquera", "Vila Prudente", "Tatuapé");
        List<String> ZS = Arrays.asList("Jardins", "Itaim Bibi", "Jardim Europa");

        Observable.just(ZL, ZS)
                .flatMap(strings -> selectRandom(strings))
                .sample(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
    }

    private Observable<String> selectRandom(List<String> list) {
        Random random = new Random();
        String chosen = list.get(random.nextInt(list.size()));
        return Observable.from(list).filter(s -> s.contentEquals(chosen)).distinct();
    }

}
