const SortingContext = require('../model/SortingContext');

function main() {
    const data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3];

    process.stdout.write("Arreglo original: ");
    data.forEach(num => process.stdout.write(num + " "));
    console.log();

    const sc = new SortingContext();
    const sortedList = sc.sort(data);
}

main();
