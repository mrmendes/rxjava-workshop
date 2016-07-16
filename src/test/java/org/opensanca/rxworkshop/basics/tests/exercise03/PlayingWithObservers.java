package org.opensanca.rxworkshop.basics.tests.exercise03;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithObservers {

    @Test public void consumeWithObservers() {

        Observable<String> create = Observable.fromCallable(() -> "Open Sanca");
        create.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("done");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
        // TODO Consume with observer

    }

    @Test public void consumeWithActions() {

        List<String> openSancaFacts = Arrays.asList("Open", "Sanca", "Rules");
        Observable<String> source = Observable.from(openSancaFacts);
        source.subscribe(System.out::println,
                throwable -> {},
                System.out::println);

        // TODO Consume with actions

    }

    @Test public void consumeError() {
        Observable.error(new IllegalArgumentException("Error"))
                .subscribe(o -> {},
                        Throwable::printStackTrace,
                        () -> {});
    }
}
