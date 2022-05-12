package company.twilio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SortedTransactions {

    public static List<String> groupTransactions(List<String> transactions) {

        List<String> txnDetails = new ArrayList<>();
        List<TransactionData> txnData = new ArrayList<>();

        if (transactions != null && transactions.size() > 0) {

            Map<String, Long> countMap = transactions.stream()
                    .collect(groupingBy(p -> p, counting()));

            System.out.println(countMap.toString());

            for (Iterator<Map.Entry<String, Long>> it = countMap.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Long> entry = it.next();
                txnData.add(new TransactionData(entry.getKey(), entry.getValue()));
            }

            Collections.sort(txnData, new TransactionCountComparator());
        }

        for (Iterator<TransactionData> it = txnData.iterator(); it.hasNext(); ) {
            TransactionData transactionData = it.next();
            txnDetails.add(transactionData.transactionType + " " + transactionData.transactionCount);
        }

        return txnDetails;
    }

    public static class TransactionData {
        public String transactionType;
        public Long transactionCount;

        public TransactionData(String transactionType, Long transactionCount) {
            this.transactionType = transactionType;
            this.transactionCount = transactionCount;
        }
    }

    public static class TransactionCountComparator implements Comparator<TransactionData> {

        @Override
        public int compare(TransactionData t1, TransactionData t2) {

            if (t1.transactionCount == t2.transactionCount) {
                return t1.transactionType.compareTo(t2.transactionType);
            }

            return t2.transactionCount.compareTo(t1.transactionCount);
        }

    }
}
