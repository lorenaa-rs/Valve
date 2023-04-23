# Valve
Manual prueba Valvi.


GET  /api/players : Devuelve los jugadores registrados
GET   api/players/{id} :   Devuelve el jugador con el id ingresado
POST  /api/player : Registra un jugador por medio del RequestBody : 
Tiene las validaciones para que el username y email, no se puedan repetir.
{
    "email": "ejemplo@gmail.com",
    "firstName": "Juan",
    "lastName": "Pérez",
    "username": "jperez",
    "age": 25,
    "gender": "masculino"
}

GET  /api/games : Devuelve los juegos registrados
GET   api/games/{id} :   Devuelve el juego con el id ingresado
POST  /api/game : Registra un juego por medio del RequestBody : 
Tiene las validaciones para que el nombre no se pueda repetir.
{
    "name": "call of dutty",
    "description": "Game of war",
    "releaseDate": "2023-04-20",
    "rating": 9.5
}

POST /api/player-game-hours/create : Agrega horas a un jugador en un juego                                    determinado. Se realiza por medio del RequestBody : 
{
    "hours": 10,
    "playerId": 1,
    "gameId": 1
}
DELETE /api/player-game-hours/deleteHours : Elimina horas a un Jugador de un juego especifico. Se realiza por medio del RequestBody:
{
    "hours": 2,
    "playerId": 1,
    "gameId": 2
}


PUT /api/player-game-hours/updateHours : Edita las horas a un Jugador de un juego específico. Se realiza por medio del RequestBody:
{
    "hours": 2,
    "playerId": 1,
    "gameId": 2
}


GET /api/player-game-hours/top10players/{gameName}: Obtiene el top 10 de jugadores que más horas han jugado un juego. 


GET /api/player-game-hours/top10games/{username} : obtiene el top 10 juegos que más horas ha jugado un jugador en específico. Ingresa el username del jugador.


GET /api/player-game-hours/top10games : obtiene el top 10 de juegos más jugados por horas


GET /api/player-game-hours/top10players : obtiene el top 10 de jugadores que tienen más horas acumuladas.
