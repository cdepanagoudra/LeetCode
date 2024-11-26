class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder a = new StringBuilder();
        int dept=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                if(dept>0){
                    a.append(c);
                }
                dept++;
            }else{
                dept--;
                if(dept>0){
                    a.append(c);
                }
            }
        }
        return a.toString();
    }
}