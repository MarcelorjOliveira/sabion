Sabion Software

O software foi desenvolvido inicialmente com a anotaço @RestController mas depois foi trocada para a biblioteca Spring Data Rest devido a facilidade de fazer os relacionamentos de 1:N .
Foi utilizado Docker para levantar a aplicaçao devido a sua facilidade de configuração.
Sou bastante adepto do segundo principio do manifesto agil que e "Software em funcionamento mais que documentação abrangente" então documentar apenas o necessário e o codigo deve ser expressivo o suficiente para ser ententido. Comentários apenas em situações de muito dificil compreensão.
Seria interessante implementar uma cadeia de testes unitários mas o tempo não me permitiu.

Para rodar executar o comando |docker-compose up| no diretorio sabion.

Funcionalidades da API
Requisiçoes possiveis do bot
curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "umBot"}' http://localhost/bots - Cria um bot

curl http://localhost/bots/{id} - Retorna o bot

curl -i -X POST -H "Content-Type:application/json" -d '{"id": "9", "nome": "nomeatualizado"}' http://localhost/bots - Atualiza 
um bot

curl -i -X DELETE http://localhost/bots/{id} - Deleta o bot


Requisiçoes possiveis da mensagem
curl -i -X POST -H "Content-Type:application/json" -d '{"texto": "revista"}' http://localhost/mensagens - Registra uma nova mensagem

curl http://localhost/mensagens/{id} - Retorna uma mensagem pelo id

curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost/bots/{idbot}" http://localhost/mensagens/{idmensagem}/bot - Vincula a mensagem idmensagem ao bot idbot

curl http://localhost/bots/{id}/mensagens - Retorna as mensagens de um determinado bot


curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost/bots/17" http://localhost/mensagens/22/bot - Vincula a mensagem idmensagem ao bot idbot

