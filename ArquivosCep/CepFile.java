package ArquivosCep;
import TratamentoDados.GsonData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CepFile {


    public CepFile(GsonData objJson) {


            try {
                File cepConsultado = new File("src\\ArquivosCep\\cepsBuscado.json");
                if (cepConsultado.createNewFile()) {
                    System.out.println("arquivo criado " + cepConsultado.getName());
                    try {
                        FileWriter arquivoExistente = new FileWriter("cepsBuscadoss.json",true);// true abre o arquivo em modo append

                        arquivoExistente.write(objJson.retornaParaJson());
                        arquivoExistente.close();
                    }catch (IOException e ){
                        System.out.println("ocorreu um erro ao abrir o arquivo");
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("O arquivo ja existe");
                    try {
                        FileWriter arquivoExistente = new FileWriter("cepsBuscadoss.json",true);
                        arquivoExistente.write(objJson.retornaParaJson());
                        arquivoExistente.close();
                        System.out.println("arquivo fechado com sucesso");
                    }catch (IOException e ){
                        System.out.println("ocorreu um erro ao abrir o arquivo");
                        e.printStackTrace();
                    }


                }


            } catch (IOException e) {
                System.out.println("ocorreu um erro ao criar o arquivo");
                e.printStackTrace();
            }






    }


}
