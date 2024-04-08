package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetRequest {

    public GetRequest() throws IOException, InterruptedException {
    }

    // Definição da URL alvo das requisições GET HTTP
    public static final String URL_GET = "http://httpbin.org/get";

    // Cliente HTTP
    // O método newHttpClient() retorna um cliente HTTP com as configurações padrão,
    // que incluem:
    //     - método de solicitação GET
    //     - preferência de HTTP / 2
    //     - política de redirecionamento de NUNCA
    //     - seletor de proxy padrão
    //     - contexto SSL padrão
    HttpClient client = HttpClient.newHttpClient();

    // Criação da requisição
    // Criamos a variável do tipo HttpRequest, na qual definimos os parâmetros:
    //      - método GET
    //      - time out da mensagem
    //      - URL de destino
    // finaliza-se com .build() para construir a requisição
    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .timeout(Duration.ofSeconds(10))
            .uri(URI.create(URL_GET))
            .build();

    // Envio da requisição
    // Uso do método .send() para envio da requisição criada anteriormente.
    // O método .send() utiliza 2 parâmetros:
    //      - a requisição que será enviada
    //      - um BodyHandlers, tratada como String
    // Esse método bloqueia o programa enquanto ocorre o envio da requisição
    // e consequentemente o recebimento do response.
    // "Para criação de um envio assíncrono usa-se o método sendAsync(HttpRequest, BOdyHandler)".
    // Toda a informação recebida, decorrente do envio da mensagem HTTP será armazenada na
    // variável response do  tipo HttpResponse
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Impressão do conteúdo recebido
    // Para verificar o conteúdo basta printar os atributos relacionados ao response.
    // Imprimindo status code e campo do pacote HTTP
    public void printGETContent() {
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }

}
