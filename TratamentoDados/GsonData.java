package TratamentoDados;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tratamentoApi.ViaCep;

import java.net.http.HttpResponse;

public class GsonData {
    private final String bodyGson ;
    private final Gson  dadosRequisicao = new GsonBuilder().create();
    ViaCep cepDados1;

    ViaCep cepDados;

    public GsonData(   HttpResponse<String> response ) {


      ViaCep cepDados = dadosRequisicao.fromJson(response.body(), ViaCep.class );


        bodyGson= dadosRequisicao.toJson(cepDados);
        System.out.println("saida"+bodyGson);

     }
     public Gson retornaGson(){
        return dadosRequisicao;
     }
     public String retornaParaJson(){
       return bodyGson;
     }
     public String getParaJson(){
         System.out.println("dado formatado");
         return bodyGson;
     }
    public String getBodyGson(){
        return bodyGson;
    }
}
