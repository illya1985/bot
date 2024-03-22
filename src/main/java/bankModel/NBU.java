package bankModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
 /*[{        "r030":840,"txt":"Долар США","rate":38.9744,"cc":"USD","exchangedate":"19.03.2024"},{
        "r030":978,"txt":"Євро","rate":42.447,"cc":"EUR","exchangedate":"19.03.2024" }]
     */
public class NBU {
    int r030;
    //int currencyCodeB;
    String date;
    float rate;
    //float rateBuy;
//float rateCross;
}