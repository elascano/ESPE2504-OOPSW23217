const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const microphone = {};
const fields = [
  'id',
  'brand',
  'model',
  'type',
  'color',
  'connection',
  'frequency',
  'sensitivity',
  'impedance',
  'price'
];

let index = 0;

function askData() {
  if (index < fields.length) {
    rl.question(`Enter ${fields[index]}:`, (answer) => {
      microphone[fields[index]] = answer;
      index++;
      askData();
    });
  } else {
    fs.writeFile('microphone.json', JSON.stringify(microphone, null, 2), (err) => {
      if (err) {
        console.error('Error saving file:', err);
      } else {
        console.log('microphone.json" saved successfully.');
      }
      rl.close();
    });
  }
}

askData();