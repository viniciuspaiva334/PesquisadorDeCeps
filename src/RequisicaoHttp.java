import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoHttp {

    public RequisicaoHttp(String cep) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder().uri(URI.create("viacep.com.br/ws/"+cep+"/json/")).build();

        HttpResponse<String> response = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
    }


}
