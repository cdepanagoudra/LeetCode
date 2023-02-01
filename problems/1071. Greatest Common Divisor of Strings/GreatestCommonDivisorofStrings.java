class Solution {
    public String gcdOfStrings(String str1, String str2) {
    if (!(str1+str2).equals(str2+str1))  return "";
    
    int gcdVal = gcd(str1.length() , str2.length());
    return str2.substring(0, gcdVal);
}

public static int gcd(int p, int q) {
    if (q == 0) return p;
    else return gcd(q, p % q);
}
// int p = 6,q=3
//   gcd(3,6%3);
//      int p=3,q=0;
//          q=0;
//sub_string 
}