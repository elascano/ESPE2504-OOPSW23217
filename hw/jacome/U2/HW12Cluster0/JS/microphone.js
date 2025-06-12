const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

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
const microphone = {};

function askData() {
  if (index < fields.length) {
    rl.question(`Enter ${fields[index]}:`, (answer) => {
      microphone[fields[index]] = answer;
      index++;
      askData();
    });
  } else {
    
    fs.readFile('microphone.json', 'utf8', (err, data) => {
      let existingData = [];
      
      if (!err) {
        
        try {
          existingData = JSON.parse(data);
        } catch (parseError) {
          console.log('Error parsing the existing data, starting fresh.');
        }
      }

      
      existingData.push(microphone);

      
      fs.writeFile('microphone.json', JSON.stringify(existingData, null, 2), (err) => {
        if (err) {
          console.error('Error saving file:', err);
        } else {
          console.log('microphone.json saved successfully.');
        }
        rl.close();
      });
    });
  }
}

askData();
