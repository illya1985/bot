package bankModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonoBank {
    int currencyCodeA;
    int currencyCodeB;
    long date;
    float rateSell;
    float rateBuy;
    float rateCross;
}
