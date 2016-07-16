package org.opensanca.rxworkshop.basics.tests.exercise01;

import org.junit.Test;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class HelloObservables {

    @Test public void run() {
        Observable.just("Primeiro", "Segundo", "Terceiro").subscribe(System.out::println);

        Observable<Integer> myVar = Observable.just(10, 20, 40);
        myVar.subscribe(integer -> {
            System.out.println(integer);
        });



    }
}
