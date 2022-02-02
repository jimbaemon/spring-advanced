package hello.advanced.trace;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TraceId {

	private String id;
	private int level;

	public TraceId() {
		this.id = createId();
		this.level = 0;
	}

	private String createId() {
		//생성된 UUID 의 앞자리만 사용
		return UUID.randomUUID().toString().substring(0, 8);
	}

	public TraceId createNextId(){
		return new TraceId(id, level + 1);
	}

	public TraceId createPreviousId(){
		return new TraceId(id, level - 1);
	}

	public boolean isFirstLevel(){
		return level == 0;
	}



}
