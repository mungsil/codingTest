/*
Runtime: 55ms
Beats: 10.97%

Memory: 49.00MB
Beats: 66.34%
*/


class MyHashMap {

    List<List<int[]>> hashMap;

    public MyHashMap() {
        hashMap = new ArrayList<>();
        for(int i=0; i< 9; i++){
            hashMap.add(new ArrayList<>());
        }
        for(List<int[]> nodes:hashMap){
            nodes = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int hashKey = key % 9;
        List<int[]> nodes = hashMap.get(hashKey);
        
        // update if exists
        for(int[] node:nodes){
            if(node[0] == key){
                node[1] = value;
                return;
            }          
        }

        // put if not exists
        nodes.add(new int[]{key,value});
    }
    
    public int get(int key) {
        int hashKey = key % 9;
        List<int[]> nodes = hashMap.get(hashKey);
        for(int[] node:nodes){
            if(node[0] == key){
                
                return node[1];
            }          
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashKey = key % 9;
        List<int[]> nodes = hashMap.get(hashKey);
        int size = nodes.size();

        for(int i=0; i<size; i++){
            int[] node = nodes.get(i);
            if(node[0] == key){
                nodes.remove(i);
                return;
            }          
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
