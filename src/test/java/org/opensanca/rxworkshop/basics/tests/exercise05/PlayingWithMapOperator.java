package org.opensanca.rxworkshop.basics.tests.exercise05;

import com.sun.tools.javac.util.Assert;
import org.junit.Test;
import org.opensanca.rxworkshop.basics.icmc.ICMCDepartment;
import org.opensanca.rxworkshop.basics.icmc.ICMCTeachers;
import org.opensanca.rxworkshop.basics.icmc.TeacherMapper;
import rx.Observable;

import java.util.Set;

/**
 * Created by ubiratansoares for RxJava Workshop.
 */

public class PlayingWithMapOperator {

    @Test public void verifyMapOperatorBehavior() {
        Set<String> names = ICMCTeachers.names();

        Observable.from(names)
                .map(TeacherMapper::map)
//                .map(s -> TeacherMapper.map(s))
                .subscribe(System.out::println);

    }

}
