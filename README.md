## Design Patterns

1. [Builder](#builder)

## Builder

O Builder é um design pattern criacional, e se torna útil nos seguintes casos:

- **Quando há um objeto com muitos atributos opcionais**: Usar um construtor em objetos com muitos argumentos,
             pode ser confuso e propenso a erros, o Builder permite configurar apenas os atributos necessários.
- **Aprimoramento da legibilidade do código**: Com o padrão Builder, principalmente em casos aonde temos objetos
             com muitos atributos, fica muito mais legível a leitura do código.
- **Encapsulamento da lógica de construção**: Com o builder, a lógica de construção do objeto é isolada no Builder,
             facilitando a manutenção e evitando que a lógica de contrução se espalhe por vários lugares do código.
## 

**Exemplo:**

- Para demonstrar a utilização do Builder, irei usar uma classe de configuração de client de e-mail, com os atributos declarados no código abaixo:

```java
public class EmailClientConfig {

    private final String server;
    private final int port;
    private final String username;
    private final String password;
    private final boolean useSSL;
}
```

- Dentro da classe ```EmailClientConfig``` irei criar um construtor privado na classe, recebendo um EmailClientConfigBuilder:

```java
private EmailClientConfig(EmailClientConfigBuilder builder){
    this.server = builder.server;
    this.port = builder.port;
    this.username = builder.username;
    this.password = builder.password;
    this.useSSL = builder.useSSL;
}
```

- Ainda dentro de ```EmailClientConfig```, eu irei declarar uma classe pública e estática chamada ```EmailClientConfigBuilder```, que nada mais é que nosso Builder.

```java
public static class EmailClientConfigBuilder {
    private final String server;
    private final int port;
    private String username = "";
    private String password = "";
    private boolean useSSL = false;
}
```
- O construtor do builder deve ser público, e nele você pode colocar os atributos que correspondem com aqueles que sempre devem ser iniciados na classe a ser construída, como por exemplo no código a seguir, que vou incluir um construtor recebendo ```server``` e ```port``` e os demais atributos vou incluir através de metódos de acesso.

```java

public EmailClientConfigBuilder(String server, int port) {
    this.server = server;
    this.port = port;
}

public EmailClientConfigBuilder setUsername(String username) {
    this.username = username;
    return this;
}

public EmailClientConfigBuilder setPassword(String password) {
    this.password = password;
    return this;
}

public EmailClientConfigBuilder isUseSSL(boolean useSSL) {
    this.useSSL = useSSL;
    return this;
}

```

- Em todos métodos de acesso que são utilizados para definir um atributo do objeto, eu retorno a instância do Builder em questão, permitindo continuar na cadeia de Build.

- Por fim, é necessário definir um método build, que irá pegar todos atributos definidos até então e instanciar na nossa classe ```EmailClientConfig```.

```java
public EmailClientConfig build() {
    return new EmailClientConfig(this);
}
```

- O builder, então, instância um objeto do tipo ```EmailClientConfig``` e retorna para uso, agora veremos uma utilização dessas classes criadas:


```java
 EmailClientConfig emailClientConfigRaw = new EmailClientConfig.EmailClientConfigBuilder(
                    "https://server-url.com",
                    8080
                ).build();

                EmailClientConfig emailClientConfigWithUsername = new EmailClientConfig.EmailClientConfigBuilder(
                    "https://server-url.com",
                    8080
                ).setUsername("username")
                .build();
```

* Nessa demonstração, eu instânciei a classe ```EmailClientConfig``` duas vezes. Ambas tiveram que definir os valores de server e port, que são obrigatórios no construtor. Na primeira, eu defini apenas isso e chamei o método ```build()```, retornando uma instância da classe. Na segunda, utilizei novamente o build, mas no processo de build decidi definir o valor de ```username``` também. No fim das contas, ambas retornam uma instância de ```EmailClientConfig```, porém utilizando o padrão Build, podemos definir melhor os atributos que queremos nessa instância, evitando construtores complexos e confusos.
