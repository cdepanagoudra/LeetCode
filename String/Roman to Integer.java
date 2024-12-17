class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        int total =0;
        int preValue =0;

        for(int i=s.length()-1;i>=0;i--){
            int currentValue = map.get(s.charAt(i));
            if(currentValue < preValue){
                total-= currentValue;
            }else{
                total+=currentValue;
            }
            preValue=currentValue;
        }

        return total;

    }
}