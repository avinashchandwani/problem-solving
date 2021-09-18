class AddBinary {
    public String addBinary(String a, String b) {
        if("0".equals(a)) return b;
        if("0".equals(b)) return a;
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;
        StringBuilder sumResult = new StringBuilder();
        while(aIndex >=0 || bIndex >= 0) {
            int []bitSum = getBitSum(getNumber(a, aIndex), getNumber(b, bIndex), carry);
            carry = bitSum[0];
            sumResult.append(bitSum[1]);
            if(aIndex >= 0) aIndex--;
            if(bIndex >= 0) bIndex--;
        }
        if(carry == 1){
           sumResult.append(1);
        }
        return sumResult.reverse().toString();
    }
    
    private int getNumber(String s, int index) {
        return index >= 0 ? (int) s.charAt(index) - '0' : 0;
    }
    
    private int[] getBitSum(int a, int b, int c) {
        int []bitSum = new int[2];
        int sum = a + b + c;
        if(sum == 3) {
            bitSum[0] = 1;
            bitSum[1] = 1;
        } else if(sum == 2) {
            bitSum[0] = 1;
        } else if(sum == 1) {
             bitSum[1] = 1;
        }
        return bitSum;
    }
}
