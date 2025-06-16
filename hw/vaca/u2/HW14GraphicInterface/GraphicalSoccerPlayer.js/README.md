1. CREATE (POST)
curl -X POST http://localhost:8000/players \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Player",
    "position": "Striker",
    "club": "FC Barcelona",
    "nationality": "Spain",
    "age": 25
  }'
  2. 
  curl http://localhost:8000/players
  3. 
  curl http://localhost:8000/players/684f6e6bee5313ff4fc0211f
  4. UPDATE (PUT)
  curl -X PUT http://localhost:8000/players/684f6e6bee5313ff4fc0211f \
  -H "Content-Type: application/json" \
  -d '{
    "club": "Real Madrid",
    "age": 26
  }'
  5. 
  curl -X DELETE http://localhost:8000/players/684f6e6bee5313ff4fc0211f