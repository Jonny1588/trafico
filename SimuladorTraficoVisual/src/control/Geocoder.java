package control;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;

public class Geocoder {
	
	static String colorMarkers="black";
	static String letraMarkers="C";

public static Image createImageMap1(String paramsVehiculo,String paramsPeaton,String paramsSemaforo,String semaforo) throws MalformedURLException,IOException {
		
		URLConnection con = new URL("http://maps.googleapis.com/maps/api/staticmap?zoom=17&size=10240x900&maptype=HYBRID&sensor=true&markers=color:"+colorMarkers+"%7Clabel:"+letraMarkers+"%7C|"
		+ paramsVehiculo+"&markers=color:blue|"+paramsPeaton+"&markers=color:"+semaforo+"|"+paramsSemaforo).openConnection();
		InputStream is = con.getInputStream();
		ByteBuffer bb = ByteBuffer.allocate(con.getContentLength());
		int readed = 0;
		byte[] b = new byte[1];
		while (readed < bb.capacity()) {
		readed += is.read(b);
		bb.put(b);
		}
		System.out.println(readed +" -- "+con);
		is.close();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image map = tk.createImage(bb.array());
		// tk.prepareImage(map, 400, 400, null);
		
		return map;
	}
	
}
