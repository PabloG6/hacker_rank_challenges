import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pablo on 1/22/2017.
 */
public class Duplicates {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String path = "C:\\Users\\Pablo\\IdeaProjects\\" +
                "HackerRankChallenges\\out\\production\\HackerRankChallenges\\myfile.txt";
        try {
            FileReader file = new FileReader(path);
            BufferedReader buffered = new BufferedReader(file);
            String line = null;
            while ((line= buffered.readLine()) != null) {
                map.put(line, map.getOrDefault(buffered, 0) + 1);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");

        } catch (IOException e) {

            e.printStackTrace();

        }

//        System.out.println(duplicates(map));
        duplicates(map);
    }


    public static String duplicates(HashMap<String, Integer> map){
        StringBuilder build = new StringBuilder();
        for(Map.Entry<String, Integer> a:map.entrySet()){
            String key = a.getKey();
            if(map.get(key)==1){
                System.out.printf("key %s, value %d \n", key, map.get(key));
                build.append(key+"\n");
            }
        }

        return build.toString();
    }
}

