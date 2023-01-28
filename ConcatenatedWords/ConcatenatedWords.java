
public class ConcatenatedWords {
	public boolean isConcatinated(String word,Set set){
        int l=word.length();
        for(int i=0;i<l;i++){
            String prefix = word.substring(0,i+1);
            String suffix =word.substring(i+1);
            if(set.contains(prefix) && set.contains(suffix) || set.contains(prefix) && isConcatinated(suffix,set) ){
                return true;
            }
        }
        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n=words.length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(words[i]);
        }
        List<String> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            String word = words[i];
            if(isConcatinated(word,set)){
                result.add(word);
            }
        }
        return result;
    }
}
