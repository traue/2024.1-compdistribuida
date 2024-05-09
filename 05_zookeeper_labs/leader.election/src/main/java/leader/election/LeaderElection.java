package leader.election;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

public class LeaderElection implements Watcher {

	private static final String ZOOKEEPER_ADDRESS = "34.228.23.62:80"; // endereço do ZooServer
	private static final int TIMEOUT = 3000;
	private static final String ELECTION_NAMESPACE = "/election";
	private ZooKeeper zooKeeper;
	private String currentZNodeName;

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		LeaderElection leaderElection = new LeaderElection();

		leaderElection.connectToZookeeper();
		leaderElection.volunteerForLeadership();
	}

	public void connectToZookeeper() throws IOException {
		this.zooKeeper = new ZooKeeper(ZOOKEEPER_ADDRESS, TIMEOUT, null);
	}

	public void volunteerForLeadership() throws KeeperException, InterruptedException {
		String znodePrefix = ELECTION_NAMESPACE + "/c_";
		String znodeFullPath = zooKeeper.create(znodePrefix, new byte[] {}, ZooDefs.Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);

		System.out.println("*****My Name: " + znodeFullPath + " *****");
		this.currentZNodeName = znodeFullPath.replace(ELECTION_NAMESPACE + "/", "");
	}

	@Override
	public void process(WatchedEvent event) {
		// implementaremos em breve

	}

}
