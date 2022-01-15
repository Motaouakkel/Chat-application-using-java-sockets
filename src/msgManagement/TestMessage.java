package msgManagement;

public class TestMessage {
	public static void main(String[] args) {
		IMsgImp ob = new IMsgImp();
		Msg msg = new Msg(1,"hi bro ?",316,"Cristen Giovanni");
		ob.addMsg(msg);
	}
}
