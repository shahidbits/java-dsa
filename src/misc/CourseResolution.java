package misc;

/*
You're developing a system for scheduling advising meetings with students in a Computer Science program. Each meeting should be scheduled when a student has completed 50% of their academic program.

Each course at our university has at most one prerequisite that must be taken first. No two courses share a prerequisite. There is only one path through the program.

Write a function that takes a list of (prerequisite, course) pairs, and returns the name of the course that the student will be taking when they are halfway through their program. (If a track has an even number of courses, and therefore has two "middle" courses, you should return the first one.)

Sample input 1: (arbitrarily ordered)
prereqs_courses1 = [
	["Foundations of Computer Science", "Operating Systems"],
	["Data Structures", "Algorithms"],
	["Computer Networks", "Computer Architecture"],
	["Algorithms", "Foundations of Computer Science"],
	["Computer Architecture", "Data Structures"],
	["Software Design", "Computer Networks"]
]

In this case, the order of the courses in the program is:
	Software Design
	Computer Networks
	Computer Architecture
	Data Structures
	Algorithms
	Foundations of Computer Science
	Operating Systems

Sample output 1:
	"Data Structures"

Sample input 2:
prereqs_courses2 = [
    ["Algorithms", "Foundations of Computer Science"],
    ["Data Structures", "Algorithms"],
    ["Foundations of Computer Science", "Logic"],
    ["Logic", "Compilers"],
    ["Compilers", "Distributed Systems"],
]

Sample output 2:
	"Foundations of Computer Science"

Sample input 3:
prereqs_courses3 = [
	["Data Structures", "Algorithms"],
]

Sample output 3:
	"Data Structures"

Complexity analysis variables:

n: number of pairs in the input
*/

import java.util.HashMap;
import java.util.Map;

public class CourseResolution {

    public String getMiddleCourse(String[][] prereqsCourses) {

        if (prereqsCourses == null || prereqsCourses.length == 0) {
            return null;
        }

        String middleCourse = "";

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        int courseCount = 0;

        for (int i = 0; i < prereqsCourses.length; i++) {
            map1.put(prereqsCourses[i][0], prereqsCourses[i][1]);
            map2.put(prereqsCourses[i][1], prereqsCourses[i][0]);
            courseCount++;
        }

        String firstCourse = getFirstCourse(prereqsCourses[0][1], map2);

        int middleCourseIdx = (courseCount / 2);
        middleCourse = firstCourse;

        while (middleCourseIdx-- > 0) {
            middleCourse = map1.get(middleCourse);
        }

        System.out.println("middleCourse = " + middleCourse);

        return middleCourse;
    }

    private String getFirstCourse(String dependentCourse, Map<String, String> map2) {

        String firstCourse = null;
        while (firstCourse == null) {

            if (map2.containsKey(dependentCourse)) {
                dependentCourse = map2.get(dependentCourse);
            } else {
                firstCourse = dependentCourse;
            }
        }

        return firstCourse;
    }
}

