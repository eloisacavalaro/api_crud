package com.api.crud;


    import com.google.gson.Gson;
    
    import lombok.Data;
    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;
    
    @Data
    public class Endereco {
    
        private String cep;
        private String logradouro;
        private String bairro;
        private String localidade;
        private String uf;
        private String complemento;
    
        public static Endereco getEnderecoByCep(String cep){
    
            Endereco endereco = new Endereco();
            OkHttpClient client = new OkHttpClient();
    
            String url = "https://viacep.com.br/ws/" + cep + "/json/";
    
            Request request = new Request.Builder().
            url(url).
            build();
    
            System.out.println("\n" + request + "\n\n");
    
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null){
                    String result = response.body().string();
                    System.out.println(result);
    
                    // Mapper
                    Gson gson = new Gson();
                    endereco = gson.fromJson(result, Endereco.class);
    
                } else {
                    System.out.println("Erro ao buscar o CEP: " + response.code());
                }
            } catch (Exception e) {
                System.out.println("Erro ao buscar o CEP: " + e.getMessage());
            }
    
            return endereco;
        }
    }
    
    

