package or.clearn.service;

import java.io.IOException;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class FcmService {

	private static final String serverKey = "AAAAOS-BRIo:APA91bEEmn_y3T2hjIpYKFK9l0GLSmpLqu5dIZvHZK8FbnmKly4sZDUzHkzhROEh3sVQatitku1mzQyKbgeE8dJ6EsYJasKYr2MyDugmxEZdA4z6OY_P4f9Yt5_YiYK2Qjs0ZsuXJP8FzE1DW2GTqc2P27q_75_SXg";
	private Sender sender;
	private Message.Builder builder;

	public FcmService() {
		sender = new Sender(serverKey);
		builder = new Message.Builder();
	}

	// Data를 clientToken으로 전송하는 Method
	public void sendDataType1(String p_token, String msg) {
		builder.addData("title", "CLearn");
		builder.addData("message", msg);
		Message message = builder.build();
		try {
			sender.send(message, p_token, 5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
