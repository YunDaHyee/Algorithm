package ETC.KAKAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
	@Question
		프렌즈대학교 컴퓨터공학과 조교인 제이지는 네오 학과장님의 지시로, 학생들의 인적사항을 정리하는 업무를 담당하게 되었다.
		
		그의 학부 시절 프로그래밍 경험을 되살려, 모든 인적사항을 데이터베이스에 넣기로 하였고, 이를 위해 정리를 하던 중에 후보키(Candidate Key)에 대한 고민이 필요하게 되었다.
		
		후보키에 대한 내용이 잘 기억나지 않던 제이지는, 정확한 내용을 파악하기 위해 데이터베이스 관련 서적을 확인하여 아래와 같은 내용을 확인하였다.
		
		관계 데이터베이스에서 릴레이션(Relation)의 튜플(Tuple)을 유일하게 식별할 수 있는 속성(Attribute) 또는 속성의 집합 중, 다음 두 성질을 만족하는 것을 후보 키(Candidate Key)라고 한다.
		유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
		최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다. 즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
		제이지를 위해, 아래와 같은 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라.
		
		cand_key1.png
		
		위의 예를 설명하면, 학생의 인적사항 릴레이션에서 모든 학생은 각자 유일한 "학번"을 가지고 있다. 따라서 "학번"은 릴레이션의 후보 키가 될 수 있다.
		그다음 "이름"에 대해서는 같은 이름("apeach")을 사용하는 학생이 있기 때문에, "이름"은 후보 키가 될 수 없다. 그러나, 만약 ["이름", "전공"]을 함께 사용한다면 릴레이션의 모든 튜플을 유일하게 식별 가능하므로 후보 키가 될 수 있게 된다.
		물론 ["이름", "전공", "학년"]을 함께 사용해도 릴레이션의 모든 튜플을 유일하게 식별할 수 있지만, 최소성을 만족하지 못하기 때문에 후보 키가 될 수 없다.
		따라서, 위의 학생 인적사항의 후보키는 "학번", ["이름", "전공"] 두 개가 된다.
		
		릴레이션을 나타내는 문자열 배열 relation이 매개변수로 주어질 때, 이 릴레이션에서 후보 키의 개수를 return 하도록 solution 함수를 완성하라.
   
	@Restrictions
		relation은 2차원 문자열 배열이다.
		relation의 컬럼(column)의 길이는 1 이상 8 이하이며, 각각의 컬럼은 릴레이션의 속성을 나타낸다.
		relation의 로우(row)의 길이는 1 이상 20 이하이며, 각각의 로우는 릴레이션의 튜플을 나타낸다.
		relation의 모든 문자열의 길이는 1 이상 8 이하이며, 알파벳 소문자와 숫자로만 이루어져 있다.
		relation의 모든 튜플은 유일하게 식별 가능하다.(즉, 중복되는 튜플은 없다.)
		
	@Input.Output
		relation																																										result
		[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]		2
   
	@history
   		N = 문자열 배열로 주어지는 릴레이션에서의 후보키 개수
   		후보키 = 모든 튜플에 대해 유일하게 식별 돼야하고 식별에 필요한 최소한의 속성울 가지는 컬럼
   		
   		컬럼이 주어진대로 학번, 이름, 전공, 학년이 고정이면 relation[0], relation[0]+relation[1] 해서 무조건 2 아닌가 라고 생각해서 아닌 거 알지만 제출해봤는데 테케 28중에 3개만 맞는 거 보면 컬럼이 고정이 아닌 듯 하다..
   		그럼 값으로만 판단해야한단건데 값이 유일하면 그게 후보키가 될 가능성이 있다는 거니까 일단 인덱스별로 값을 모아봄
		
		BFS로 순서 상관없으니까 조합으로 풀어야함.
		
		처음엔 BFS로 하려고 했는데
		젤 깊게 들어가서 맨 마지막에서부터 계속 새로운 컬럼의 값이 붙어나오는 거 생각하니까 DFS가 맞겠다 싶어서 변경
		
		- 다른 사람 풀이 참고
		나는 문자 자체를 문자열 배열에다가 넣고 직접 비교를 하려고 했는데 인덱스로 저장하는 방식이 있었다.
		 
	@Date
		2022. 9. 11.
 */
public class 후보키_42890_다른사람풀이보고참조 {
	static List<String> candidateKeys = new ArrayList<String>();

	/**
	 * 100
	 * 100 ryan
	 * 100 music
	 * 100 2
	 * 100 ryan music
	 * 100 music 2
	 * 100 tyan music 2
	 * 
	 */
	
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"},{"700","apeach","music","3"}};

		for( int i=0;i<relation[0].length;i++ ){
			DFS( relation, new boolean[relation[0].length], 0, 0, i+1 );
		}
		
		System.out.println( candidateKeys.size() );
	}
	
	private static void DFS(String[][] relation, boolean[] needToVisit, int depth, int start, int end ) {
		if( depth==end ){
			List<Integer> columnListToCheck = new ArrayList<>();	// 검사해야할 컬럼의 인덱스를 하나씩 담는 리스트. 밑에서 중복검사 하기 위함
			StringBuilder colmnSetToCheck = new StringBuilder();	// 검사하는 모든 컬럼의 인덱스를 합친 String을 만듦
			
			// 1. 검사해야할 컬럼의 인덱스만으로 인덱스 조합과 조합의 전체를 담음
			for( int i=0;i<needToVisit.length;i++ ){
				if( !needToVisit[i] ){
					continue;
				}
				columnListToCheck.add(i);
				colmnSetToCheck.append( String.valueOf(i) );
			}
			
			// 2. 중복 검증 - 각 로우에서 검사해야할 컬럼까지만 돌면서 조합이 중복되는지 검사하고 하나라도 중복되면 리턴
			Set<String> validateDuplication = new HashSet<String>();
			
			for( int row=0;row<relation.length;row++){
				StringBuilder dataSet = new StringBuilder();
				for( Integer indexToCheck : columnListToCheck ){
					dataSet.append( relation[row][indexToCheck] );
				}
				if( validateDuplication.contains(dataSet.toString()) ){
					return;
				}
				validateDuplication.add( dataSet.toString() );
			}
			
			// 3. 후보키 검증 - 검사한 모든 컬럼의 인덱스만큼 돌면서 후보키에 추가할지 말지를 검증한다.
			for( String candidateKey : candidateKeys ){
				int candidateKeyHitCount = 0;
				for( int i=0;i<colmnSetToCheck.length();i++ ){ // 검사한 모든 컬럼의 인덱스만큼 돌면서
					if( candidateKey.contains(String.valueOf(colmnSetToCheck.charAt(i))) ){ // 포함할 컬럼의 인덱스가 후보키에 포함되면
						candidateKeyHitCount++; // 후보키 적중률 높임
					}
				}
				if( candidateKeyHitCount==candidateKey.length() ) { // 기존에 있던 키의 길이랑 같으면 그냥 리턴함
					return;
				}
			}
			
			candidateKeys.add(colmnSetToCheck.toString());
		}
		
		for( int i=start;i<needToVisit.length;i++ ){
			if( needToVisit[i] ){
				continue;
			}
			
			needToVisit[i] = true;
			DFS( relation, needToVisit, depth+1, i, end );
			needToVisit[i] = false;
		}
	}

}


