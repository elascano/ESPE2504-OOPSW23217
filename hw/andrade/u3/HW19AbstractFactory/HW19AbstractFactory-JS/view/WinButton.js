const Button = require('../model/Button');

class WinButton extends Button {
    paint() {
        console.log("I'm a WinButton: " + this.caption);
        console.log("------------");
        console.log("| " + this.caption.padEnd(11) + " |");
        console.log("------------");
    }
}

module.exports = WinButton;