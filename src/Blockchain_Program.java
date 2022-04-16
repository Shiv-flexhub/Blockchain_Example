import java.util.ArrayList;

public class Blockchain_Program {

    public ArrayList<Block> blockChain = new ArrayList<Block>();

    public int difficulty=2;

    public Blockchain_Program(String[] tran, int prev) {
        Block genesisBlock = new Block(tran   , prev);
        genesisBlock.mineBlock(this.difficulty);
        this.blockChain.add(genesisBlock);

    }


    public Block getLatestBlock(){
        return blockChain.get(this.blockChain.size() - 1);
    }

    public void addBlock(Block newBlock){
        newBlock.setPrevBlockHash(getLatestBlock().getBlockHash());
       newBlock.mineBlock(this.difficulty);
        this.blockChain.add(newBlock);
    }

    public void printChain(){
        System.out.println("Blockchain is "+this.blockChain);
    }

    public boolean isChainValid(){
        for (int i=1;i<this.blockChain.size();i++){
            Block prevBlock = this.blockChain.get(i-1);
            Block currBlock = this.blockChain.get(i);


            if(currBlock.getPrevBlockHash()!=prevBlock.getBlockHash()) return false;
            if(currBlock.getBlockHash()!=currBlock.blockhash()) return false;
        }
        return true;
    }



    public static void main(String[] args){


        Blockchain_Program TestCoin = new Blockchain_Program(new String[]{"Shiva gave Ishita $500"},0);

        //Second Block
        String second[] ={"Shiva gave Akshita $10"};
        Block secondBlock = new Block(second,0);
        TestCoin.addBlock(secondBlock);

        //Third Block
        String third[] ={"Ishita gave Shiva $250"};
        Block thirdBlock = new Block(third,0);
        TestCoin.addBlock(thirdBlock);



//       thirdBlock.setTransactions(new String[]{"Ishita gave Shiva $25"});


//        thirdBlock.setTransactions(new String[]{"Harpreet gave Shiva $61", "Akshita gave Harpreet $20", "Shiva gave Ishita $50"});
        if(TestCoin.isChainValid()) {
            System.out.println("The Chain is valid");
            TestCoin.printChain();
        }
        else System.out.println("Data has been tampered");


    }
}
