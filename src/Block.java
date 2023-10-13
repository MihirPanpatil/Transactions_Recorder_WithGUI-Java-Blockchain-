import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Block{
    
    private int index;
    private long timestamp;
    private String name;
    private String data;
    private String previousHash;
    private String hash;

    public Block(int index, String name, String data, String previousHash){
        super();
        this.index = index;
        this.name = name;
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }


    //Defining Basic Getter and Setter Methods
    public int getIndex() {
        return index;
    }
    public long getTimestamp() {
        return timestamp;
    }
    
    public String getName() {
        return name;
    }
    public String getData() {
        return data;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public String getHash() {
        return hash;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    
    //A Method to Calculate Hash value.
    public String calculateHash(){
        String text = String.valueOf(index + previousHash + String.valueOf(timestamp) + String.valueOf(data) + String.valueOf(name));

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);
        return encoded;
    }

}
