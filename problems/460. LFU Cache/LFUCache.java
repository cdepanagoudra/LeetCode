package practice;

public class LFUCache {
	private int cap;
    private int min =1;
    Map<Integer,Integer> keyValueMap = new HashMap<>();
    Map<Integer,Integer> keyFreqMap = new HashMap<>();
    Map<Integer,LinkedHashSet<Integer>> freqKeyMap = new HashMap<>();
    public LFUCache(int capacity) {
        cap=capacity;
        freqKeyMap.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)){
            return -1;
        }
        int frequency = keyFreqMap.get(key);
        freqKeyMap.get(frequency).remove(key);
        if(frequency==min && freqKeyMap.get(frequency).size()==0){
            min++;
        }
        if(!freqKeyMap.containsKey(frequency+1)){
            freqKeyMap.put(frequency+1,new LinkedHashSet<>());
        }
        freqKeyMap.get(frequency+1).add(key);
        keyFreqMap.put(key,frequency+1);

        return keyValueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(cap<=0){
            return;
        }
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key,value);
            get(key);
            return;
        }
        if(keyValueMap.size()>=cap){
            int keytobeEvicted = freqKeyMap.get(min).iterator().next();
            freqKeyMap.get(min).remove(keytobeEvicted);
            keyValueMap.remove(keytobeEvicted);
            keyFreqMap.remove(keytobeEvicted);
        }
        keyValueMap.put(key,value);
        keyFreqMap.put(key,1);
        min=1;
        freqKeyMap.get(1).add(key);

    }
}
