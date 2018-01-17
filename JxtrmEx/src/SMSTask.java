import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;


public class SMSTask implements Callable<Boolean>{

	private String mes;
	public SMSTask(String message) {
		mes = message;
	}

	@Override
	public Boolean call() throws Exception {
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress(1234));
		SocketChannel s = channel.accept();
		ByteBuffer bbb = ByteBuffer.allocate(mes.length() * 4);
		Charset charset = Charset.forName("ISO-8859-1");
		bbb = charset.encode(mes);
		s.write(bbb);
		return true;
	}

}
