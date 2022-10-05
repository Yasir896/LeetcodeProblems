
//Problem One
fun twoSum(nums: IntArray, target: Int): IntArray {
    //crete map to store values
    val numMap: MutableMap<Int, Int> = HashMap()
    //iterate each value from array
    for (i in 0 until nums.size) {
        //calculating difference between target and index value
        val difference = target - nums[i]

        //if map contains difference value key
        //return its value and current index value
        if (numMap.containsKey(difference)) {
            return intArrayOf(numMap[difference]!!, i)
        } else {
            //if map dose not contains difference value key
            //add index value as key and index as its value in map
            numMap[nums[i]] = i
        }
    }
    return intArrayOf()
}


//Problem Two
// Palindrome Number
fun isPalindrome(number: Int): Boolean {
    if (number < 0) {
        return false
    }

    //declaring a temporary variable because we need original later for comparison later
    var temp = number
    var reversedNum = 0

    //iterate through given number
    while (temp > 0) {
        //get last digit of the number
        val lastDigit = temp % 10

        reversedNum = reversedNum * 10 + lastDigit

        temp /= 10
    }
    return reversedNum == number
}


//Problem Three
//Convert Romans into Integers

fun romanToInt(s: String): Int {

    //storing values to a map
    val map = HashMap<Char, Int>()
    map['I'] = 1
    map['V'] = 5
    map['X'] = 10
    map['L'] = 50
    map['C'] = 100
    map['D'] = 500
    map['M'] = 1000

    //initializing our result variable with Last roman character value
    var result: Int = map[s[s.length - 1]]!!
    var lastNum = result

    //iteration through String from Last Index to first.
    //here we will start from the second last item in our string
    //because we already initialized our last number as last index in our string.
    for (i in s.length - 2 downTo 0) {
        //getting current index value
        val current: Int = map[s[i]]!!

        //if the current value is less than the last number
        //we will subtract its value from the result
        //for example if the last number was 'X' and current is 'I'
        //we will subtract 1 from 10 and result will be 9
        if (current < lastNum)
            result -= current
        else
            //if the current value is greater than the last
            //we will add its value to the result
            //for example if the last number was 'X' and current is 'L'
            //we will add 50 to 10 and result will be 60
            result += current

        //saving the current value as last for next iteration.

        lastNum = current
    }
    return result
}