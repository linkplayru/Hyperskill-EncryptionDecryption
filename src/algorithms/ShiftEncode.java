package algorithms;

public class ShiftEncode extends Algorithm {

    private String alphabetL = "abcdefghijklmnopqrstuvwxyz";
    private String alphabetB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ShiftEncode(int key) {
        this.key = key;
    }

    @Override
    public String process(String data) {
        StringBuilder sb = new StringBuilder();
        char[] dataC = data.toCharArray();
        for (char ch : dataC) {
            int indexL = alphabetL.indexOf(ch);
            int indexB = alphabetB.indexOf(ch);
            if (indexL != -1) {
                int newIndex = indexL;
                for (int i=0; i<key; i++) {
                    newIndex++;
                    if (newIndex > alphabetL.length()-1) {
                        newIndex = 0;
                    }
                }
                sb.append(alphabetL.charAt(newIndex));
            } else if (indexB != -1) {
                int newIndex = indexB;
                for (int i=0; i<key; i++) {
                    newIndex++;
                    if (newIndex > alphabetB.length()-1) {
                        newIndex = 0;
                    }
                }
                sb.append(alphabetB.charAt(newIndex));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}