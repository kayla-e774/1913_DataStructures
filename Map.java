package lab7;

public class Map<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int count;
    
    public Map(int length) {
        if(length < 0) {
            throw new IllegalArgumentException("lengths must be 0 or greater");
        }
        else {
            count = 0;
            keys = (Key[]) new Object[length];
            values = (Value[]) new Object[length];
        }
    }
    
    public Value get(Key key) {
        int index;
        Value val;
        if (isIn(key)) {
            index = where(key);
            val = values[index];
        }
        else {
            throw new IllegalArgumentException("Key does not exist.");
        }
        return val;
        
    }
    
    public boolean isEqualKey(Key leftKey, Key rightKey) {
        boolean eq = false;
        if (leftKey == null) {
            if (rightKey == null) {
                eq = (rightKey == null);
            }
        }
        else {
            eq = (leftKey.equals(rightKey));
        }
        return eq;
    }
    
    public boolean isIn(Key key) {
        boolean result = true;
        for(int i = 0; i < count; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    result = true;
                    break;
                }
            }
            else if (key.equals(keys[i])) {
                result = true;
                break;
            }
            else {
                result = false;
            }
        }
        return result;
    }
    
    public void put(Key key, Value value) {
        int w = where(key);
        if(count >= keys.length && w == -1) {
            throw new IllegalStateException("Map object is full.");
        }
        else {
            if (w != -1) {
                values[w] = value;
            }
            else {
                values[count] = value;
                keys[count] = key;
                count++;
            }
        }
    }
    
    private int where(Key key) {
        int locate = -1;
        for(int i = 0; i < count; i++) {
            if (key == null) {
                if (keys[i] == null) {
                    locate = i;
                    break;
                }
            }
            else if (key.equals(keys[i])) {
                locate = i;
                break;
            }
        }
        return locate;
    }
}
