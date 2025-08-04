const Tea = require('../model/Tea');
const Coffee = require('../model/Coffee');
const readline = require('readline');

async function askQuestion(rl, question) {
    return new Promise((resolve) => {
        rl.question(question, (answer) => {
            resolve(answer.toLowerCase());
        });
    });
}

async function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    try {
        console.log("\nMaking tea...");
        const tea = new Tea();
        tea.prepareRecipe();
        
        const teaAnswer = await askQuestion(rl, "Would you like lemon with your tea (y/n)? ");
        if (teaAnswer === 'y') {
            tea.addCondiments();
        }

        console.log("\nMaking coffee...");
        const coffee = new Coffee();
        coffee.prepareRecipe();
        
        const coffeeAnswer = await askQuestion(rl, "Would you like sugar and milk with your coffee (y/n)? ");
        if (coffeeAnswer === 'y') {
            coffee.addCondiments();
        }
    } finally {
        rl.close();
    }
}

main().catch(console.error);