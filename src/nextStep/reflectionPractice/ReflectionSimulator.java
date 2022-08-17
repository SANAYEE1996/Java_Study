package nextStep.reflectionPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionSimulator {

	public static void main(String[] args) {
		try {
			Class<?> personClass;
			personClass = Person.class;
			System.out.println(personClass.getName());
			personClass = Class.forName("nextStep.reflectionPractice.Person");
			System.out.println(personClass.getName());
			/*
			 * 패키지 네임이 포함된 클래스 이름을 forName 안에 인자로 넣어줘야 클래스 정보를 가져올 수 있다.
			 * 
			 * */
			Constructor<?> constructor = personClass.getDeclaredConstructor();
			System.out.println("Person() : "+constructor.getName());
			constructor = personClass.getDeclaredConstructor(int.class,String.class);
			System.out.println("Person(int, String) : "+constructor.getName());
			/*
			 * getDeclaredConstructor 안에 param 값으로 해당 클래스의 생성자를 부를 수 있다.
			 * 
			 * */
			Constructor<?> constructorArray[] = personClass.getDeclaredConstructors();
			System.out.println("모든 생성자 출력");
			for(Constructor<?> cons : constructorArray) {
				System.out.print(cons + ", ");
			}
			/*
			 * 모든 생성자를 가져오는 getDeclaredConstructors
			 * 
			 * */
			constructorArray = personClass.getConstructors();
			System.out.println("\n모든 public 생성자 출력");
			for(Constructor<?> cons : constructorArray) {
				System.out.print(cons + ", ");
			}
			/*
			 * 모든 public 생성자를 가져오는 getConstructors
			 * 
			 * */
			Method method = personClass.getDeclaredMethod("getAge", null);
			System.out.println("\nperson 객체의 getAge 메서드: "+method);
			/*
			 * 인자가 없는 메서드라면 null을 전달하면 된다.
			 * 
			 * */
			Class<?> paramArray[] = new Class[2];
			paramArray[0] = int.class;
			paramArray[1] = String.class;
			method = personClass.getDeclaredMethod("print", paramArray);
			System.out.println("메서드에 여러 인자가 전달 될때 : "+method);
			/*
			 * 인자가 여러개라면 클래스 배열을 만들어 전달합니다.
			 * 
			 * */
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
