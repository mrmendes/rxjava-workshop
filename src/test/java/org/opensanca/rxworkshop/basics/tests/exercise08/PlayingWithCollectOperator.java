package org.opensanca.rxworkshop.basics.tests.exercise08;

import org.junit.Test;
import org.opensanca.rxworkshop.basics.icmc.ICMCTeachers;
import org.opensanca.rxworkshop.basics.icmc.Teacher;
import org.opensanca.rxworkshop.basics.icmc.TeacherMapper;
import org.opensanca.rxworkshop.basics.icmc.TeacherStatus;
import org.opensanca.rxworkshop.basics.util.CountHolder;
import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func0;

import java.util.Set;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithCollectOperator {

    @Test public void verifyCollectOperatorBehavior() {
        Set<String> names = ICMCTeachers.names();

        Observable.from(names)
                .map(TeacherMapper::map)
                .collect(() -> new CountHolder(), (countHolder, teacher) -> {
                    if ( teacher.getStatus() == TeacherStatus.EASY) {
                        countHolder.increment();
                    }
                 })
                .subscribe(countHolder -> System.out.println(countHolder.get()));

        // TODO apply map and collect, assert emissions

    }

}
