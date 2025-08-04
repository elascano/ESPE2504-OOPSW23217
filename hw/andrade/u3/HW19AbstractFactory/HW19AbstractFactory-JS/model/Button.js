class Button {
    constructor() {
        this.caption = '';
    }

    paint() {
        throw new Error("Abstract method paint() must be implemented");
    }
}

module.exports = Button;