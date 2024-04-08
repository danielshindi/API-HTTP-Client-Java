package com.httpexamples;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Criação de uma instância de getRequest
        GetRequest getRequest = new GetRequest();

        System.out.println("Impressão do resultado obtido pelo getRequest:\n");

        // Impressão do resultado obtido pelo getRequest
        getRequest.printGETContent();




       // Criação de uma instância de PostRequest
        PostRequest postRequest = new PostRequest();

        System.out.println("\nImpressão do resultado obtido de postRequest:\n");

       //Chamada do método sendPostRequest
        postRequest.sendPOSTRequest();


        // Imprimindo agente que realizou a requisição POST
        System.out.println(postRequest.request.bodyPublisher());

    }
}
