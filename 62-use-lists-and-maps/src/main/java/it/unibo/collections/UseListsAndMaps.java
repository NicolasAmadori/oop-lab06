package it.unibo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var numeri = new ArrayList<Integer>();
        for(int i = 1000; i < 2000; i++) {
            numeri.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
         var copiaNumeri = new LinkedList<Integer>();
         copiaNumeri.addAll(numeri);
         
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */        
        var firstNumber = copiaNumeri.getFirst();
        var firstNumberPosition = numeri.indexOf(firstNumber);

        var lastNumber = copiaNumeri.getLast();
        var lastNumberPosition = numeri.indexOf(lastNumber);

        copiaNumeri.set(firstNumberPosition, lastNumber);
        copiaNumeri.set(lastNumberPosition, firstNumber);        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : numeri) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for(int i = 0; i < 100_000; i++) {
            numeri.add(0, i);
        }
        time1 = System.nanoTime() - time1;

        long time2 = System.nanoTime();
        for(int i = 0; i < 100_000; i++) {   
            copiaNumeri.addFirst(i);
        }
        time2 = System.nanoTime() - time2;

        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println("Time Writing ArrayList: " + millis1 + "\nTime Writing LinkedList: " + millis2);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        int read;
        long time3 = System.nanoTime();
        for(int i = 0; i < 1000; i++) {
            read = numeri.get(numeri.size() / 2);
        }
        time3 = System.nanoTime() - time3;

        long time4 = System.nanoTime();
        for(int i = 0; i < 1000; i++) {   
            read = copiaNumeri.get(numeri.size() / 2);
        }
        time4 = System.nanoTime() - time4;

        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time3);
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time4);
        System.out.println("\nTime Reading ArrayList: " + millis3 + "\nTime Reading LinkedList: " + millis4);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map <String,Long> continenti = new TreeMap<>();
        continenti.put("Africa", 1_110_635_000L);
        continenti.put("America", 972_005_000L);
        continenti.put("Antarctica", 0L);
        continenti.put("Asia", 4_298_723_000l);
        continenti.put("Europe", 742_452_000L);
        continenti.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        Long popolazioneMondiale = 0L;
        var chiavi = continenti.keySet();
        for (String key : chiavi) {
            popolazioneMondiale+= continenti.get(key);
        }
        System.out.println("Popolazione mondiale: " + popolazioneMondiale);
    }
}
