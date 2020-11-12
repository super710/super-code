// 根本思想：滑动窗口，为了减少找到回文串的运算量，采取边读字符串边比较的方法，比较方法是首尾指针比较
// 最坏情况1 + 2 + ... + n-1个时间复杂度，最好情况1个时间复杂度
var longestPalindrome = function(s) {

    let temp = [];
    let pdrome = [];
    let i = s.length - 1;
    let isRepeat = false;
    while(i > 0){
        for(let m = 0; m < s.length - i; m ++){
            let step = i + m;
            for(let n = m; n < i + 1 + m; n ++){
                
                if(n <= step){
                    if(s[n] !== s[step]){
                        // 表示该字符串一定不是回文串，直接进行下一个滑动窗口内的字符串比较
                        isRepeat = true;
                        break;
                    }else{
                        step --;
                    }
                }else{
                    // 如果首指针的位置大于尾指针的位置，说明比较已经完成，已经找到回文串，程序即将退出，是否找到回文串标志变量，置为假
                    isRepeat = false;
                }
                temp.push(s[n]);
            }
            if(!isRepeat){
                pdrome = JSON.parse(JSON.stringify(temp));
                break;
            }else{
                temp = [];
            }
            
        }
        if(!isRepeat){
            
            break;
        }else{
            isRepeat = false;
        }
        i --;
    }

    if(pdrome.length === 0){
        return s[0];
    }

    
    let output = '';

    
    for(let i = 0; i < pdrome.length; i ++){
        output += pdrome[i];
    }
    
    return output;
};
// console.log(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
// console.log(longestPalindrome("babad"));
// console.log(longestPalindrome("cbbd"));
// console.log(longestPalindrome("ccc"));
// console.log(longestPalindrome("cccc"));
// console.log(longestPalindrome("abbbbaca"));