const { MongoClient } = require('mongodb');
const readline = require('readline');

// Connection configuration
const connectionString = 'mongodb+srv://Micaela:Micaela@cluster0.7ny5ynf.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0ñ';
const dbName = 'Microphone';
const collectionName = 'microphone';

// Console interface
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Main function
async function main() {
  const client = new MongoClient(connectionString);
  
  try {
    await client.connect();
    console.log('Connected to MongoDB Atlas');
    
    const database = client.db(dbName);
    const collection = database.collection(collectionName);
    
    let option;
    do {
      console.log('\n=== MICROPHONE MANAGEMENT SYSTEM ===');
      console.log('1. Add microphone');
      console.log('2. List all microphones');
      console.log('3. Find microphone by ID');
      console.log('4. Update microphone');
      console.log('5. Delete microphone');
      console.log('0. Exit');
      
      option = await askQuestion('Select an option: ');
      
      switch (option) {
        case '1':
          await addMicrophone(collection);
          break;
        case '2':
          await listMicrophones(collection);
          break;
        case '3':
          await findMicrophoneById(collection);
          break;
        case '4':
          await updateMicrophone(collection);
          break;
        case '5':
          await deleteMicrophone(collection);
          break;
        case '0':
          console.log('Exiting system...');
          break;
        default:
          console.log('Invalid option');
      }
    } while (option !== '0');
    
  } catch (error) {
    console.error('Error:', error);
  } finally {
    await client.close();
    rl.close();
  }
}

// Helper functions
function askQuestion(question) {
  return new Promise(resolve => {
    rl.question(question, resolve);
  });
}

async function addMicrophone(collection) {
  console.log('\n--- ADD NEW MICROPHONE ---');
  
  const microphone = {
    id: await askQuestion('Microphone ID (e.g. 001): '),
    brand: await askQuestion('Brand (e.g. AudioTech): '),
    model: await askQuestion('Model (e.g. AT-1000): '),
    type: await askQuestion('Type (e.g. Condenser): '),
    color: await askQuestion('Color (e.g. Black): '),
    connection: await askQuestion('Connection (e.g. XLR): '),
    frequency: await askQuestion('Frequency (e.g. 20Hz-20kHz): '),
    sensitivity: await askQuestion('Sensitivity (e.g. -36dB): '),
    impedance: await askQuestion('Impedance (e.g. 250 ohms): '),
    price: await askQuestion('Price (e.g. 99.99): ')
  };
  
  const result = await collection.insertOne(microphone);
  console.log(`Microphone added with ID: ${result.insertedId}`);
}

async function listMicrophones(collection) {
  console.log('\n--- MICROPHONE LIST ---');
  const microphones = await collection.find().toArray();
  
  if (microphones.length === 0) {
    console.log('No microphones registered');
    return;
  }
  
  microphones.forEach(mic => {
    console.log(`
ID: ${mic.id}
Brand: ${mic.brand}
Model: ${mic.model}
Type: ${mic.type}
Color: ${mic.color}
Connection: ${mic.connection}
Frequency: ${mic.frequency}
Sensitivity: ${mic.sensitivity}
Impedance: ${mic.impedance}
Price: $${mic.price}
-----------------------------`);
  });
}

async function findMicrophoneById(collection) {
  const id = await askQuestion('Enter microphone ID to search: ');
  const mic = await collection.findOne({ id });
  
  if (mic) {
    console.log(`
=== MICROPHONE DETAILS ===
ID: ${mic.id}
Brand: ${mic.brand}
Model: ${mic.model}
Type: ${mic.type}
Color: ${mic.color}
Connection: ${mic.connection}
Frequency: ${mic.frequency}
Sensitivity: ${mic.sensitivity}
Impedance: ${mic.impedance}
Price: $${mic.price}`);
  } else {
    console.log('No microphone found with that ID');
  }
}

async function updateMicrophone(collection) {
  const id = await askQuestion('Enter microphone ID to update: ');
  
  const updates = {};
  const fields = ['brand', 'model', 'type', 'color', 'connection', 'frequency', 'sensitivity', 'impedance', 'price'];
  
  for (const field of fields) {
    const value = await askQuestion(`New value for ${field} (leave empty to keep current): `);
    if (value) updates[field] = value;
  }
  
  if (Object.keys(updates).length === 0) {
    console.log('No changes made');
    return;
  }
  
  const result = await collection.updateOne({ id }, { $set: updates });
  
  if (result.modifiedCount > 0) {
    console.log('Microphone updated successfully');
  } else {
    console.log('No microphone found with that ID');
  }
}

async function deleteMicrophone(collection) {
  const id = await askQuestion('Enter microphone ID to delete: ');
  const result = await collection.deleteOne({ id });
  
  if (result.deletedCount > 0) {
    console.log('Microphone deleted successfully');
  } else {
    console.log('No microphone found with that ID');
  }
}

// Start application
main().catch(console.error);