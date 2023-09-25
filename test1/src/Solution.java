import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'conflictInfo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY meetings as parameter.
     */

    public static String conflictInfo(List<String> meetings) {
        String meetingSplit[];
        int meeting_length = 0;
        int numConflicts = 0;
        int totalConflictTime = 0;
        Collections.sort(meetings);
        for (int i = 1; i < meetings.size(); i++) {
            meetingSplit = meetings.get(i - 1).split(",");
            int duration = Integer.parseInt(meetingSplit[1]);
            int time = Integer.parseInt(meetingSplit[0]);
            int meetingLength = time + duration;
            int currentMeeting = Integer.parseInt(meetings.get(i).split(",")[0]);
            if (meetingLength > currentMeeting) {
                totalConflictTime += meetingLength - currentMeeting;
                numConflicts += 1;
            }
        }
        if (numConflicts == 0) {
            return "good";
        } else {
            return "conflict," + numConflicts + "," + totalConflictTime;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int meetingsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> meetings = IntStream.range(0, meetingsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String result = Result.conflictInfo(meetings);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
