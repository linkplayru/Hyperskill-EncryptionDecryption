package algorithms;

public class UnicodeDecode extends Algorithm {

    public UnicodeDecode(int key) {
        this.key = key;
    }

    @Override
    public String process(String data) {
        char[] dataC = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : dataC) {
            sb.append(ch -= key);
        }
        return sb.toString();
    }
}