import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocketChannel ssc = ServerSocketChannel.open( );
		ssc.socket( ).bind (new InetSocketAddress (1234));
		ssc.configureBlocking (false);
		SocketChannel sc = null;
		do {
		Thread.sleep(3);
		System.out.println("waiting for new clients...");
		sc = ssc.accept();
		}
		while ( sc == null);
		ByteBuffer bb = ByteBuffer.allocate(15);
		bb.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o')
		.put((byte)' ').put((byte)'W').put((byte)'o').put((byte)'r').put((byte)'l').put((byte)'d');
		bb.flip();
		sc.write(bb);
		sc.close();
		}

}
