const Button = require('../model/Button');

class LinuxButton extends Button {
    paint() {
        console.log("I'm a LinuxButton: " + this.caption);
        console.log("------------");
        console.log("| " + this.caption.padEnd(11) + " |");
        console.log("------------");
    }
}

module.exports = LinuxButton;