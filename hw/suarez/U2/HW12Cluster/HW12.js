//bs hw13 oop

const mongoose = require('mongoose');
const readline = require('readline');

const studentSchema = new mongoose.Schema({
    id: String,
    lastName: String,
    firstName: String,
    age: Number,
    salary: Number,
});

const Student = mongoose.model('Student', studentSchema);

function ask(rl, question) {
    return new Promise(resolve => rl.question(question, resolve));
}

async function createStudent(rl) {
    const questions = [
        "ID: ", "Last Name: ", "First Name: ", "Age: ", "Salary: " ];

    const answers = [];
    for (const q of questions) {
        answers.push(await ask(rl, q));
    }

    const newStudent = new Student({
        id: answers[0],
        lastName: answers[1],
        firstName: answers[2],
        age: parseInt(answers[3]),
        salary: parseInt(answers[4]),
    });

    await newStudent.save();
    console.log("Student saved in DB!");
}

async function listStudents() {
    const students = await Student.find({});
    if (students.length === 0) {
        console.log("There are not registered students!");
    } else {
        console.table(students.map(s => s.toObject()));
    }
}

async function updateStudent(rl) {
    const id = await ask(rl, "Enter the updated student ID!");
    const student = await Student.findOne({ id });
    if (!student) {
        console.log("Student not found!");
        return;
    }

    const questions = [
        "ID: ", "Last Name: ", "First Name: ", "Age: ", "Salary: " ];

    const answers = [];
    for (const q of questions) {
        answers.push(await ask(rl, q));
    }

    Object.assign(student, {
        id: answers[0],
        lastName: answers[1],
        firstName: answers[2],
        age: parseInt(answers[3]),
        salary: parseInt(answers[4]),
    });

    await student.save();
    console.log("Student updated!");
}

async function deleteStudent(rl) {
    const id = await ask(rl, "Enter removed student ID!");
    const result = await Student.deleteOne({ id });
    if (result.deletedCount === 0) {
        console.log("Student not found!");
    } else {
        console.log("Student was removed!");
    }
}

async function main() {
    try {
        await mongoose.connect('mongodb+srv://bsuarez:<bsuarez>@cluster0.dlcnbx5.mongodb.net/', {
            useNewUrlParser: true,
            useUnifiedTopology: true
        });
        console.log("CONNECTED TO DB");

        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        while (true) {
            console.log("\n~~ STUDENTS CRUD ~~~");
            console.log("1. Create student");
            console.log("2. List student");
            console.log("3. Update student");
            console.log("4. Delete student");
            console.log("5. Exit");

            const choice = await ask(rl, "Choose an option: ");
            switch (choice) {
                case '1': await createStudent(rl); break;
                case '2': await listStudents(); break;
                case '3': await updateStudent(rl); break;
                case '4': await deleteStudent(rl); break;
                case '5':
                    rl.close();
                    await mongoose.disconnect();
                    console.log("Disconnecting!");
                    return;
                default: console.log("Invalid option!");
            }
        }
    } catch (err) {
        console.error("ERROR!", err);
    }
}

main();