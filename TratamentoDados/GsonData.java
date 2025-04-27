package TratamentoDados;

import com.google.gson.Gson;
import tratamentoApi.ViaCep;

public class GsonData {
    private final String bodyGson ;
    public GsonData(String responseBody) {

      Gson  dadosRequisicao = new Gson();
      ViaCep cepDados = dadosRequisicao.fromJson(responseBody, ViaCep.class );
      bodyGson = cepDados.toString();

     }

    public String getBodyGson(){
        return bodyGson;
    }
}
