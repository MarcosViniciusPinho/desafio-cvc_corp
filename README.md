# Desafio CVC Corp
Projeto feito com Spring Boot, para acessar a API existem dois recursos que são:
- Teste 1<br />
localhost:8081/api/hotels/city/1032/checkin/2018-05-20/checkout/2018-05-25/adultos/2/criancas/1<br /><br />
- Teste 2<br />
localhost:8081/api/hotels/1/checkin/2018-05-20/checkout/2018-05-25/adultos/2/criancas/1
<br /><br /> <strong>Não foi possível passar a data no padrão brasileiro pela URI(URL), pois o Spring se 'perde'.</strong><br /><br />
Para poder rodar o projeto localmente basta executar o comando no terminal: mvn clean spring-boot:run<br /><br />

Tecnologias utilizadas no Projeto:
- Spring Boot
- TDD
- RestTemplate
- Lombok
