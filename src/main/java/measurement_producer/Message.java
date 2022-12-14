package measurement_producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Long timestamp;
    private String device_id;
    private Double measurement_value;

/*
    {
        “timestamp": 1570654800000,
        “device_id”: “5c2494a3-1140-4c7a-991a-a1a2561c6bc2”
        “measurement_value”: 0.1,
    }
*/
}
