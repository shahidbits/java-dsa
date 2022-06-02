package drivers;

import heap.MedianFinder;

public class HeapDriver {

    public void medianFinder() {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }

}
