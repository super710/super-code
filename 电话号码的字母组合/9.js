var letterCombinations = function (digits) {

    const len = digits.length;

    const digitsLetter = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    }

    let index = 0;
    let output = '';
    let result = [];
    if(digits === ''){
        return [];
    }
    
    getStr(index, output, len, result, digitsLetter, digits);
    
    return result;
};

function getStr(index, output, len, result, digitsLetter, digits) {
   
    for (let i = 0; i < digitsLetter[digits[index]].length; i++) {
        output += digitsLetter[digits[index]][i];
        if(index == len - 1){
            result.push(output);
            // console.log(output);
        }else{
            getStr(index + 1, output, len, result, digitsLetter, digits);
        }
        output = output.substring(0, output.length - 1);
    }
    if(index == len - 1){
        index = 0;
    }
}

// function getStr(str){
//     for(let i = 0; i < str.length; i ++){
//         getStr(digitsLetter[digits[index]])
//     }
// }

console.log(letterCombinations('772'));