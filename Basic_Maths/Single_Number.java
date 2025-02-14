class Solution {
    public int singleNumber(int[] arr) {
        // naive approach
        // return bruteForce(arr);

        // sub optimal approach
        // return subOptimal(arr);

        // optimal approach
        return optimal(arr);
    }

    public int optimal(int[] arr) {
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        return ans;
    }

    public int subOptimal(int[] arr) {
        if (arr.length == 1) return arr[0];
        int length = arr.length;
        Arrays.sort(arr);
        for (int i = 1; i < length; i += 2) {
            if (arr[i] != arr[i - 1]) return arr[i - 1];
        }
        return arr[length - 1];
    }

    public int bruteForce(int[] arr) {
        int ans = 0;
        Map <Integer, Integer> mp = new HashMap<>();
        for(int i : arr) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            }
            else {
                mp.put(i, 1);
            }
        }

        for (Map.Entry mapElement : mp.entrySet()) {
            int value = (int) mapElement.getValue();
            if (value == 1) {
                ans = (int) mapElement.getKey();
                break;
            }
        }

        return ans;
    }
}