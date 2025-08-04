const SortingContext = require('../controller/SortingContext');
const readline = require('readline');

function printArray(array) {
    console.log(array.join(' '));
}

function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    const sortingContext = new SortingContext();
    
    rl.question('Ingrese el numero de elementos: ', (n) => {
        const numElements = parseInt(n);
        const data = [];
        let count = 0;
        
        console.log(`Ingrese ${numElements} numeros (uno por línea):`);
        
        rl.on('line', (input) => {
            data.push(parseInt(input));
            count++;
            
            if (count === numElements) {
                console.log('Array original:');
                printArray(data);
                
                const sortedData = sortingContext.sort([...data]);
                
                console.log('Array ordenado:');
                printArray(sortedData);
                
                rl.close();
            }
        });
    });
    
    rl.on('close', () => {
        process.exit(0);
    });
}

main();