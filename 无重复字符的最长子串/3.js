var lengthOfLongestSubstring = function(s) {
    if(s === ''){
        return 0;
    };

    let temp = '';
    let myMaxLength = [];
    let i = 0;
    while(i <= s.length){
        if(i == s.length){
            myMaxLength.push(temp.length);
            break;
        }
        for(let j = 0; j < temp.length; j ++){
            if(temp[j] == s[i]){
                // 如果出现相同字符，将此时的temp长度，压入myMaxLength
                myMaxLength.push(temp.length);
                temp = temp.substring(j + 1);
                break;
            }
        }
       
        temp += s[i];
           
        i ++;
    }
    
    return Math.max.apply(Math, myMaxLength);
};
