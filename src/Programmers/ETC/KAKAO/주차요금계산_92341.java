/**
 * 
 */
package ETC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 	@Question
		주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때, 차량별로 주차 요금을 계산하려고 합니다.
		아래는 하나의 예시를 나타냅니다.
		
		요금표
		기본 시간(분)		기본 요금(원)	단위 시간(분)	단위 요금(원)
		180					5000			10				600
		 
		
		입/출차 기록
		시각(시:분)		차량 번호	내역
		05:34			5961		입차
		06:00			0000		입차
		06:34			0000		출차
		07:59			5961		출차
		07:59			0148		입차
		18:59			0000		입차
		19:09			0148		출차
		22:59			5961		입차
		23:00			5961		출차
		 
		
		자동차별 주차 요금
		차량 번호	누적 주차 시간(분)	주차 요금(원)
		0000		34 + 300 = 334		5000 + [(334 - 180) / 10] x 600 = 14600
		0148		670					5000 + [(670 - 180) / 10] x 600 = 34400
		5961		145 + 1 = 146		5000
		
		어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
		0000번 차량은 18:59에 입차된 이후, 출차된 내역이 없습니다. 따라서, 23:59에 출차된 것으로 간주합니다.
		00:00부터 23:59까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산합니다.
		누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
		누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
		초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
		⌈a⌉ : a보다 작지 않은 최소의 정수를 의미합니다.
		즉, 올림을 의미합니다.
		주차 요금을 나타내는 정수 배열 fees, 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다.
		차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
				
	@Restrictions
		fees의 길이 = 4
		
		fees[0] = 기본 시간(분)
		1 ≤ fees[0] ≤ 1,439
		fees[1] = 기본 요금(원)
		0 ≤ fees[1] ≤ 100,000
		fees[2] = 단위 시간(분)
		1 ≤ fees[2] ≤ 1,439
		fees[3] = 단위 요금(원)
		1 ≤ fees[3] ≤ 10,000
		1 ≤ records의 길이 ≤ 1,000
		
		records의 각 원소는 "시각 차량번호 내역" 형식의 문자열입니다.
		시각, 차량번호, 내역은 하나의 공백으로 구분되어 있습니다.
		시각은 차량이 입차되거나 출차된 시각을 나타내며, HH:MM 형식의 길이 5인 문자열입니다.
		HH:MM은 00:00부터 23:59까지 주어집니다.
		잘못된 시각("25:22", "09:65" 등)은 입력으로 주어지지 않습니다.
		차량번호는 자동차를 구분하기 위한, `0'~'9'로 구성된 길이 4인 문자열입니다.
		내역은 길이 2 또는 3인 문자열로, IN 또는 OUT입니다. IN은 입차를, OUT은 출차를 의미합니다.
		records의 원소들은 시각을 기준으로 오름차순으로 정렬되어 주어집니다.
		records는 하루 동안의 입/출차된 기록만 담고 있으며, 입차된 차량이 다음날 출차되는 경우는 입력으로 주어지지 않습니다.
		같은 시각에, 같은 차량번호의 내역이 2번 이상 나타내지 않습니다.
		마지막 시각(23:59)에 입차되는 경우는 입력으로 주어지지 않습니다.
		아래의 예를 포함하여, 잘못된 입력은 주어지지 않습니다.
		주차장에 없는 차량이 출차되는 경우
		주차장에 이미 있는 차량(차량번호가 같은 차량)이 다시 입차되는 경우
		제한시간 안내 - 정확성 테스트 : 10초
		
	@Input.Output
		입출력 예
		fees					records																																							
		[180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
		[120, 0, 60, 591]		["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]
		[1, 461, 1, 10]			["00:00 1234 IN"]
		
		result
		[14600, 34400, 5000]
		[0, 591]
		[14841]
		
		입출력 예 설명
		입출력 예 #1
		문제 예시와 같습니다.
		
		입출력 예 #2
		요금표
		기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
		120					0				60				591
		
		입/출차 기록
		시각(시:분)	차량 번호	내역
		16:00	3961	입차
		16:00	0202	입차
		18:00	3961	출차
		18:00	0202	출차
		23:58	3961	입차
		
		자동차별 주차 요금
		차량 번호	누적 주차 시간(분)	주차 요금(원)
		0202		120					0
		3961		120 + 1 = 121		0 +[(121 - 120) / 60]x 591 = 591
		3961번 차량은 2번째 입차된 후에는 출차된 내역이 없으므로, 23:59에 출차되었다고 간주합니다.
		 
		 
		입출력 예 #3
		요금표
		기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
		1				461				1				10
		
		입/출차 기록
		시각(시:분)	차량 번호	내역
		00:00	1234	입차
		
		자동차별 주차 요금
		차량 번호	누적 주차 시간(분)	주차 요금(원)
		1234		1439				461 +[(1439 - 1) / 1]x 10 = 14841
		1234번 차량은 출차 내역이 없으므로, 23:59에 출차되었다고 간주합니다.


	@history
		누적 주차시간	<= 기본시간      : 기본요금
			            >                : 기본요금+[누적시간-기본시간/단위시간]*단위요금
			                                      	 ---------------------------
			                                      	 ㄴ>나머지가 0이 아니면 올림(a보다 작지 않은 최소의 정수)함
			                                      	 
		브루트포스..?
		어차피 차량번호 작은 자동차순으로 정렬이 필요함
		
		in,out한 차들에 대해서 선작업 안하고 순차대로 진행하다가 out이 나오면 이미 in 한 게 있따는 거니까 그떄 빼는 작업을 하는 게 나은 듯
		이라고 생각했는데 
		
	@Date
		2022. 5. 29.
 */

/*class InAndOut {
	private String in;
	private String out;
	
	public InAndOut(String in, String out) {
		super();
		this.in = in;
		this.out = out;
	}

	public void setOut(String out) {
		this.out = out;
	}
}*/

class CumulativeCharge {
	private String inTime;
	private int cumulativeTime;
	private int charge;

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getInTime() {
		return inTime;
	}

	public int getCumulativeTime() {
		return cumulativeTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	public void setCumulativeTime(int cumulativeTime) {
		this.cumulativeTime = cumulativeTime;
	}

	public CumulativeCharge(String inTime, int cumulativeTime) {
		super();
		this.inTime = inTime;
		this.cumulativeTime = cumulativeTime;
	}
	
}

public class 주차요금계산_92341 {
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600}; // 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
		// {120, 0, 60, 591};
		// {1, 461, 1, 10};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		// {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		// {"00:00 1234 IN"};

		Map<String, CumulativeCharge>	recordSet	= new HashMap<String, CumulativeCharge>();
		List<Integer>					charges		= new ArrayList<Integer>();
		
		// TODO TreeMap으로 구현 해보기 - 키 별 오름차순 삽입 가능
		/* 차번호 별 누적시간 계산 */
		for( int i=0;i<records.length;i++ ){
			String[]			rawRecord	= records[i].split(" ");
			CumulativeCharge	record		= new CumulativeCharge(rawRecord[0], 0);
			
			// 이미 키가 있는 경우는 in으로 들어왔었다는 것
			if( recordSet.containsKey(rawRecord[1]) ) {
				record = recordSet.get(rawRecord[1]);
				if( recordSet.get(rawRecord[1]).getInTime()!=null ){// 1번 이상 들어온 차들은 누적값을 위해 in 시간만 갱신
					// 기존 누적 시간 + 새로운 주차 시간
					record.setCumulativeTime(
							record.getCumulativeTime() 
							+ calculationCumulativeTime(rawRecord[0], record.getInTime())
					);
					record.setInTime(null);
				}else {
					record.setInTime(rawRecord[0]);
				}
				continue;
			}
			recordSet.put( rawRecord[1], record );
		}
		
		/*
		  	누적 주차시간	<= 기본시간      : 기본요금
			            	>                : 기본요금+[누적시간-기본시간/단위시간]*단위요금
		 */
		for( String key : recordSet.keySet() ) {
			int					fee		= fees[1];
			CumulativeCharge	charge	= recordSet.get(key);
			
			// null이 아니란 소리는 out이 안나왔기 때문에 null 처리 작업을 안거쳤단 소리. 그거는 다 2359으로 처리
			if( charge.getInTime()!=null ){
				charge.setCumulativeTime( charge.getCumulativeTime()+calculationCumulativeTime("23:59",charge.getInTime()) );
			}
			
			// 기준요금 여부 판단
			if( charge.getCumulativeTime()>fees[0] ){
				int subtraction = charge.getCumulativeTime()-fees[0];
				int quotient	= subtraction/fees[2];
				if( subtraction%fees[2]!=0 ) {
					// quotient = (int)Math.ceil( quotient ); // TODO 14000원나오므ㅡㅡㅡㅡ 
					quotient = (int) Math.ceil( (double)(subtraction) / fees[2] ); // dobule로ㅓ 안하면 정수로만 떨어져서 이렇게 앞에 double 지정해줘야함
				}
				fee += quotient*fees[3];
			}
			
			charge.setCharge(fee);
		}
		
		/* 차번호가 작은 순서대로 key 정렬 */
		Object[] mapKey = recordSet.keySet().toArray();
		Arrays.sort(mapKey);

		/* 정렬한 키 기준으로 결과 리스트의 데이터 추출 */
		for( int i=0;i<mapKey.length;i++ ) {
			charges.add(recordSet.get(mapKey[i]).getCharge());
		}
		
	}
	
	/* 시 -> 분 후, 주차시간 계산 */
	public static int calculationCumulativeTime(String rawOutTime, String rawInTime) {
		String[] outTimes = rawOutTime.split(":");
		String[] inTimes = rawInTime.split(":");
		int outTime = Integer.parseInt(outTimes[0])*60+Integer.parseInt(outTimes[1]);
		int inTime = Integer.parseInt(inTimes[0])*60+Integer.parseInt(inTimes[1]);
		return outTime - inTime;
	}
}


