package ec.espe.edu.systemstudents.view;

import com.mongodb.client.*;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import java.util.Scanner;
import ec.espe.edu.systemstudents.model.Student;

public class SystemStudents {
    public static void main(String[] args) {
        String uri = "mongodb+srv://Gerald:Gerald@cluster0.rdplxx4.mongodb.net/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase db = mongoClient.getDatabase("POO");
            MongoCollection<Document> collection = db.getCollection("Eduplan");
            Scanner scanner = new Scanner(System.in);

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine();
            System.out.print("Apellido: ");
            String lastName = scanner.nextLine();
            System.out.print("Edad: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Salario: ");
            int salary = Integer.parseInt(scanner.nextLine());

            Student newStudent = new Student(id, firstName, lastName, age, salary);

            collection.updateOne(new Document(), Updates.push("students", toDocument(newStudent)));
            System.out.println("Estudiante agregado correctamente.\n");

            Document document = collection.find().first();
            if (document != null && document.containsKey("students")) {
                var students = document.getList("students", Document.class);
                System.out.println("Total de estudiantes: " + students.size());
                for (Document s : students) {
                    int sid = s.getInteger("id");
                    String sFirstName = s.getString("firstName");
                    String sLastName = s.getString("lastName");
                    int sAge = s.getInteger("age");
                    Object salaryObj = s.get("salary");
                    int sSalary;
                    if (salaryObj instanceof Integer) {
                        sSalary = (Integer) salaryObj;
                    } else if (salaryObj instanceof Double) {
                        sSalary = ((Double) salaryObj).intValue();
                    } else {
                        sSalary = 0;
                    }
                    System.out.println(sid + " - " + sFirstName + " " + sLastName + ", edad: " + sAge + ", salario: " + sSalary);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Document toDocument(Student student) {
        return new Document("id", student.getId())
                .append("firstName", student.getFirstName())
                .append("lastName", student.getLastName())
                .append("age", student.getAge())
                .append("salary", student.getSalary());
    }
}