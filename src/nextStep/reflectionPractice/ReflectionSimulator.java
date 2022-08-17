package nextStep.reflectionPractice;

import java.lang.reflect.Constructor;

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
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
