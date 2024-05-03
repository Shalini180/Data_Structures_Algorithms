class Solution {
    public int numUniqueEmails(String[] emails) {
        Map<String, Integer> mp = new HashMap<>();
        for(String email: emails){
            StringBuilder str = new StringBuilder();
            boolean flagDomain = false;
            boolean flagPlus = false;
            for(int i = 0;i < email.length();i++){
                char ele = email.charAt(i);
                if(ele == '+' && !flagDomain) flagPlus = true;
                else if(ele == '@'){
                    flagDomain = true;
                    str.append(ele);
                } 
                else if(ele != '.' && !flagDomain && !flagPlus) str.append(ele);
                else if(flagDomain) str.append(ele);
            }

            String finalString = str.toString();
            //System.out.println(finalString);
            mp.put(finalString, mp.getOrDefault(finalString, 0) + 1);
        }

        return mp.size();
    }
}
