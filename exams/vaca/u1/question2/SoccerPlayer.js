const fs = require('fs');

class SoccerPlayer {
    constructor(id, name, position, age) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
    }

    toCSV() {
        return `${this.id},${this.name},${this.position},${this.age}`;
    }

    static fromCSV(csvLine) {
        const [id, name, position, age] = csvLine.split(',');
        return new SoccerPlayer(parseInt(id), name, position, parseInt(age));
    }
}

const players = [
    new SoccerPlayer(1, 'Lionel Messi', 'Forward', 36),
    new SoccerPlayer(2, 'Alexander Dominguez', 'Keeper', 37),
    new SoccerPlayer(3, 'Cristiano Ronaldo', 'Forward', 40)
];

function writePlayersToCSV(filename, players) {
    const header = 'id,name,position,age\n';
    const data = players.map(p => p.toCSV()).join('\n');
    fs.writeFileSync(filename, header + data, 'utf8');
    console.log(`Players saved to ${filename}`);
}

function readPlayersFromCSV(filename) {
    const content = fs.readFileSync(filename, 'utf8');
    const lines = content.trim().split('\n');
    lines.shift(); // remove header
    const players = lines.map(line => SoccerPlayer.fromCSV(line));
    console.log(`Players read from ${filename}:`);
    players.forEach(p => {
        console.log(`ID: ${p.id}, Name: ${p.name}, Position: ${p.position}, Age: ${p.age}`);
    });
    return players;
}

const csvFile = 'players.csv';
writePlayersToCSV(csvFile, players);
readPlayersFromCSV(csvFile);