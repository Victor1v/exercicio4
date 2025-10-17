import java.net.http.*;
import java.net.URI;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class TextAnalysis {
    public static void main(String[] args) throws Exception {
        String endpoint = "https://<SEU-ENDPOINT>.cognitiveservices.azure.com/";
        String apiKey = "<SUA-CHAVE>";

        String url = endpoint + "text/analytics/v3.1/sentiment";
        String body = """
        {
            "documents": [
                { "id": "1", "language": "pt", "text": "Eu adoro estudar computação na PUC Minas!" },
                { "id": "2", "language": "pt", "text": "Hoje o dia está horrível." }
            ]
        }
        """;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Ocp-Apim-Subscription-Key", apiKey)
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(body))
            .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
