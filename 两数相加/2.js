var addTwoNumbers = function (l1, l2) {
    let newListNode = new ListNode(0, undefined);

    let l1ListNode = new ListNode(0, undefined);
    let l2ListNode = new ListNode(0, undefined);
    let cursor = new ListNode(0, undefined);
    cursor = l1ListNode;
    for (let i = 0; i < l1.length; i++) {
        cursor.val = l1[i];
        if (i !== l1.length - 1) {
            cursor.next = new ListNode(0, undefined);
        } else {
            cursor.next = undefined;
        }
        cursor = cursor.next;
    };
    cursor = l2ListNode;
    for (let i = 0; i < l2.length; i++) {
        cursor.val = l2[i];
        if (i !== l2.length - 1) {
            cursor.next = new ListNode(0, undefined);
        } else {
            cursor.next = undefined;
        }
        cursor = cursor.next;
    }
    cursor = newListNode;
    cursorl1 = l1ListNode;
    cursorl2 = l2ListNode;
    let r1 = 0;
    let r2 = 0;
    while (typeof (cursorl1) !== 'undefined' || typeof (cursorl2) !== 'undefined') {


        r1 = (checkNum(cursorl1) + checkNum(cursorl2)) % 10;
        r2 = checkNum(cursorl1) + checkNum(cursorl2) - 10;

        if (r2 >= 0) {
            cursor.next = new ListNode(1, undefined);
            cursor.val += r1;
        } else {
            if (typeof (checkNext(cursorl1)) === 'undefined' && typeof (checkNext(cursorl2)) === 'undefined') {
                cursor.next = null;
            } else {
                cursor.next = new ListNode(0, undefined);
            }

            cursor.val += r1;
        }
        cursorl1 = checkNext(cursorl1);
        cursorl2 = checkNext(cursorl2);
        cursor = cursor.next;
    };

    return newListNode;
};

function checkNum(num) {

    return num ? num.val : 0;
}

function checkNext(listNode) {
    return listNode ? listNode.next : undefined;
}
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
let l1 = [2, 4, 9];
let l2 = [5, 6, 4];

console.log(addTwoNumbers(l1, l2));