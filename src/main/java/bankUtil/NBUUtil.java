package bankUtil;
import bankModel.NBU;

import java.util.List;

public class NBUUtil  implements BankUtil {
    private List<NBU> nbuList;
    private int reduction;

    public NBUUtil(List<NBU> nbuList){
        this.nbuList = nbuList;
    }
    @Override
    public void setReduction(int numberAfterComa) {
        reduction = numberAfterComa;
    }
    @Override
    public  String getUSD() {
        NBU nbu = new NBU();
        for (NBU element : nbuList) {
            if (element.getR030() == 840) {
                nbu = element;
            }
        }

        return String.format("course in Monobank USD/UAH\npurchase: %." + reduction + "f" +
                        "\nselling: %." + reduction + "f",
                nbu.getRate(), nbu.getRate());
    }
    @Override
    public  String getEUR() {
        NBU nbu = new NBU();
        for (NBU element : nbuList) {
            if (element.getR030() == 978) {
                nbu = element;
            }
        }
        return String.format("course in NBU EUR/UAH\npurchase: %."+reduction+"f" +
                        "\nselling: %."+reduction+"f",
                nbu.getRate(), nbu.getRate());
    }
}