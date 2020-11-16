var maxArea = function (height) {



    let diff = 0;
    let area = 0;
    let j = height.length - 1;
    let i = 0;
    let left = height[i];
    let right = height[j];
    while (true) {

        let min = right >= left ? left : right;
        diff = j - i;
        if (min * diff >= area) {
            area = min * diff;


        }
    

        if ((right <= diff && left > diff) || right <= left) {
            j--;
            right = height[j];
        } else {
            i++; 
            left = height[i];
        }


        if (j <= i) {
            break;
        }
    }

    return area;
};


console.log(maxArea([1, 2, 1]));
console.log(maxArea([4, 3, 2, 1, 4]));
console.log(maxArea([1, 1]));
console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
console.log(maxArea([2,3,4,5,18,17,6]));