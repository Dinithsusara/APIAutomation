import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreatePojo {


    public String name;
    public Data data;

    public static class Data {
        public int year;
        public double price;
        @JsonProperty("CPU model")
        public String cPU_model;
        @JsonProperty("Hard disk size")
        public String hard_disk_size;

        public Data(int year, double price, String cPU_model, String hard_disk_size) {
            this.year = year;
            this.price = price;
            this.cPU_model = cPU_model;
            this.hard_disk_size = hard_disk_size;
        }
    }
}
