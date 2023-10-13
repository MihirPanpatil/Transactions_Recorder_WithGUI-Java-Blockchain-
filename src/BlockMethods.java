import java.util.ArrayList;
import java.util.List;

public class BlockMethods {
    
    public List<Block> blockChain = new ArrayList<>();     //A Dynamic Array which indexes the BLocks.
    
    public List<Block> getBlockChain() {    
        return blockChain;
    }

    public Block getLatestBlock(){  
        if (blockChain.isEmpty()) {
            createGenesisBlock();
        }
        return blockChain.get(blockChain.size()-1);
    }
    
    //A method to generate GENESIS Block.
    //By Default, It would always run at the start of the execution.
    public void createGenesisBlock(){
        blockChain.add(new Block(0,"System","Genesis Block Generated","0"));
    }

    //[V.Imp] A method to add Blocks.
    public void addBlock(String data, String name){
        Block previousBlock = getLatestBlock();
        Block newBlock = new Block(previousBlock.getIndex()+1, name, data, previousBlock.getHash());
        blockChain.add(newBlock);
    }

    //A method to Check if the Chain has been Tampered or not.
    public boolean isChainValid(){
        for(int i=1; i<blockChain.size(); i++){
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i-1);

            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                return false;
            }
            if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())){
                return false;
            }
        }
        return true;
    }

    //A Method to display all Data values i.e. Amount.
    public void displayValues(){
        System.out.println("");
        for(int i=1; i<blockChain.size(); i++){
            System.out.println(blockChain.get(i).getData());
        }
    }

    //A Method to display all Hash values.
    public void displayHash(){
        System.out.println("");
        for(int i=1; i<blockChain.size(); i++){
            System.out.println(blockChain.get(i).getIndex() + ". " + blockChain.get(i).getHash());
        }
    }

    //A Method to display all Timestamp values.
    public void displayTimeStamp(){
        System.out.println("");
        for(int i = 1; i<blockChain.size(); i++){
            System.out.println(blockChain.get(i).getTimestamp());
        }
    }

    //A Method to display all Names.
    public void displayName(){
        System.out.println("");
        for(int i=1; i<blockChain.size(); i++){
            System.out.println(blockChain.get(i).getName());
        }
    }

    //All the above methods ignore the Genesis Block.
    
}
