package org.delazeri.designpatterns.builder;

import org.delazeri.designpatterns.builder.src.EmailClientConfig;

public class BuilderApplication {
    public static void main(String[] args) {

        /*
          O Builder é um design pattern criacional, e se torna útil nos seguintes casos:

           - Quando há um objeto com muitos atributos opcionais: Usar um construtor em objetos com muitos argumentos,
             pode ser confuso e propenso a erros, o Builder permite configurar apenas os atributos necessários.

           - Aprimoramento da legibilidade do código: Com o padrão Builder, principalmente em casos aonde temos objetos
             com muitos atributos, fica muito mais legível a leitura do código.

           - Encapsulamento da lógica de construção: Com o builder, a lógica de construção do objeto é isolada no Builder,
             facilitando a manutenção e evitando que a lógica de contrução se espalhe por vários lugares do código.

         */

        /*
            Nesse caso, eu inicio um objeto do tipo EmailClientConfig apenas usando os parametros obrigatórios que são
            server e port. Os parametros obrigatórios do objeto iniciado pelo Builder devem estar no metódo construtor
            do Builder.
         */

        EmailClientConfig emailClientConfigRaw = new EmailClientConfig.Builder(
                "https://server-url.com",
                8080)
                .build();

        /*
            Nesse outro caso, eu faço a mesma coisa que no anterior, porém passo o username ao iniciar o objeto.
            Como username não é um atributo obrigatório, ele pode ser chamado através da função setUsername()
         */

        EmailClientConfig emailClientConfigWithUsername = new EmailClientConfig.Builder(
                "https://server-url.com",
                8080)
                .setUsername("username")
                .build();
    }
}
