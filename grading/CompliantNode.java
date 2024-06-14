import java.util.ArrayList;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

    /**
     * Declare member variables for this class.
     */

    // Member variables for the class constructor.
    private double p_graph;
    private double p_malicious;
    private double p_txDistribution;
    private int numRounds;

    // Member variable that lists the followees of a node.
    private boolean[] followees;

    // Member variable that contains the transactions that are pending.
    private Set<Transaction> pendingTransactions;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // Set the member variables.
        this.p_graph = p_graph;
        this.p_malicious = p_malicious;
        this.p_txDistribution = p_txDistribution;
        this.numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        // Set the followees member variable for this node.
        this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // Set the pendingTransactions member variable for this node.
        this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> getProposals() {
        // Return the pendingTransactions member variable for this node.
        return this.pendingTransactions;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
        /**
         * Receive candidates from other nodes by adding them to the 
         * pendingTransactions member variable for this node.
         */
        for (int i = 0; i < candidates.size(); ++i) {
            // Add Transaction with ID candidates.get(i)[0] to pendingTransactions.
            int transactionID = candidates.get(i)[0];
            this.pendingTransactions.add(new Transaction(transactionID));
        }
    }
}
