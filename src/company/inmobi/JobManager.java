package company.inmobi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JobManager {

    public int getMinimumResources(List<JobStats> jobs) {

        if (jobs == null || jobs.size() == 0) {
            return 0;
        }

        List<Item> items = populateItems(jobs);
        Collections.sort(items);

        printList(items);

        return calculateMinResources(items);
    }

    private int calculateMinResources(List<Item> items) {

        int currSum = 0;
        int max = 0;

        for (Iterator<Item> it = items.iterator(); it.hasNext(); ) {

            Item item = it.next();

            switch (item.getType()) {

                case START:
                    currSum += item.getResCount();
                    break;

                case END:
                    currSum -= item.getResCount();
                    break;
            }

            System.out.println(String.format("currSum=%s max=%s", currSum, max));

            max = Math.max(max, currSum);
        }

        return max;
    }

    private List<Item> populateItems(List<JobStats> jobs) {

        List<Item> items = new ArrayList<>();

        for (Iterator<JobStats> it = jobs.iterator(); it.hasNext(); ) {
            JobStats job = it.next();

            Item startItem = new Item(job.getStartTime(), job.getResourceNeeded(), ItemType.START);
            Item endItem = new Item(job.getEndTime() + 1, job.getResourceNeeded(), ItemType.END);

            items.add(startItem);
            items.add(endItem);
        }

        return items;
    }

    private void printList(List<Item> items) {
        for (Iterator<Item> it = items.iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
    }
}
