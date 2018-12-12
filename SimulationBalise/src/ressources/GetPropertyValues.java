package ressources;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {

	static GetPropertyValues instance;
	static String propFileName = "config.properties";
	
	public static int getValuePropertie(String nom) {
		
		int valeur = 0;
		try {
			Properties prop = new Properties();
			InputStream fichier = getInstance().getClass().getClassLoader().getResourceAsStream(propFileName);
			 
			if (fichier != null) {
				prop.load(fichier);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			String result = prop.getProperty(nom);
			valeur = Integer.parseInt(result);
			fichier.close();
		} catch (Exception e) {
			valeur = 0;
		}
		return valeur;
	}
	
	public static String getValuePropertieString(String nom) {
		
		String valeur = "";
		try {
			Properties prop = new Properties();
			InputStream fichier = getInstance().getClass().getClassLoader().getResourceAsStream(propFileName);
			 
			if (fichier != null) {
				prop.load(fichier);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			valeur = prop.getProperty(nom);
			fichier.close();
		} catch (Exception e) {
			valeur = "";
		}
		return valeur;
	}

	public static GetPropertyValues getInstance() {
		if(instance==null) {
			instance = new GetPropertyValues();
		}
		return instance;
	}
}
