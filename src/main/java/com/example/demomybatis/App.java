package com.example.demomybatis;

import com.example.demomybatis.mq.Receiver;
import com.example.demomybatis.util.DateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableScheduling
//ensures that a background task executor is created. Without it, nothing gets scheduled.
public class App extends SpringBootServletInitializer {

	public static final String topicExchangeName = "spring-boot-exchange";

	public static final String queueName = "spring-boot";

//	@Bean
//	Queue queue() {
//		return new Queue(queueName, false);
//	}
//
//	//The exchange() method creates a topic exchange
//	@Bean
//	TopicExchange exchange() {
//		return new TopicExchange(topicExchangeName);
//	}
//
//	@Bean
//	Binding binding(Queue queue, TopicExchange exchange) {
//		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
//	}
//
//	//AMQP producers don’t send messages directly to queues.
//	// Instead, a message is sent to an exchange,
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//											 MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(Receiver receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return (args) -> {
//			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//			String password1 =  "Admin";
//			String encoding_password1 = bCryptPasswordEncoder.encode(password1);
//
//			boolean match1 = bCryptPasswordEncoder.matches(password1,encoding_password1);
//			System.out.println("Encoding_password1: " + encoding_password1);
//			System.out.println("matches " + password1 + "boolean = " + match1);

//			Date date = new Date();
//			long times = date.getTime();//时间戳
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String dateString = formatter.format(date);
//			System.out.println(dateString);

//			Calendar cal = Calendar.getInstance();
//			int year = cal.get(Calendar.YEAR);//获取年份
//			int month=cal.get(Calendar.MONTH) + 1;//获取月份
//			int day=cal.get(Calendar.DATE);//获取日
//			int hour=cal.get(Calendar.HOUR);//小时
//			int minute=cal.get(Calendar.MINUTE);//分
//			int second=cal.get(Calendar.SECOND);//秒
//			DateFormat df_date = new SimpleDateFormat("yyyy-MM-dd");
//			DateFormat df_time = new SimpleDateFormat("HH:mm:ss");
//			String d = df_date.format(date);
//			String t = df_time.format(date);
//			String aa = d + " " + t;
//			Date test = DateUtil.parse(aa);
//
//			Calendar tempEnd = Calendar.getInstance();
//			tempEnd.setTime(date);
//			tempEnd.add(Calendar.DAY_OF_YEAR,1);
//			Date nextDay = tempEnd.getTime();
//			System.out.println(nextDay.toString());
//
//			System.out.println(dateString);

		};
	}


}
