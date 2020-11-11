var findMedianSortedArrays = function (nums1, nums2) {

    let maxNums = [];
    let minNums = [];
    let nums = [];

    let maxLength = 0;
    let minLength = 0;

    if (nums1.length >= nums2.length) {
        minLength = nums2.length;
        maxLength = nums1.length;
        maxNums = nums1;
        minNums = nums2;
    } else {
        maxLength = nums2.length;
        minLength = nums1.length;
        minNums = nums1;
        maxNums = nums2;
    }

    let j = 0;
    let i = 0;
    let maxFlag = false;
    let minFlag = false;
    while (j < minLength || i < maxLength) {

        if (maxNums[i] >= minNums[j]) {
            nums.push(minNums[j]);
            j ++;
        } else {
            // 如果比它小
            nums.push(maxNums[i]);
            i ++;
        }
        if(maxNums[i] === undefined){
            maxFlag = true;
            break;
        }
        if(minNums[j] === undefined){
            minFlag = true;
            break;
        }   
    }

    if(maxFlag){
        for(let m = j; m < minNums.length; m ++){
            nums.push(minNums[m]);
        }
    }
    if(minFlag){
        for(let m = i; m < maxNums.length; m ++){
            nums.push(maxNums[m]);
        }
    }

    if(nums.length % 2 === 0){
        return ((nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2).toFixed(5);
    }else{
        return ((nums[Math.trunc(nums.length / 2) ])).toFixed(5);
    }
};

console.log(findMedianSortedArrays([1,3], [2]));