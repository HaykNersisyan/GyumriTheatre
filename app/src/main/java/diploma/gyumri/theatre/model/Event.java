package diploma.gyumri.theatre.model;

import lombok.Data;

/**
 * Created by sofi on 7/27/17.
 */

public
@Data
class Event {
    private String name;
    private String desc;
    private String price;
    private String stage;
    private String date;
    private String imgUrl;
    private String videoUrl;


    @Override
    public String toString() {
        return "EventDTO{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", stage='" + stage + '\'' +
                ", date='" + date + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
