import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetPojo {


    public String id;
    public String name;
    public Data data;


    public GetPojo() {
        super();
    }

    @Override
    public String toString() {
        return "ObjectPojo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }

    class Data {

        public String color;
        public String capacity;
        @JsonProperty("capacity GB")
        public int capacity_GB;
        public double price;
        public String generation;
        public int year;
        @JsonProperty("CPU model")
        public String cPU_model;
        @JsonProperty("Hard disk size")
        public String hard_disk_size;
        @JsonProperty("Strap Colour")
        public String strap_Colour;
        @JsonProperty("Case Size")
        public String case_Size;

        @JsonProperty("Description")
        public String description;

        @JsonProperty("Screen size")
        public double screen_size;


        public Data() {
            super();
        }


        @Override
        public String toString() {
            return "Data{" +
                    "color='" + color + '\'' +
                    ", capacity='" + capacity + '\'' +
                    ", capacity_GB=" + capacity_GB +
                    ", price=" + price +
                    ", generation='" + generation + '\'' +
                    ", year=" + year +
                    ", cPU_model='" + cPU_model + '\'' +
                    ", hard_disk_size='" + hard_disk_size + '\'' +
                    ", strap_Colour='" + strap_Colour + '\'' +
                    ", case_Size='" + case_Size + '\'' +
                    ", description='" + description + '\'' +
                    ", screen_size=" + screen_size +
                    '}';
        }
    }
}
