const fs = require('fs');
const { MongoClient } = require('mongodb');
const readline = require('readline');

// Configuration
const JSON_FILE = 'students.json';
const MONGO_URI = 'mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0';
const DB_NAME = 'school';
const COLLECTION_NAME = 'students';

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

async function main() {
  try {
    // Load existing data
    let jsonData = loadJsonData();
    displayStudents(jsonData.students);

    // Connect to MongoDB
    const client = new MongoClient(MONGO_URI);
    await client.connect();
    const collection = client.db(DB_NAME).collection(COLLECTION_NAME);

    // Add new student
    const newStudent = await getStudentData();
    jsonData.students.push(newStudent);

    // Update JSON file
    saveToJsonFile(jsonData);
    console.log('\nStudent added to JSON file');

    // Add to MongoDB
    await collection.insertOne(newStudent);
    console.log('Student added to MongoDB');

    await client.close();
    rl.close();
  } catch (error) {
    console.error('Error:', error);
  }
}

// Helper functions
function loadJsonData() {
  try {
    return JSON.parse(fs.readFileSync(JSON_FILE, 'utf8'));
  } catch (error) {
    return { students: [] }; // If file doesn't exist
  }
}

function saveToJsonFile(data) {
  fs.writeFileSync(JSON_FILE, JSON.stringify(data, null, 2));
}

function displayStudents(students) {
  console.log('\nCurrent students:');
  students.forEach(s => {
    console.log(`ID: ${s.id} | ${s.firstname} ${s.lastanme} | Age: ${s.age} | Salary: ${s.salary}`);
  });
}

async function getStudentData() {
  console.log('\n--- NEW STUDENT ---');
  return {
    id: parseInt(await askQuestion('ID: ')),
    lastanme: await askQuestion('Last Name: '),
    firstname: await askQuestion('First Name: '),
    age: parseInt(await askQuestion('Age: ')),
    salary: parseFloat(await askQuestion('Salary: '))
  };
}

function askQuestion(question) {
  return new Promise(resolve => {
    rl.question(question, resolve);
  });
}

main();