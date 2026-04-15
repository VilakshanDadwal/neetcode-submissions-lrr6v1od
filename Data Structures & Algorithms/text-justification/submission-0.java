class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        var result = new ArrayList<String>();
        var remainingChars = maxWidth;
        var candidates = new ArrayList<String>();
        for(int i=0; i<words.length; i++) {
            var wordLength = words[i].length();
            // If first word in candidates
            if(candidates.size()==0 && remainingChars - wordLength >=0) {
                 candidates.add(words[i]);
                 remainingChars -= wordLength;
            } else if(remainingChars - wordLength - 1 >=0){
                // Not first word
                candidates.add(words[i]);
                remainingChars =  remainingChars - wordLength -1;
            } else {
                // Cannot add any new word
                addNewLine(candidates, result, maxWidth, false);
                remainingChars = maxWidth;
                // Add current word.
                candidates = new ArrayList<String>();
                candidates.add(words[i]);
                remainingChars -= wordLength;
            }
        }
        addNewLine(candidates, result, maxWidth, true);
        return result;
    }

    private void addNewLine(List<String> candidates, List<String> result, int maxWidth, boolean isLastLine) {
        
        var totalChars = 0;
        for(String candidate : candidates) {
            totalChars += candidate.length();
        }
        var totalSpaces = maxWidth - totalChars;

        var line = new StringBuilder();
        line.append(candidates.get(0));

        var remainder = isLastLine || candidates.size()==1 ? 0 : totalSpaces % (candidates.size()-1);
        for(int i=1; i < candidates.size(); i++) {
            var spacesToAdd = isLastLine ? 1 : totalSpaces/(candidates.size()-1);
            
            if(remainder > 0) {
                spacesToAdd = spacesToAdd+1;
                remainder--;
            }

            while(spacesToAdd > 0) {
                line.append(' ');
                spacesToAdd--;
            } 

            line.append(candidates.get(i));
        }

        if(isLastLine || candidates.size()==1) {
            var spacesToAdd = totalSpaces - (candidates.size()-1);
            while(spacesToAdd > 0) {
                line.append(' ');
                spacesToAdd--;
            }
        }

        result.add(line.toString());
    }
}