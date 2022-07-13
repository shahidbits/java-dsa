package company.inmobi;


import java.util.Arrays;

/*
 * Given list of jobs with (starttime, endtime and resources) find the minimum number of resources required to find all the jobs.
 *
 * (3,10,5)
 * (4,9,8)
 * (10,15,10)
 * => 15
 *
 *
 * (3,6,5)
 * (4,8,6)
 * (5,9,6)
 *
 * 3-s =>+5
 * 4-s =>+6
 * 5-s =>+6
 * 6-e =>-5
 * 8-e =>-6
 * 9-e =>-6
 *
 * List<Item> => Time + Type + ResCount
 */
public class Question1 {

    public static void main(String[] args) {

        JobStats job1 = new JobStats(3, 6, 5);
        JobStats job2 = new JobStats(4, 5, 7);
        JobStats job3 = new JobStats(6, 9, 8);

        JobManager jobManager = new JobManager();
        int min = jobManager.getMinimumResources(Arrays.asList(job1, job2, job3));

        System.out.println("Min = " + min);

    }


}
