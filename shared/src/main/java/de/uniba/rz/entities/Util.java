package de.uniba.rz.entities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Util {

	public static byte[] objectToStream(Object ob) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(ob);
			oos.flush();

			byte[] Buf = baos.toByteArray();
			return Buf;
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return new byte[0];
	}
	
	public static Object byteStreamToObject(byte[] bytestream) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(bytestream);
            ObjectInput in = new ObjectInputStream(bis);
            return in.readObject();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

}
