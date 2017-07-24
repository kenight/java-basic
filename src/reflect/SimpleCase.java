package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class SimpleCase {

	@Test
	public void constructorReflect() {
		try {
			// Constructor constructor =
			// Class.forName("java.lang.String").getConstructor(StringBuilder.class);
			// String newStr = (String) constructor.newInstance(new
			// StringBuilder("OK"));
			// System.out.println(newStr);
			Constructor<Lady> constructor2 = Lady.class.getConstructor(String.class, List.class);
			Collection<String> c = new ArrayList<String>();
			c.add("mike");
			c.add("joe");
			Lady l = constructor2.newInstance(new String("seven"), new ArrayList<String>(c));
			System.out.println(l.getName());
			System.out.println(l.getFriend().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void FieldReflect() {
		Lady l = new Lady("seven", 21);
		try {
			Field name = l.getClass().getField("name");
			Field age = l.getClass().getDeclaredField("age");
			age.setAccessible(true);
			System.out.println(name.get(l));
			System.out.println(age.get(l));
			// 使用集合进行反射
			// Field[] field = l.getClass().getDeclaredFields();
			// for(Field f : field){
			// f.setAccessible(true);
			// System.out.println(f.get(l));
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void changeFieldValue() {
		Lady lady = new Lady("seven", 21);
		try {
			Field[] fields = lady.getClass().getDeclaredFields();
			for (Field f : fields) {
				if (f.getType() == String.class) {
					String oldname = (String) f.get(lady);
					String newname = oldname.replace("se", "cv");
					f.set(lady, newname);
				}
				if (f.getType() == int.class) {
					f.setAccessible(true);
					f.set(lady, 22);
				}
			}
			System.out.println(lady);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void methodReflect() throws Exception {
		String str = "reflect";
		// 通过反射调用String.charAt方法
		Method method = String.class.getMethod("charAt", int.class);
		System.out.println(method.invoke(str, 0));
		// 通过反射调用String.replace方法
		Method method2 = String.class.getMethod("replace", CharSequence.class, CharSequence.class);
		System.out.println(method2.invoke(str, "re", "ab"));
	}

	// 数组对象的反射
	@SuppressWarnings("rawtypes")
	@Test
	public void arrayReflect() {
		Object[] array = { "a", 2, 3 };
		Class clz = array.getClass();
		if (clz.isArray()) {
			int len = Array.getLength(array);
			for (int i = 0; i < len; i++) {
				System.out.println(Array.get(array, i));
				System.out.println(Array.get(array, i).getClass());
			}
		}
	}

}
