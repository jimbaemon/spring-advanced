package hello.advanced.trace.stratagy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.stratagy.code.strategy.ContextV1;
import hello.advanced.trace.stratagy.code.strategy.ContextV2;
import hello.advanced.trace.stratagy.code.strategy.Strategy;
import hello.advanced.trace.stratagy.code.strategy.StrategyLogic1;
import hello.advanced.trace.stratagy.code.strategy.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {


	/**
	 * 전략 패턴 사용
	 */
	@Test
	void strategyV1(){
		ContextV2 context = new ContextV2();
		context.execute(new StrategyLogic1());
		context.execute(new StrategyLogic2());
	}

	/**
	 * 전략 패턴 익명 내부 클래스 사용
	 */
	@Test
	void strategyV2(){
		ContextV2 context = new ContextV2();
		context.execute(() -> log.info("비즈니스 로직 실행 1"));
		context.execute(() -> log.info("비즈니스 로직 실행 2"));
	}
}
