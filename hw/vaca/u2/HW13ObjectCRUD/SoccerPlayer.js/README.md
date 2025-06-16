curl http://localhost:8000/getPlayers
curl http://localhost:8000/players/1
curl -X PUT -H "Content-Type: application/json" -d '{"position":"Striker"}' http://localhost:8000/players/1
curl -X DELETE http://localhost:8000/players/1
in cmd