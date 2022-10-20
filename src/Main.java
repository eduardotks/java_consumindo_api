import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        var url = "https://imdb-api.com/en/API/Top250Movies/k_puf8lzus/";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

        var p = new JsonParser();
        List<Map<String,String>> listItens = p.parse(body);

        for(Map<String,String> filme : listItens){
            String urlImg = filme.get("image");
            String nomeArquivo = filme.get("title");
            InputStream inputStream = new URL(urlImg).openStream();

            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);
            System.out.println(filme.get("id"));
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
        }

    }
}











