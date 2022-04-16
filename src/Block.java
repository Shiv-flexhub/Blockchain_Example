//import java.util.ArrayList;
import java.awt.*;
import java.util.Arrays;

public class Block {

    private String[] transactions;
    private int blockHash;
    private int prevBlockHash;
    private int nonce;


    @Override
    public String toString() {
        return "Block{" + "transactions=" + Arrays.toString(transactions) + ", blockHash=" + blockHash +
                ", prevBlockHash=" + prevBlockHash +
                ", nonce=" + nonce +
                '}';
    }

    public Block(String[] transactions, int prevBlockHash) {
        super();
        this.transactions = transactions;
        this.prevBlockHash = prevBlockHash;
        this.blockHash = blockhash();
        this.nonce=0;
    }

    public int blockhash(){
        return  Arrays.hashCode(new int[]{Arrays.hashCode(transactions), this.prevBlockHash, this.nonce});
    }

    public void mineBlock(int difficulty){

        String str = Integer.toString(this.blockHash);
        while(!str.substring(str.length()-difficulty-1, str.length()-1).equals("00")){
            this.nonce++;
            this.blockHash=blockhash();
            str = Integer.toString(this.blockHash);

        }
//        System.out.println(this.blockHash);



    }

    public String[] getTransactions() {
        return this.transactions;
    }

    public void setTransactions(String[] _transactions) {
        this.transactions = _transactions;
    }

    public int getBlockHash() {
        return this.blockHash;
    }

    public void setBlockHash(int _blockHash) {
        this.blockHash = _blockHash;
    }

    public int getPrevBlockHash() {
        return this.prevBlockHash;
    }

    public void setPrevBlockHash(int _prevBlockHash) {
        this.prevBlockHash = _prevBlockHash;
    }
}
