package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EightSpeedGearBox {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] token = line.split("\\s");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < token.length; i++) {
            list.add(Integer.parseInt(token[i]));
        }
        int ascend = 0;
        int descend = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) continue;
            if (list.get(i) > list.get(i + 1)) descend++;
            else ascend++;
        }
        if (ascend == 0 && descend != 0) System.out.println("descending");
        else if (descend == 0 && ascend != 0) System.out.println("ascending");
        else System.out.println("mixed");
    }
}
