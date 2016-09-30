package exam;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("exam/");
		int count = 0;
		Map<Integer,String> questions = new HashMap<Integer, String>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			File dir = new File(resource.getFile());
			for(File file: dir.listFiles()) {
				if(!file.getName().endsWith(".class")) continue;
				Class<?> klazz = Class.forName("exam." + file.getName().substring(0, file.getName().length() - 6));
				for(Method m: klazz.getMethods()) {
					LeetCode lc = m.getAnnotation(LeetCode.class);
					if(lc != null) {
						questions.put(lc.value(), String.format("#%03d - %1s - %20s - %s", lc.value(), lc.c(), klazz.getName(), m.getName()));
						
						count++;
					}
				}
			}
		}
		System.out.println("Total @LeetCode = " + count);
		Set<Integer> keys = new TreeSet<Integer>(questions.keySet());
		for(Integer key: keys) {
			System.out.println(questions.get(key));
		}
	}
}
