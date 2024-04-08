package com.httpexamples;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    public PostRequest() throws FileNotFoundException {
    }

    // Definição da URL alvo das requisições POST HTTP
    public static final String URL_POST = "http://httpbin.org/forms/post";

    // Conteúdo do payload da mensagem a ser enviada, num arquivo JSON
    public static final String FILE_JSON = "pedido.json";

    // Cliente HTTP
    HttpClient client = HttpClient.newHttpClient();

    // Criação da requisição com método POST
    // Através do BodyPyblisher.ofFile() enviamos o contepudo a partir de um arquivo.
    // Utilizamos Path.of() para definir o arquivo
    HttpRequest request = HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
            .timeout(Duration.ofSeconds(10))
            .uri(URI.create(URL_POST))
            .build();

    // Envio da request
    // Conexão assíncrona - o servidor precisa receber e processar o conteúdo antes de responder.
    // Definimos que a resposta deve ser tratada como string - BodyHandlers.ofString().
    // A resposta deve ser aplicada como corpo da mensagem - thenApply(HttpResponse::body).
    // Uma vez definidos os parâmetros, setamos o .join() para estabelecer a conexão
    public void sendPOSTRequest() {
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }



}
