package hello.advanced.app.v2;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

	private final HelloTraceV2 trace;

	public void save(final TraceId traceId, String itemId){
		//저장 로직
		TraceStatus status = null;
		try {
			status = trace.beginSync(traceId, "OrderRepository.save()");

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
