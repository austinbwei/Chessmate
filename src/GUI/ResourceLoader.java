package GUI;

import java.io.InputStream;

public class ResourceLoader {

	/**
	 * Create path for executable jar picture generation
	 * @param path in project of image
	 * @return InputStream of picture for the executable jar
	 */
	public static InputStream load(String path) {
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if (input == null) {
			input = ResourceLoader.class.getResourceAsStream("/" + path);
		}
		return input;
	}

}
