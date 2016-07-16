package org.opensanca.rxworkshop.basics.tests.exercise06;

import org.junit.Test;
import org.opensanca.rxworkshop.basics.icmc.ICMCDepartment;
import org.opensanca.rxworkshop.basics.icmc.ICMCTeachers;
import org.opensanca.rxworkshop.basics.icmc.TeacherMapper;
import org.opensanca.rxworkshop.basics.icmc.TeacherStatus;
import rx.Observable;

import java.util.Set;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithFilterOperator {

    @Test public void verifyFilterOperatorBehavior() {
        Set<String> names = ICMCTeachers.names();

        Observable.from(names)
                .map(TeacherMapper::map)
                .filter(teacher -> teacher.getStatus().equals(TeacherStatus.KNIGHT))
                .subscribe(System.out::println);

        System.out.println("=========");
        Observable.from(names)
                .map(TeacherMapper::map)
                .filter(teacher -> teacher.getDepartment().equals(ICMCDepartment.SMA))
                .subscribe(System.out::println);
        // TODO apply map and filter,assert emissions

    }
}
