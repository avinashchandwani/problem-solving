class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupedStrings = new HashMap<>();
        for(String string : strings) {
            int diff = 'a' - string.charAt(0);
            char[] key = new char[string.length()];
            for (int i = 0; i < string.length(); i++) 
                key[i] = (char)(string.charAt(i) + diff < 'a' ? string.charAt(i) + diff + 26 : string.charAt(i) + diff);
            groupedStrings.computeIfAbsent(new String(key), values -> new ArrayList<>()).add(string);
        }
        List<List<String>> res = new ArrayList(groupedStrings.values());
        return res;
    }
}
