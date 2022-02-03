package hello.advanced.app.v1;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

	private final HelloTraceV1 trace;

	public void save(String itemId){
		//저장 로직
		TraceStatus status = null;
		try {
			status = trace.begin("OrderRepository.save()");

			if (itemId.equals("ex")){
				throw  new IllegalStateException("예외 발생!!");
			}
			sleep(1000);

			trace.end(status);
		}catch (Exception e){
			trace.exception(status, e);
			throw e;
		}
	}

	private void sleep(final int mills) {
		try {
			Thread.sleep(mills);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}

}
