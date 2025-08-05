const Supervisor = require('./Supervisor');

class President extends Supervisor {
    static #instance = null;
    
    constructor(aName) {
        if (President.#instance && !aName) {
            return President.#instance;
        }
        
        super();
        if (aName) this.name = aName;
        this.title = "President";
        
        if (!President.#instance) {
            President.#instance = this;
        }
        return President.#instance;
    }
    
    static getPresident(aName) {
        if (!President.#instance) {
            President.#instance = new President(aName);
        } else if (aName) {
            President.#instance.name = aName;
        }
        return President.#instance;
    }
}

module.exports = President;