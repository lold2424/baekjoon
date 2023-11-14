import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map<String, HashSet<String>> report_id = new HashMap<>();

        int[] process_mail_count = new int[id_list.length];

        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0 ; i < id_list.length ; i++) {
            idIndexMap.put(id_list[i], i);
        }

        for (int i = 0 ; i < report.length ; i++) {
            String[] reported = report[i].split(" ");
            if (report_id.get(reported[1]) == null) {
            	report_id.put(reported[1], new HashSet<String>() );
                }
            HashSet<String> set = report_id.get(reported[1]);
            set.add(reported[0]); 
            report_id.put(reported[1], set);
        }

        for (int i = 0 ; i < id_list.length ; i++) { 
            Set<String> reporterIDs = report_id.get(id_list[i]);
            if (reporterIDs != null && reporterIDs.size() >= k) {
                Iterator<String> iter = reporterIDs.iterator();
                while(iter.hasNext()) {
                    String reporter = iter.next();
                    process_mail_count[idIndexMap.get(reporter)]++;
                }
            }
        }

        answer = process_mail_count;

        return answer;
    }
}