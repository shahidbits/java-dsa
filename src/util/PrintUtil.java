package util;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PrintUtil {

    public static void printStack(Stack S) {

        for (Iterator it = S.iterator(); it.hasNext(); ) {
            System.out.print(String.format("%s  ", it.next()));
        }

        System.out.println();
    }

    public static <T> void printArrayList(List<T> A) {

        for (Iterator it = A.iterator(); it.hasNext(); ) {
            System.out.print(String.format("%s  ", it.next()));
        }

        System.out.println();
    }

}
