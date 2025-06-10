const fs = require('fs');
const readline = require('readline');

// Clase Student con 10 atributos
class Student {
    constructor(id, name, age, email, phone, major, gpa, address, gender, enrolled) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.major = major;
        this.gpa = gpa;
        this.address = address;
        this.gender = gender;
        this.enrolled = enrolled;
    }
}

// Función para leer estudiantes del archivo JSON
function readStudents() {
    if (!fs.existsSync('students.json')) {
        return [];
    }
    const data = fs.readFileSync('students.json', 'utf8');
    return JSON.parse(data);
}

// Función para guardar estudiantes en el archivo JSON
function saveStudents(students) {
    fs.writeFileSync('students.json', JSON.stringify(students, null, 2));
}

// Función para crear un nuevo estudiante
async function createStudent(rl) {
    const questions = [
        "ID: ", "Name: ", "Age: ", "Email: ", "Phone: ",
        "Major: ", "GPA: ", "Address: ", "Gender: ", "Enrolled (true/false): "
    ];

    const answers = [];
    for (const question of questions) {
        answers.push(await ask(rl, question));
    }

    const student = new Student(
        answers[0], answers[1], parseInt(answers[2]), answers[3], answers[4],
        answers[5], parseFloat(answers[6]), answers[7], answers[8], answers[9] === 'true'
    );

    const students = readStudents();
    students.push(student);
    saveStudents(students);
    console.log("Estudiante agregado correctamente.");
}

// Leer todos los estudiantes
function listStudents() {
    const students = readStudents();
    if (students.length === 0) {
        console.log("No hay estudiantes registrados.");
    } else {
        console.table(students);
    }
}

// Actualizar estudiante por ID
async function updateStudent(rl) {
    const id = await ask(rl, "Ingrese el ID del estudiante a actualizar: ");
    const students = readStudents();
    const index = students.findIndex(s => s.id === id);
    if (index === -1) {
        console.log("❌ Estudiante no encontrado.");
        return;
    }

    console.log("Ingrese los nuevos valores:");
    const questions = [
        "Name: ", "Age: ", "Email: ", "Phone: ", "Major: ",
        "GPA: ", "Address: ", "Gender: ", "Enrolled (true/false): "
    ];
    const answers = [];
    for (const question of questions) {
        answers.push(await ask(rl, question));
    }

    students[index].name = answers[0];
    students[index].age = parseInt(answers[1]);
    students[index].email = answers[2];
    students[index].phone = answers[3];
    students[index].major = answers[4];
    students[index].gpa = parseFloat(answers[5]);
    students[index].address = answers[6];
    students[index].gender = answers[7];
    students[index].enrolled = answers[8] === 'true';

    saveStudents(students);
    console.log("Estudiante actualizado.");
}

// Eliminar estudiante por ID
async function deleteStudent(rl) {
    const id = await ask(rl, "Ingrese el ID del estudiante a eliminar: ");
    let students = readStudents();
    const newStudents = students.filter(s => s.id !== id);
    if (students.length === newStudents.length) {
        console.log("No se encontró un estudiante con ese ID.");
    } else {
        saveStudents(newStudents);
        console.log("Estudiante eliminado.");
    }
}

// Utilidad para hacer preguntas en consola
function ask(rl, question) {
    return new Promise(resolve => rl.question(question, resolve));
}

// Menú principal
async function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    while (true) {
        console.log("\n=== CRUD de Estudiantes ===");
        console.log("1. Crear estudiante");
        console.log("2. Listar estudiantes");
        console.log("3. Actualizar estudiante");
        console.log("4. Eliminar estudiante");
        console.log("5. Salir");

        const choice = await ask(rl, "Seleccione una opción: ");
        switch (choice) {
            case '1': await createStudent(rl); break;
            case '2': listStudents(); break;
            case '3': await updateStudent(rl); break;
            case '4': await deleteStudent(rl); break;
            case '5': rl.close(); return;
            default: console.log("❗ Opción inválida");
        }
    }
}

main();
