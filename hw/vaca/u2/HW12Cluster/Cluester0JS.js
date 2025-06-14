const mongoose = require('mongoose');
const readline = require('readline');
require('dotenv').config();

//Modelo de Estudiante
const Student = mongoose.model('Student', new mongoose.Schema({
        id: { type: String, required: true, unique: true },
        name: { type: String, required: true },
        age: { type: Number, min: 16, max: 99 },
        email: { type: String, required: true, match: /.+\@.+\..+/ },
        gpa: { type: Number, min: 0, max: 4 },
        address: String,
        gender: { type: String, enum: ['Male', 'Female', 'Other'] },
    }));

// Configuración de la conexión
const MONGODB_URI = 'mongodb+srv://KevinV593:KevinV593@cluster0.7ufczsp.mongodb.net/studentsDB?retryWrites=true&w=majority&appName=Cluster0';

function ask(rl, question) {
    return new Promise(resolve => rl.question(question, resolve));
}

async function createStudent(rl) {
    try {
        const questions = [
            "ID: ", "Name: ", "Age: ", "Email: ", "Phone: ",
            "Major: ", "GPA: ", "Address: ", "Gender (Male/Female/Other): ", 
            "Enrolled (true/false): "
        ];

        const answers = [];
        for (const q of questions) {
            answers.push(await ask(rl, q));
        }

        const newStudent = new Student({
            id: answers[0],
            name: answers[1],
            age: parseInt(answers[2]),
            email: answers[3],
            gpa: parseFloat(answers[6]),
            address: answers[7],
            gender: answers[8],
        });

        await newStudent.save();
        console.log("Estudiante guardado en MongoDB.");
    } catch (error) {
        if (error.name === 'ValidationError') {
            console.log("Error de validación:", error.message);
        } else if (error.code === 11000) {
            console.log("ID duplicado: ya existe un estudiante con este ID");
        } else {
            console.log("Error inesperado:", error.message);
        }
    }
}

async function listStudents() {
    try {
        const students = await Student.find({});
        if (students.length === 0) {
            console.log("No hay estudiantes registrados.");
        } else {
            console.table(students.map(s => s.toObject()));
        }
    } catch (error) {
        console.log("Error al listar estudiantes:", error.message);
    }
}

async function updateStudent(rl) {
    try {
        const id = await ask(rl, "Ingrese el ID del estudiante a actualizar: ");
        const student = await Student.findOne({ id });
        if (!student) {
            console.log("Estudiante no encontrado.");
            return;
        }

        const questions = [
            "Name: ", "Age: ", "Email: ", "Phone: ", "Major: ",
            "GPA: ", "Address: ", "Gender (Male/Female/Other): ", 
            "Enrolled (true/false): "
        ];

        const answers = [];
        for (const q of questions) {
            answers.push(await ask(rl, q));
        }

        Object.assign(student, {
            name: answers[0],
            age: parseInt(answers[1]),
            email: answers[2],
            gpa: parseFloat(answers[3]),
            address: answers[4],
            gender: answers[5],
        });

        await student.save();
        console.log("Estudiante actualizado.");
    } catch (error) {
        console.log("Error al actualizar estudiante:", error.message);
    }
}

async function deleteStudent(rl) {
    try {
        const id = await ask(rl, "Ingrese el ID del estudiante a eliminar: ");
        const result = await Student.deleteOne({ id });
        if (result.deletedCount === 0) {
            console.log("Estudiante no encontrado.");
        } else {
            console.log("🗑️ Estudiante eliminado.");
        }
    } catch (error) {
        console.log("Error al eliminar estudiante:", error.message);
    }
}

// Menú principal y conexión
async function main() {
    try {
        // Reemplaza <db_password> con tu contraseña real
        const uri = MONGODB_URI.replace('<db_password>', process.env.DB_PASSWORD || 'tu_contraseña');
        
        await mongoose.connect(uri, {
            useNewUrlParser: true,
            useUnifiedTopology: true,
            serverSelectionTimeoutMS: 5000,
            socketTimeoutMS: 30000
        });
        console.log("✅ Conectado a MongoDB Atlas");

        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        while (true) {
            console.log("\n=== CRUD de Estudiantes (MongoDB) ===");
            console.log("1. Crear estudiante");
            console.log("2. Listar estudiantes");
            console.log("3. Actualizar estudiante");
            console.log("4. Eliminar estudiante");
            console.log("5. Salir");

            const choice = await ask(rl, "Seleccione una opción: ");
            switch (choice) {
                case '1': await createStudent(rl); break;
                case '2': await listStudents(); break;
                case '3': await updateStudent(rl); break;
                case '4': await deleteStudent(rl); break;
                case '5':
                    rl.close();
                    await mongoose.disconnect();
                    console.log("🔌 Desconectado de MongoDB. Saliendo...");
                    return;
                default: console.log("❗ Opción inválida");
            }
        }
    } catch (err) {
        console.error("Error:", err);
        process.exit(1);
    }
}

main();