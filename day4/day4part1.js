// answer is slightly off but i cannot be bothered to figure out why its <10 off rn
const fs = require('fs');

function calculatePoints(line) {
    let count = 0;
    // each line is a new card
    // split input by : to seperate card number
    const [cardNumber, numbersStr] = line.split(": ");
    // split each card by | into winning nums and my nums
    if (numbersStr !== undefined) {
        let [winningNumbersStr, myNumbersStr] = numbersStr.split(" | ");

        // remove spaces
        winningNumbersStr = winningNumbersStr.replace(/ {2,}/g, ' ');
        myNumbersStr = myNumbersStr.replace(/ {2,}/g, ' ');

        // turn into array
        const winningNumbers = winningNumbersStr.split(' ').map(Number);
        const myNumbers = myNumbersStr.split(' ').map(Number);

        console.log("Winning Numbers:", winningNumbers);
        console.log("My Numbers:", myNumbers);

        // operate over all elements of both arrays to find matching numbers
        let temp = [];

        for (var i = 0; i < winningNumbers.length; i++) {
            for (var j = 0; j < myNumbers.length; j++) {
                if (myNumbers[j] == winningNumbers[i]) {
                    if (!temp.includes(winningNumbers[i])) {
                        temp.push(winningNumbers[i]);
                        if (temp.length > 1) {
                            count *= 2
                            //console.log("cur count: " + count)
                        } else {
                            count += 1
                        }
                    }
                }
            }
        }
        console.log("Matching Numbers: " + temp)
        // add to count for each matching number
        console.log("Count of matches: " + count)
    }
    // total will be the sum of the number of matches of all cards
    return count
}

async function readFile(file) {
    try {
        const data = fs.readFileSync(file, 'utf8');
        const lines = data.split('\n');

        let totalPoints = 0;

        for (const line of lines) {
            if (lines !== undefined) {
                console.log('Line:', line);
                totalPoints = totalPoints + calculatePoints(line);
                console.log("cur total: " + totalPoints)
            }

        }
        console.log('File reading completed.');
        console.log("Total Points:", totalPoints);

    } catch (e) {
        console.log('Error:', e.stack);
    }
}

readFile("day4/input.txt");