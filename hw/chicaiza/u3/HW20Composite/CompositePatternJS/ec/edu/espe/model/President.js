import { Supervisor } from './Supervisor.js';

export class President extends Supervisor {
  static instance = null;

  constructor(name = "") {
    if (President.instance) return President.instance;
    super(name, "President");
    President.instance = this;
  }

  static getPresident(name) {
    if (!President.instance) {
      President.instance = new President(name);
    } else {
      President.instance.name = name;
    }
    return President.instance;
  }

  stateName() {
    super.stateName();
  }
}
