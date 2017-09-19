package exams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws Exception {
		//String _pack = "exams.aa";
		
		/*ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> resources = classLoader.getResources("exams/");
		int count = 0;
		Map<Integer,String> questions = new HashMap<Integer, String>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			File dir = new File(resource.getFile());
			for(File file: dir.listFiles()) {
				if(file.isDirectory()) {
					System.out.println(file.getName());
				} else
				if(!file.getName().endsWith(".class")) continue;
				System.out.println(file.getName());
			}
		}
		System.out.println("Total @LeetCode = " + count);
		Set<Integer> keys = new TreeSet<Integer>(questions.keySet());
		for(Integer key: keys) {
			System.out.println(questions.get(key));
		}*/
		
		read(null);
	}

	public static Map<String,String> scan() throws Exception {
		Map<String,String> questions = new HashMap<String,String>();
		
		File folder = new File("./src/exams/");
		for(File f: folder.listFiles()) {
			if(f.isDirectory()) {
				for(File ff: f.listFiles()) {
					if(ff.getName().startsWith("N")) {
						questions.put(String.valueOf(Integer.valueOf(ff.getName().substring(1, ff.getName().indexOf(".")))),
								"exams." + f.getName() + "." + ff.getName());
					}
				}
			}
		}
		return questions;
	}
	
	public static void read(String pCat) throws Exception {
		Map<String,String> questions = scan();
		
		BufferedReader br = new BufferedReader(new FileReader(new File("./cat.txt")));
		String line = null;
		String cat = null;
		int count = 0;
		Pattern ptrn = Pattern.compile("^(\\d+)\\s+(.+\\s+[0-9.]+%\\s+.+?)\\s*$");
		while((line = br.readLine()) != null) {
			if(line.startsWith("[") && line.endsWith("]")) {
				cat = line.substring(1, line.length() - 1);
			}
			
			if(cat != null) {
				//65	Valid Number	12.5%	Hard
				Matcher m = ptrn.matcher(line);
				if(m.find()) {
					if(pCat != null) {
						if(pCat.equals(cat)) {
							System.out.println(cat + " " + m.group(1) + " " + m.group(2) + " = " + questions.getOrDefault(m.group(1), ""));
							count++;
						}
					} else {
						System.out.println(cat + " " + m.group(1) + " " + m.group(2) + " = " + questions.getOrDefault(m.group(1), ""));
						count++;
					}
				}
			}
		}
		System.out.println("Total " + count);
		br.close();
	}
}
