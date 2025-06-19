const mongoose = require('mongoose');
const readline = require('readline');

// Esquema y modelo de Student (igual que antes)
const studentSchema = new mongoose.Schema({
    id: String,
    name: String,
    age: Number,
    email: String,
    phone: String,
    major: String,
    gpa: Number,
    address: String,
    gender: String,
    enrolled: Boolean
});

const Student = mongoose.model('Student', studentSchema);

function ask(rl, question) {
    return new Promise(resolve => rl.question(question, resolve));
}

async function createStudent(rl) {
    const questions = [
        "ID: ", "Name: ", "Age: ", "Email: ", "Phone: ",
        "Major: ", "GPA: ", "Address: ", "Gender: ", "Enrolled (true/false): "
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
        phone: answers[4],
        major: answers[5],
        gpa: parseFloat(answers[6]),
        address: answers[7],
        gender: answers[8],
        enrolled: answers[9].toLowerCase() === 'true'
    });

    await newStudent.save();
    console.log("✅ Estudiante guardado en MongoDB.");
}

async function listStudents() {
    const students = await Student.find({});
    if (students.length === 0) {
        console.log("No hay estudiantes registrados.");
    } else {
        console.table(students.map(s => s.toObject()));
    }
}

async function updateStudent(rl) {
    const id = await ask(rl, "Ingrese el ID del estudiante a actualizar: ");
    const student = await Student.findOne({ id });
    if (!student) {
        console.log("❌ Estudiante no encontrado.");
        return;
    }

    const questions = [
        "Name: ", "Age: ", "Email: ", "Phone: ", "Major: ",
        "GPA: ", "Address: ", "Gender: ", "Enrolled (true/false): "
    ];

    const answers = [];
    for (const q of questions) {
        answers.push(await ask(rl, q));
    }

    Object.assign(student, {
        name: answers[0],
        age: parseInt(answers[1]),
        email: answers[2],
        phone: answers[3],
        major: answers[4],
        gpa: parseFloat(answers[5]),
        address: answers[6],
        gender: answers[7],
        enrolled: answers[8].toLowerCase() === 'true'
    });

    await student.save();
    console.log("✅ Estudiante actualizado.");
}

async function deleteStudent(rl) {
    const id = await ask(rl, "Ingrese el ID del estudiante a eliminar: ");
    const result = await Student.deleteOne({ id });
    if (result.deletedCount === 0) {
        console.log("❌ Estudiante no encontrado.");
    } else {
        console.log("🗑️ Estudiante eliminado.");
    }
}

// MENÚ PRINCIPAL (con espera a conexión)
async function main() {
    try {
        await mongoose.connect('mongodb+srv://neolukk:neolukk@cluster0.gj7cw6m.mongodb.net/studentsDB?retryWrites=true&w=majority', {
            useNewUrlParser: true,
            useUnifiedTopology: true
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
        console.error("❌ Error:", err);
    }
}

main();
