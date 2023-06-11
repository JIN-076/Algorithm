package softeer.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DutyTime {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            line = bufferedReader.readLine();
            String[] token = line.split("\\s");
            int hour = -1;
            int minute = -1;
            for (int j = 0; j < token.length; j++) {
                String[] time = token[j].split(":");
                if (hour == -1) hour = Integer.parseInt(time[0]);
                else {
                    hour = Math.abs(hour -= Integer.parseInt(time[0]));
                    answer += hour * 60;
                }
                if (minute == -1) minute = Integer.parseInt(time[1]);
                else {
                    if (minute > Integer.parseInt(time[1])) {
                        minute = 60 - minute + Integer.parseInt(time[1]);
                        answer += minute;
                        answer -= 60;
                    }
                    else {
                        minute = Math.abs(minute -= Integer.parseInt(time[1]));
                        answer += minute;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
