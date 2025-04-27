package HttpRequisition;
import ArquivosCep.CepFile;
import TratamentoDados.GsonData;
import com.google.gson.Gson;
import tratamentoApi.ViaCep;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import  java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RequisitionHttp {


    private String cep ;


    public String getCep() {
        return cep;
    }


    public RequisitionHttp() throws IOException, InterruptedException {
        System.out.println("digite o seu cep: ");
        Scanner inputUser  = new Scanner(System.in);
        this.cep = inputUser.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(("https://viacep.com.br/ws/"+cep+"/json/"))).build();

        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());


        GsonData tratamentoData = new GsonData( response );
        System.out.println("Dados do cep " +tratamentoData.getBodyGson());
        CepFile novoArquivo = new CepFile(tratamentoData);

    }


    
}
