import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TestClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		SocketChannel[] scArray = new SocketChannel[5];
		for (int i = 0;i < 5;i++){
			TestClient tc = new TestClient();
			scArray[i] = tc.send();
		}
		
		Thread.sleep(5);
		for (int j = 0;j < 5;j++){
			scArray[j].close();
		}
		
		
	}
	
	private SocketChannel send() throws IOException{
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(true);
		socketChannel.connect(new InetSocketAddress ("localhost", 1234));
		for (int i = 0;i < 100;i++){
			ByteBuffer dst = ByteBuffer.allocate(15);
			dst.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o');
			dst.flip();
			socketChannel.write(dst);
		}
		return socketChannel;
		
	}

	public TestClient() {

	}
}
