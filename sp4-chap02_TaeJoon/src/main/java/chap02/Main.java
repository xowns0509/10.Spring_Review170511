package chap02;

import org.springframework.context.support.GenericXmlApplicationContext;

//임포트하는 GenericXmlApplicationContext 클래스는 XML 파일로부터 설정 정보를 읽어
//와 빈 객체를 생성하고 관리하는 기능을 제공한다.
public class Main {

	public static void main(String[] args) {
		// 1. 설정정보(xml)을 이용하여 빈 객체를 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// GenericXmlApplicationContext는 객체를 생성할 때
		// applicationContext.xml 파일의 경로를 생성자 파라미터로 전달하는데，
		// 이 경우 GenericXmlApplicationContext는 applicationContext.xml에 정의한 〈bean〉설정 정보를 읽어와
		// 내부적으로 Greeter 객체를 생성하고 초기화.

		// 2. 빈 객체를 제공
		Greeter g = ctx.getBean("greeter", Greeter.class);
		// getBean()메서드는 GenericXmlApplicationContext가 XML파일을 읽어와 생성한  빈(bean) 객체를 검색할 때 사용됨.
		// 첫 번째 파라미터는 〈bean〉태그의 id, 두 번째 파라미터는 검색할 빈 객체의 타입.
		// 앞서 작성한 XML파일을 보면 아래 코드와 같이 이름이 "greeter"이고 타입이 Greeter인 빈을 설정했으므로
		// getBean() 메서드는 아래 XML설정을 통해 생성되는 Greeter객체를 리턴.
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();

	}
}