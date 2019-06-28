# bestWorstList

## Pré-requsitos

Testado e executado em um Ubuntu

Para executar o projeto deve ter na máquina:
 * Java 11 instalado. Conforme:
  `sudo apt-get install openjdk-11-jdk`
 * Maven 3.X instalado
   `sudo apt-get install maven`
   
  ## Execução/Testes
  
  Para executar o projeto usar o comando na pasta do projeto:
  `mvn clean install`
  Depois
  `mvn spring-boot:run`
  
  Acessar a URL e verificar os dados:
  `http://localhost:8080/movies`
  
  Para executar o teste de integração rodar:
    `mvn clean verify`
    
  Caso seja necessário verificar o código fonte por ferramenta externa, deve-se instalar o Lombok a parte na sua IDE.
    
## Feito com

* Springboot
* Open JDK 11
* Lombok
* Maven
   
