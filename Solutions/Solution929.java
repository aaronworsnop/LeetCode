class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> differentEmails = new HashSet<>();
        
        for (String email : emails) {
            email = getCanonicalEmail(email);
            
            if (isValidEmail(email)) {
                differentEmails.add(email);
            }
        }
        
        return differentEmails.size();
    }
    
    private String getCanonicalEmail(String email) {
        // Split into local and domain names
        String[] names = email.split("@");
        String local = names[0];
        String domain = names[1];
        
        Set<Integer> ignore = new HashSet<Integer>();
        int end = local.length();
        
        // Construct canonical local name
        for (int index = 0; index < local.length(); index++) {
            char current = local.charAt(index);
            
            if (current == '.') {
                ignore.add(index);
            } else if (current == '+') {
                end = index;
                break;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        local = local.substring(0, end);
        
        for (int index = 0; index < local.length(); index++) {
            if (ignore.contains(index)) {
                continue;
            }
            
            builder.append(local.charAt(index));
        }
        
        local = builder.toString();
        
        return local + "@" + domain;
    }
    
    private boolean isValidEmail(String email) {
        // Split into local and domain names
        String[] names = email.split("@");
        String local = names[0];
        String domain = names[1];
        
        if (local.length() == 0 || domain.length() == 0) {
            return false;
        }
        
        return true;
    }
}