package measurement_producer;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetMeasures {
    public static List<Message> getMeasures() throws FileNotFoundException {
        List<Message> output = new ArrayList<>();
        File input = new File("C:\\Users\\maria.pasca\\IdeaProjects\\message\\src\\main\\resources\\sensor.csv");
        Scanner get_measures = new Scanner(input);
        ZonedDateTime crtTime = ZonedDateTime.now();

        while(get_measures.hasNext()){
            output.add(new Message(crtTime.toInstant().getEpochSecond(),
                            "device_test",
                            Double.parseDouble(get_measures.nextLine())));
            crtTime = crtTime.plusMinutes(10);
        }


        return output;
    }
}
