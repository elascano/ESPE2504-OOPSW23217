const Button = require('../model/Button');


class LinuxButton extends Button {
  paint() {
    console.log("I'm a LinuxButton: " + this.caption);
  }
}

module.exports = LinuxButton;
