curl http://localhost/botTeste
curl http://localhost/listarBots
curl -i -X POST -H "Content-Type:application/json" -d '{"id": "9", "nome": "nomeatualizado"}' http://localhost/bot
curl http://localhost/bot/9
curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "novobot"}' http://localhost/bot
curl http://localhost/bot/9/deleta


