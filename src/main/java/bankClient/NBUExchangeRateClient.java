package bankClient;
import bankModel.NBU;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
public class NBUExchangeRateClient {

    private final String NBU_URI = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<NBU> getNBUExchangeRates() {

        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(NBU_URI))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(response.body(), new TypeReference<>() {
            });

        } catch (URISyntaxException e) {
            System.out.println("NBU URI SYNTAX EXCEPTION!");
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            System.out.println("NBU Json Mapping Exception!");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("NBU IOException!");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("NBU Interrupted Exception");
            throw new RuntimeException(e);
        }
    }
     class Main {
        public static void main(String[] args) {
            NBUExchangeRateClient client = new NBUExchangeRateClient();
            List<NBU> exchangeRates = client.getNBUExchangeRates();

            // Виведення JSON у консоль
            for (NBU nbu : exchangeRates) {
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    String json = mapper.writeValueAsString(nbu);
                    System.out.println(json);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
