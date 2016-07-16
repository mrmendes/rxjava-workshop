package org.opensanca.rxworkshop.basics.tests.exercise07;

import org.junit.Test;
import org.opensanca.rxworkshop.basics.icmc.ICMCTeachers;
import org.opensanca.rxworkshop.basics.icmc.Teacher;
import org.opensanca.rxworkshop.basics.icmc.TeacherMapper;
import org.opensanca.rxworkshop.basics.icmc.TeacherStatus;
import rx.Observable;
import rx.functions.Func2;

import java.util.Set;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithReduceOperator {

    @Test public void verifyReduceOperatorBehavior() {
        Set<String> names = ICMCTeachers.names();
        Observable.from(names)
                .map(TeacherMapper::map)
                .reduce(0, (count, teacher) -> {
                    if(teacher.getStatus() == TeacherStatus.EASY) {
                        count++;
                    }
                    return count;
                })
                .subscribe(System.out::println);

        // TODO apply map and reduce, assert emissions

    }
}
