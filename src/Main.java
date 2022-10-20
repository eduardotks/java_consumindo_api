import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        var url = "https://imdb-api.com/API/Search/k_puf8lzus/leon%20the%20professional/";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

        var p = new JsonParser();
        List<Map<String,String>> listItens = p.parse(body);

        for(Map<String,String> filme : listItens){
            System.out.println(filme.get("id"));
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
        }
    }
}















