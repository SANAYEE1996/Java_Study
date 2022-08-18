package nextStep.reflectionPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSimulator {

	public static void main(String[] args) {
		try {
			Class<?> personClass;
			Class<?> manClass;
			personClass = Person.class;
			System.out.println(personClass.getName());
			personClass = Class.forName("nextStep.reflectionPractice.Person");
			manClass = Class.forName("nextStep.reflectionPractice.Man");
			System.out.println(personClass.getName());
			/*
			 * 패키지 네임이 포함된 클래스 이름을 forName 안에 인자로 넣어줘야 클래스 정보를 가져올 수 있다.
			 * 
			 * */
			System.out.println();
			Constructor<?> constructor = personClass.getDeclaredConstructor();
			System.out.println("Person() : "+constructor.getName());
			constructor = personClass.getDeclaredConstructor(int.class,String.class);
			System.out.println("Person(int, String) : "+constructor.getName());
			/*
			 * getDeclaredConstructor 안에 param 값으로 해당 클래스의 생성자를 부를 수 있다.
			 * 
			 * */
			System.out.println();
			Constructor<?> constructorArray[] = personClass.getDeclaredConstructors();
			System.out.println("모든 생성자 출력");
			for(Constructor<?> cons : constructorArray) {
				System.out.println("get all constructor from person : "+cons);
			}
			/*
			 * 모든 생성자를 가져오는 getDeclaredConstructors
			 * 
			 * */
			System.out.println();
			constructorArray = personClass.getConstructors();
			System.out.println("모든 public 생성자 출력");
			for(Constructor<?> cons : constructorArray) {
				System.out.println("get all public constructor from person : "+cons);
			}
			/*
			 * 모든 public 생성자를 가져오는 getConstructors
			 * 
			 * */
			System.out.println();
			Method method = personClass.getDeclaredMethod("getAge");
			System.out.println("person 객체의 getAge 메서드: "+method);
			/*
			 * 인자가 없는 메서드라면 null을 전달하면 된다.
			 * 
			 * */
			System.out.println();
			Class<?> paramArray[] = new Class[2];
			paramArray[0] = int.class;
			paramArray[1] = String.class;
			method = personClass.getDeclaredMethod("print", paramArray);
			System.out.println("메서드에 여러 인자가 전달 될때 : "+method);
			/*
			 * 인자가 여러개라면 클래스 배열을 만들어 전달합니다.
			 * 
			 * */
			System.out.println();
			Method methodArray[] = personClass.getDeclaredMethods();
			for(Method m : methodArray) {
				System.out.println("get all method in person object : "+m);
			}
			System.out.println();
			methodArray = manClass.getDeclaredMethods();
			for(Method m : methodArray) {
				System.out.println("get all method in man object : "+m);
			}
			System.out.println();
			methodArray = manClass.getMethods();
			for(Method m : methodArray) {
				System.out.println("get all method and inherited method also in man object : "+m);
			}
			/*
			 * 모든 메서드를 찾으려면 getDeclaredMethods 사용
			 * 하지만 공통적으로 이 함수 이름에 Declared가 드어가면 super 클래스의 정보는 가져오지 않음
			 * getMethods 함수를 사용하면 public 메서드를 리턴해주며 상속받은 메소드들도 모두 찾아줌
			 * 
			 * */
			System.out.println();
			Field field = personClass.getDeclaredField("name");
			System.out.println("find age field in person object : " +field);
			/*
			 * getDeclaredField는 전달받은 이름과 일치하는 field를 찾음
			 * 
			 * */
			System.out.println();
			Field fieldArray[] = personClass.getDeclaredFields();
			for(Field f : fieldArray) {
				System.out.println("get fields in Person Object : " +f);
			}
			System.out.println();
			fieldArray = manClass.getDeclaredFields();
			for(Field f : fieldArray) {
				System.out.println("get fields in Man Object : " +f);
			}
			System.out.println();
			fieldArray = manClass.getFields();
			for(Field f : fieldArray) {
				System.out.println("get all public fields and also inherited public fields in Man Object : " +f);
			}
			/*
			 * getDeclaredFields : 객체에 선언된 모든 field 를 찾음
			 * 근데 상속받은 객체의 정보는 찾아주지 않음.
			 * getFields : 상속 받은 클래스를 포함한 public Field를 찾으려면 
			 * 
			 * */
			System.out.println();
			method = manClass.getDeclaredMethod("isMan", String.class);
			System.out.println("return value : " +method.invoke(new Man(), "man"));
			method = manClass.getDeclaredMethod("shout");
			method.invoke(new Man());
			/*
			 * 메서드 객체를 생성하고 invoke 함수로 메서드를 호출해 실행 할 수 있다.
			 * 만약 메서드가 어떤 값을 리턴하면 그 값을 받을 수 있음. 
			 * 첫번 째 인자는 호출하려는 객체이고 두번 째 인자는 전달할 파라미터 값
			 * 
			 * */
			System.out.println();
			method = manClass.getDeclaredMethod("military");
//			method.invoke(new Man());
			System.out.println();
			method.setAccessible(true);
			method.invoke(new Man());
			/*
			 * getDeclaredMethod 는 상속받은 클래스의 정보를 가져오지 않기 때문에 꼭 해당하는 객체를 가져와야 한다.
			 * 그리고 private 메서드는 호출하지 못한다.
			 * setAccessible(true) 로 설정해주면 priavate 메서드에 접근 가능하도록 변경 됨
			 * */
			System.out.println();
			Person personObject = new Person();
			field = personClass.getField("age");
			System.out.println("before modify : " +field.get(personObject));
			field.set(personObject, 47);
			System.out.println("after modify : " +field.get(personObject));
			/*
			 * field 값 바꾸려면 set 함수 사용
			 * 첫 번째 인자로 field 값이 존재하는 객체, 두번째 인자로 바꿀 값 형식을 맞춰야함 
			 * 
			 * */
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SecurityException e) {
			e.printStackTrace();
		}catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
