class Client {
  static employee = null;

  static doClientTasks() {
    if (Client.employee) {
      Client.employee.stateName();
    }
  }
}

module.exports = Client;
