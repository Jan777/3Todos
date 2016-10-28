package dominio;
import com.google.gson.Gson;
public class MensajeLogin {
	private String cadenaUser;
	
	public  String getObjSerializacion() {
		return cadenaUser;
	}
	public MensajeLogin(Usuario user)
	{
		Gson objSerializacion = new Gson();
		cadenaUser = objSerializacion.toJson(user);
	}
	public void enviarMensajeLogin(){};

}
