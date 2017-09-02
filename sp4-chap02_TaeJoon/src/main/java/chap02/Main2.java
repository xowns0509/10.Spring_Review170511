// 싱글톤 객체 테스트
package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

//임포트하는 GenericXmlApplicationContext 클래스는 XML 파일로부터 설정 정보를 읽어
//와 빈 객체를 생성하고 관리하는 기능을 제공한다.
public class Main2 {

	public static void main(String[] args) {
		// 1. 설정정보(xml)을 이용하여 빈 객체를 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// 2. 빈 객체를 제공
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);

		// 출력은 오른쪽 주석과 같을 것이다.
		System.out.println("(g1 == g2): " + (g1 == g2)); // (g1 == g2): true
		System.out.println("(g1 != g2): " + (g1 != g2)); // (g1 != g2): false

		// xml의 bean에 별도 설정을 하지 않을 경우 한 개의 빈 객체만을 생성,
		// 이들 빈 객체들이 singleton(= 단일 객체) 범위를 갖는다고 표현함.
		// 스프링은 기본적으로 한 개의 <bean>태그에 한 개의 빈 객체를 생성.
		ctx.close();

	}
}