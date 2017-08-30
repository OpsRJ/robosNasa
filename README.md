**Solução para resolver o problema de locomoção dos Robos da Nasa em Marte.**

Instruções para compilação e execução:

- Clonar este Repositório
- Executar o comando: **mvn clean install**
- Executar o jar: **java -jar nome\_do\_arquivo.jar**

Instruções de uso:

- curl -s --request POST [http://localhost:8080/rest/mars/MMRMMRMM](http://localhost:8080/rest/mars/MMRMMRMM)

Saída: (2, 0, S)

Status: 200

- curl -s --request POST [http://localhost:8080/rest/mars/](http://localhost:8080/rest/mars/MMRMMRMM)MMLMRMMRMMLMM

Saída: Erro ao se movimentar!

Status: 400

- curl -s --request POST [http://localhost:8080/rest/mars/](http://localhost:8080/rest/mars/MMRMMRMM)AAA

Saída: Comando Inválido

Status: 400
