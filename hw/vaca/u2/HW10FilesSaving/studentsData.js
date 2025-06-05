const fs = require('fs');
const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const data = {};

function askForData() {
  rl.question('\nEnter data type (key) or "save" to finish: ', (key) => {
    if (!key) {
      console.log('Please enter a valid key or "save"');
      return askForData();
    }

    if (key.trim().toLowerCase() === 'save') {
      saveToJson();
      return;
    }

    rl.question(`Enter value for "${key}": `, (value) => {
      if (!value) {
        console.log('Please enter a value');
        return askForData();
      }

      if (!isNaN(value)) {
        data[key] = Number(value);
      } else if (value.toLowerCase() === 'true') {
        data[key] = true;
      } else if (value.toLowerCase() === 'false') {
        data[key] = false;
      } else {
        data[key] = value;
      }

      console.log(`Added: ${key} = ${data[key]}`);
      askForData();
    });
  });
}

function saveToJson() {
  const filename = 'data.json';
  fs.writeFile(filename, JSON.stringify(data, null, 2), (err) => {
    if (err) {
      console.error('Error saving file:', err);
    } else {
      console.log(`\nSuccess! Data saved to ${filename}`);
      console.log('File content:');
      console.log(JSON.stringify(data, null, 2));
    }
    rl.close();
    process.exit(0);
  });
}

console.log('\n=== Student Data into a JSON File ===');
console.log('- Type "save" when done');

askForData();

rl.on('close', () => {
  console.log('\nProgram exited');
  process.exit(0);
});