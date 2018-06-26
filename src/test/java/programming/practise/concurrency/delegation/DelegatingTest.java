package programming.practise.concurrency.delegation;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DelegatingTest {
    private DelegatingVehicleTracker tracker;

    //这种方法可以保证数据的同步，但是关于线程的执行顺序，生命周期还需要进一步学习
    @Before
    public void setUp() throws Exception {
        Map<String, Point> points = new HashMap<String, Point>(){{
            put("1", new Point(10, 10));
            put("2", new Point(20, 20));
            put("3", new Point(30, 30));
            put("4", new Point(40, 40));
        }};
        tracker = new DelegatingVehicleTracker(points);
    }

    @Test
    public void testConcurrentThread() {

        new Thread(() -> {
            tracker.setLocation("1", 1, 1);
            tracker.setLocation("2", 2, 2);
        }).start();

        final Thread thread1 = new Thread(() -> {
            tracker.getLocations().forEach((s, point) -> System.out.println("thread1 id: " + s + " point: " + point));
            Point point = tracker.getLocation("3");
            System.out.println("thread1 id: 3" + " point: " + point);
            point = tracker.getLocation("4");
            System.out.println("thread1 id: 4" + " point: " + point);
        });
        thread1.start();

        new Thread(() -> {
            tracker.setLocation("3", 3, 3);
            tracker.setLocation("4", 4, 4);
        }).start();


        final Thread thread2 = new Thread(() -> {
            tracker.getLocations().forEach((s, point) -> System.out.println("thread2 id: " + s + " point: " + point));
            Point point = tracker.getLocation("3");
            System.out.println("thread2 id: 3" + " point: " + point);
            point = tracker.getLocation("4");
            System.out.println("thread2 id: 4" + " point: " + point);
        });
        thread2.start();
    }

    @Test
    public void testForMapOperation() {
        //Map如果通过对象引用改变内容，则无需put back就可以生效，但是如果是原子型的类型对象则需要put back才会生效
        Map<String, Point> mainMap = new HashMap<>();
        mainMap.put("1", new Point(1,1));

        Map<String, Point> copyMap = Collections.unmodifiableMap(mainMap);

        mainMap.get("1").set(1, 2);

        System.out.println("copy map's value: " + copyMap.get("1"));
        System.out.println("main map's value: " + mainMap.get("1"));


        Map<String, String> mainStringMap = new HashMap<>();
        mainStringMap.put("1", "1");

        Map<String, String> copyStringMap = Collections.unmodifiableMap(mainStringMap);

        mainStringMap.get("1").replace("1", "2");

        System.out.println("copy string map's value: " + copyStringMap.get("1"));
        System.out.println("main string map's value: " + mainStringMap.get("1"));
    }
}
