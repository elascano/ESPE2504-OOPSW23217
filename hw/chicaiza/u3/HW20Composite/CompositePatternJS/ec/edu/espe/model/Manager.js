import { Supervisor } from './Supervisor.js';

export class Manager extends Supervisor {
  constructor(name) {
    super(name, "Manager");
  }

  stateName() {
    super.stateName();
  }
}
