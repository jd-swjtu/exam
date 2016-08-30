package exam;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("exam/");
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			File dir = new File(resource.getFile());
			for(File file: dir.listFiles()) {
				Class<?> klazz = Class.forName("exam." + file.getName().substring(0, file.getName().length() - 6));
				for(Method m: klazz.getMethods()) {
					LeetCode lc = m.getAnnotation(LeetCode.class);
					if(lc != null) {
						System.out.println("#" + lc.value() + " - " + klazz.getName() + " - " + m.getName());
					}
				}
			}
		}
	}

}
