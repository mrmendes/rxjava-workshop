package org.opensanca.rxworkshop.basics.tests.exercise02;

import org.junit.Test;
import rx.Observable;


/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class CreationFromCallable {

    @Test public void run() {

        Observable<String> myvar = Observable.fromCallable(() -> "Meu Objeto teste");
        myvar.subscribe(System.out::println);

    }
}
