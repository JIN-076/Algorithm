package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Meeting implements Comparable<Meeting> {
    String name;
    int begin;
    int end;
    Meeting(String name, int begin, int end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        if ((int)this.name.charAt(0) > (int)m.name.charAt(0)) return 1;
        else if (this.name.charAt(0) == m.name.charAt(0)) {
            if (this.begin > m.begin) return 1;
            else if (this.begin == m.begin) return 0;
            else return -1;
        }
        else return -1;
    }
}

class TimeTable {
    int begin;
    int end;
    TimeTable(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}

public class MeetingReservation {

    public static StringBuilder builder = new StringBuilder();

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] token = bufferedReader.readLine().split("\\s");
        int meeting = Integer.parseInt(token[0]);
        int available = Integer.parseInt(token[1]);

        String[] meetingRoom = new String[meeting];
        for (int i = 0; i < meeting; i++) {
            meetingRoom[i] = bufferedReader.readLine();
        }
        Arrays.sort(meetingRoom);

        ArrayList<Meeting> list = new ArrayList<>();

        for (int i = 0; i < available; i++) {
            token = bufferedReader.readLine().split("\\s");
            list.add(new Meeting(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2])));
        }

        Collections.sort(list);

        for (int i = 0; i < meetingRoom.length; i++) {

            int idx = 0;
            ArrayList<TimeTable> timeTable = new ArrayList<>();
            builder.append("Room " + meetingRoom[i] + ":").append("\n");

            int time = 9;
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(j).name.equals(meetingRoom[i])) continue;
                for (; time <= 18; time++) {
                    if (list.get(j).begin == time) {
                        time = list.get(j).end;
                        break;
                    } else {
                        idx += 1;
                        int tmp = list.get(j).begin;
                        timeTable.add(new TimeTable(time, tmp));
                        time = tmp - 1;
                    }
                }
            }

            if (time != 18) timeTable.add(new TimeTable(time, 18));

            if (timeTable.size() == 0) builder.append("Not available").append("\n");
            else {
                builder.append(timeTable.size()).append(" available").append("\n");
                for (int k = 0; k < timeTable.size(); k++) {
                    if (timeTable.get(k).begin == 9) {
                        builder.append("09-").append(timeTable.get(k).end).append("\n");
                    } else {
                        builder.append(timeTable.get(k).begin).append("-").append(timeTable.get(k).end).append("\n");
                    }
                }
            }
            if (i != meetingRoom.length - 1) builder.append("-----").append("\n");
        }
        System.out.println(builder);
    }
}
