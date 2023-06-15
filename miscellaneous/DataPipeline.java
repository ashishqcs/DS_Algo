package miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Source: <a href="https://wentao-shao.gitbook.io/leetcode/data-structure/1152.analyze-user-website-visit-pattern">visit</a>
 */
class DataPipeline {

    public static void main(String[] args) throws IOException {// 5 6
        DataPipeline dataPipeline = new DataPipeline();

        //read csv and create a map of user to visited pages.
        Map<String, String> userPageVisitedMap = dataPipeline.readCsv();

        // generate all possible n-step sequences from userPageVisitedMap.
        Set<String> nStepSeqSet = dataPipeline.getNSequenceSet(3, userPageVisitedMap);


        Map<String, Integer> sequenceFrequencyMap = new HashMap<>();

        // Match generated possible n step sequences one by one with user visit sequences and store
        // result in a hashmap (sequenceFrequencyMap) of n step sequence to frequency of that step.
        for (String seq: nStepSeqSet){
            for (String userSequence: userPageVisitedMap.values()){
                if (userSequence.contains(seq)){
                    sequenceFrequencyMap.compute(seq, (k,v) -> v ==null ? 1 : v + 1);
                }
            }
        }

        // Sort sequenceFrequencyMap based on values and print.
        sequenceFrequencyMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList().forEach(
                (e) -> System.out.println(e.getKey() + ":" + e.getValue())
        );
    }

    /**
     Read a csv file and map it to a hashmap (user as key and visited pages as values joined by `;`.).

     <blockquote><pre> eg:
     (user1, search;detail-1;detail2)
     (user2, search;detail-1;detail2)
     </pre></blockquote>
     */
    private Map<String, String> readCsv() throws IOException {
        Map<String, String> userPageVisitedMap = new HashMap<>();
        //read file
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ashish.singh/Library/Application Support/JetBrains/IntelliJIdea2022.3/scratches/data.csv"))) {
            String line;
            int count = 1; //to ignore headers
            // read each line in a file
            while ((line = br.readLine()) != null) {
                if (count++ == 1)
                    continue;
                String[] values = line.split(",");

                //add each line to map (user,all visited pages by this user)
                userPageVisitedMap.compute(values[1], (k,v) -> v == null ? values[2] : (v + ";" + values[2]));
            }
        }

        return userPageVisitedMap;
    }

    /**
     * Generates all possible n step long sequences from user to visited pages map.
     */
    private Set<String> getNSequenceSet(int n, Map<String, String> userPageVisitedMap){
        Set<String> nStepSeqSet = new HashSet<>();

        // Iterate all user visited pages.
        for (String seq: userPageVisitedMap.values()){
            String[] splitSeq = seq.split(";");

            // create n step sequences as string. eg for n=3: page1;page2;page3 and add to nStepSeqSet.
            for (int i = 0; i<=splitSeq.length - n; i++){
                StringBuilder sb = new StringBuilder(splitSeq[i]);
                for (int j = i+1; j<i+n; j++){
                    sb.append(";").append(splitSeq[j]);
                }
                nStepSeqSet.add(sb.toString());
            }
        }

        return nStepSeqSet;
    }

}

