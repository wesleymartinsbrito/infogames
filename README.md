# InfoGames 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/wesleymartinsbrito/api-school/blob/main/LICENSE) 

# Sobre o projeto

Uma API Rest que disponibiliza o endpoint /games e /lists por meio do qual pode-se obter uma lista de jogos, lista filtradas por tipos, além de permitir a criação, atualização e exclusão dos jogos e listas por completo ou de pontos específicos de cada um. Os jogos e listas já possuem seed inicial para testes, porém, é possível excluir ou atualizar os dados pré-existentes. Um jogo é atribuido a uma lista e uma lista a vários jogos. 

## Diagrama
![Diagrama de classes](https://github.com/wesleymartinsbrito/api-school/blob/main/assets/Screenshot_194.png)

## Resultado esperado
![Resultado](https://github.com/wesleymartinsbrito/api-school/blob/main/assets/Screenshot_195.png)

# Utilizações
## Back end
-	Web Server (Tom Cat)
-	App Spring Boot Java
-	Multi-threading
-	Mapeamento de URL
-	Serialização JSON

# Como executar o projeto

1 – Iniciei o projeto pelo Spring initializr

2 – Com a criação do pacote Entity, criei as classes Student e Class com seus respectivos getters and setters e construtores.

3 – Criei o subpacote Controller da entidade Student para que seja possível a criação do endpoint, a notação @RestController configura que a classe possa responder a API, com a @RequestMapping foi possível definir o caminho do endpoint. Logo após foi inserido uma função com algumas instâncias de objeto para estar iniciando, essa função retornará os estudantes cadastrado. A notação @GetMapping definirá que essa função será a resposta para a requisição GET desse endpoint.

4 – Foi criado um atributo na classe Student do tipo Class para definir a associação.


## Back end
Pré-requisitos: Java 17

# Autor

Wesley Martins Brito

https://www.linkedin.com/in/wesleymartinsbrito
