# MoisesEstevaoAPI
Back-end do meu website pessoal. Construído com Spring (Boot, Security, Data JPA, Hibernate, PostgreSQL/MySQL) na Linguagem Java.
<br>
Atualmente a API possui apenas dois endpoints, devido a sua simples funcionalidade de receber mensagens da aplicação cliente <a href="https://moisesui.herokuapp.com/">MoisesUI<a>.
<br>
# /auth - POST
Endpoint destinado a autenticação do usuário, recebendo um Objeto FormLogin, que possui as propriedades 'username' e 'password'.
# /mensagem - POST
Endpoint destinado ao recebimento de objetos do tipo Mensagem, com parâmetros do front-end. Esse endpoint também conta com um sistema anti-spam, que rejeita quaisquer chamados que forem feitos seguidos, num intervalo de 5 segundos após a última requisição.
