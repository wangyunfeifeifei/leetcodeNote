/**
 * @param {string} str
 * @return {number}
 */
function myAtoi (str) {
    str = str.trim();
    let flag = true
    let idx = 0;
        max = 0x7fffffff;
        min = -0x80000000;
    if (str.charAt(idx) === '-') {
        flag = false;
        idx ++;
    } else if (str.charAt(idx) === '+') {
        idx ++;
    }

    let ans = 0
    while (idx < str.length) {
        if (str.charAt(idx) < '0' || str.charAt(idx) > '9') {
            break;
        }
        ans = ans*10 + parseInt(str.charAt(idx))
        idx ++;
        if (ans > max) {
            return flag ? max : min;
        }
    }
    if (flag) {
        return ans;
    } else {
        return -ans;
    }
}