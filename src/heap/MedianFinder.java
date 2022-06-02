package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }

        if (minHeap.size() == 0) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                int tmp = maxHeap.remove();
                minHeap.add(tmp);
                maxHeap.add(num);
            }
            return;
        }

        if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                int tmp = maxHeap.remove();
                minHeap.add(tmp);
                maxHeap.add(num);
            }
        } else if (maxHeap.size() < minHeap.size()) {
            if (num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                int tmp = minHeap.remove();
                maxHeap.add(tmp);
                minHeap.add(num);
            }
        } else {
            if (maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }

    }

    public double findMedian() {

        if (maxHeap.size() != minHeap.size()) {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }

        return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;

    }
}