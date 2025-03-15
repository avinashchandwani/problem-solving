class Counter {

    private final long timeWindow;
    private int totalCount = 0;
    private long lastOperationTime = -1;
    private Map<String, Queue<Long>> keyTimedLookup = null;

    public Counter(int timeWindow) {
        this.timeWindow = timeWindow;
        keyTimedLookup = new HashMap<>();
    }

    public void put(String key) {
        addEntry(key);
    }

    public long getCount(String key) {
        long currentTimeInSeconds = System.currentTimeMillis()/ 1000;
        if(!keyTimedLookup.containsKey(key)) {
            return 0;
        }
        removeOldEntries(key, currentTimeInSeconds);
        Queue<Long> keyTimedEntries = keyTimedLookup.get(key);
        return keyTimedEntries.size();
    }

    public int getTotalCount() {
        long currentTimeInSeconds = System.currentTimeMillis()/ 1000;
        if(this.lastOperationTime + this.timeWindow <= currentTimeInSeconds) {
            for (String key : keyTimedLookup.keySet()) {
                removeOldEntries(key, currentTimeInSeconds);
            }
        }
        return totalCount;
    }

    private void addEntry(String key) {
        long currentTimeInSeconds = System.currentTimeMillis()/ 1000;
        this.lastOperationTime = currentTimeInSeconds;
        Queue<Long> keyTimedEntries =  keyTimedLookup.containsKey(key) ?
                keyTimedLookup.get(key) : new LinkedList<>();
        keyTimedEntries.add(currentTimeInSeconds);
        keyTimedLookup.putIfAbsent(key, keyTimedEntries);
        removeOldEntries(key, currentTimeInSeconds);
        totalCount++;
    }

    private void removeOldEntries(String key, long currentTimeInSeconds) {
        this.lastOperationTime = currentTimeInSeconds;
        if(!keyTimedLookup.containsKey(key)) {
            return;
        }
        Queue<Long> keyTimedEntries = keyTimedLookup.get(key);

        while (!keyTimedEntries.isEmpty()) {
            long timeEntry = keyTimedEntries.peek();
            if (timeEntry + this.timeWindow <= currentTimeInSeconds) {
                Long value = keyTimedEntries.poll();
                totalCount--;
                if(value == null) {
                    keyTimedLookup.put(key, new LinkedList<>());
                }
            }
            break;
        }
    }
}
