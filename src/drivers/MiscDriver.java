package drivers;

import misc.CourseResolution;
import misc.FindUniqueBinaryString;
import misc.PrimeFactors;
import string.LongestRepeatingCharacterReplacement;

public class MiscDriver {

    public void primeFactors() {
        PrimeFactors primeFactors = new PrimeFactors();
        primeFactors.printPrimeFactors(20);
    }

    public void longestRepeatingCharacterReplacement() {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println("max=" + longestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1));
    }

    public void findUniqueBinaryString() {

        String[] nums = {
                "1010",
                "0011",
                "1011",
                "1111"
        };

        FindUniqueBinaryString findUniqueBinaryString = new FindUniqueBinaryString();
        System.out.println("unique=" + findUniqueBinaryString.findDifferentBinaryString(nums));
    }

    public void courseResolution() {

        String[][] prereqsCourses1 = {
                {"Foundations of Computer Science", "Operating Systems"},
                {"Data Structures", "Algorithms"},
                {"Computer Networks", "Computer Architecture"},
                {"Algorithms", "Foundations of Computer Science"},
                {"Computer Architecture", "Data Structures"},
                {"Software Design", "Computer Networks"}
        };

        String[][] prereqsCourses2 = {
                {"Algorithms", "Foundations of Computer Science"},
                {"Data Structures", "Algorithms"},
                {"Foundations of Computer Science", "Logic"},
                {"Logic", "Compilers"},
                {"Compilers", "Distributed Systems"},
        };


        String[][] prereqsCourses3 = {
                {"Data Structures", "Algorithms"}
        };

        CourseResolution courseResolution = new CourseResolution();
        courseResolution.getMiddleCourse(prereqsCourses1);
        courseResolution.getMiddleCourse(prereqsCourses2);
        courseResolution.getMiddleCourse(prereqsCourses3);

    }
}
