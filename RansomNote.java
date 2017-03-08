import java.util.HashMap;

/**
 * Created by Pablo on 1/19/2017.
 */
public class RansomNote {
    HashMap<String, Integer> magazine = new HashMap<>();
    String ransom;
    public RansomNote(String magazine, String ransom){
        for(String s: magazine.split(" ")){
            this.magazine.put(s, this.magazine.getOrDefault(s, 0)+1);
        }
        this.ransom = ransom;

    }

    public void setWords(String words){
        for(String s: words.split(" ")){
            this.magazine.put(s, this.magazine.getOrDefault(s, 0)+1);
        }
    }

    public void setRansom(String ransom){
        this.ransom = ransom;
    }

    public boolean enough(){
        for(String s: ransom.split(" ")){
            if(!magazine.containsKey(s)){
                return false;
            }
            if(magazine.get(s)==0){
                return false;
            }
            magazine.put(s, magazine.get(s)-1);
        }
        return true;
    }
    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String ransom = "give one grand today";
        RansomNote check = new RansomNote(magazine, ransom);
       System.out.println(check.enough());
        check.setRansom("tell me that you love me");
        check.setWords("tell love me not");
        System.out.println(check.enough());
        check.setRansom("zahk dp apdz clo e dk awfvf osb qr sa cqjq zgr nvxtb abjy axa ili wdyw soqku buwcl qcub sautu ii vkrzl bdob nona al zg ombzc c dbun f xkuo lsax hfki j dfft uce ugj ywz vucgg xq udrkt ypy tmxgc ty gar kty dc bznj pzzx clo apdz nvxtb clo sa clo zahk awfvf soqku udrkt udrkt e ypy xkuo tmxgc ombzc wdyw al axa lsax clo abjy osb apdz bdob pzzx zahk c bznj gar osb xkuo " +
                "zahk zg uce zg clo e apdz gar xq dbun buwcl ili bznj clo osb dc dbun ywz");
        check.setWords("buwcl qr axa ypy zahk nvxtb dp hfki ii uce dc zg dbun ypy ty cqjq zg kty bznj zg zahk dp c al ugj ywz qcub ywz wdyw hfki gar e axa dp " +
                "qr kty bznj clo ty vucgg qcub al vkrzl qcub j awfvf soqku lsax bdob nvxtb");
        System.out.println(check.enough());
    }
}
