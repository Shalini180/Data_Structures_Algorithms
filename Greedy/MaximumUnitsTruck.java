class Box {
    int numberOfBox;
    int numberOfUnitesPerBox;
    public Box(int numberOfBox, int numberOfUnitsPerBox){
        this.numberOfBox = numberOfBox;
        this.numberOfUnitesPerBox = numberOfUnitsPerBox;
    }
}
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Box> ans = new ArrayList<>();
        for(int i = 0;i<boxTypes.length;i++){
            ans.add(new Box(boxTypes[i][0], boxTypes[i][1]));
        }

        Collections.sort(ans, new Comparator<Box>(){
            public int compare(Box b1, Box b2){
                return b2.numberOfUnitesPerBox - b1.numberOfUnitesPerBox;
            }
        });

        int maxAns = 0;
        for(int i = 0;i<boxTypes.length;i++){
            if(truckSize > 0){
                int currBoxes = ans.get(i).numberOfBox;
                int units = ans.get(i).numberOfUnitesPerBox;
                if(currBoxes >= truckSize){
                    maxAns += truckSize * units;
                    break;
                }

                maxAns  += units*currBoxes;
                truckSize -= currBoxes;
            }
        }

        return maxAns;
    }
}
