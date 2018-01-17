import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

public static void main(String[] args) throws IOException {
	SocketChannel socketChannel = SocketChannel.open();
	socketChannel.configureBlocking(true);
	socketChannel.connect(new InetSocketAddress ("localhost", 1234));
	ByteBuffer dst = ByteBuffer.allocate(15);
	socketChannel.read(dst);
	byte[] result = new byte[15];
	dst.rewind();
	dst.get(result);
	for (int i = 0;i < result.length;i++){
		System.out.print((char)result[i] + " ");
	}
}
}
