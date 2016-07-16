package org.opensanca.rxworkshop.basics.tests.exercise04;

import org.junit.Test;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class CreationFromFactoryMethod {

    @Test public void creationWithRange() {
        Observable.range(1, 23)
                .map(time -> "count  "+ time)
                .subscribe(System.out::println);

    }

}
