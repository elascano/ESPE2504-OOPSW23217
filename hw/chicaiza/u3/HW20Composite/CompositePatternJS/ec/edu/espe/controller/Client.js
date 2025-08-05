export class Client {
  static employee = null;

  static doClientTasks() {
    if (Client.employee) {
      Client.employee.stateName();
    } else {
      console.log("No employee assigned.");
    }
  }
}
