package summerboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import summerboard.dto.SummerBoardDTO;

public class SummerBoardDAO {
		// 게시판의 db와 연동을 담당
		// jdbc 5단계를 사용
		// 1단계 : connect 객체를 사용하여 ojdbc.jar 생성
		// 2단계 : url, id, pw, sql 쿼리문 작성
		// 3단계 : 쿼리문 실행
		// 4단계 : 쿼리문 실행 결과 받기
		// 5단계 : 연결 종료를 진행
	
	// 필드
		public SummerBoardDTO summerBoardDTO = new SummerBoardDTO();
		public Connection connection = null; // 1단계 사용 객체
		public Statement statement = null; // 3단계 사용 객체 (구형) , 변수 직접처리 '"+name+"'
		public PreparedStatement preparestatement = null; // 3단계 사용 객체 (신형), ?(인파라미터)
		public ResultSet resultSet = null; // 4단계에서 결과 받는 표 객체 (select 결과)
		public int result = 0; // 4단계에서 결과 받는 정수 (insert, update, delete 결과)
		// 1개의 행이 삽입 | 수정 | 삭제 되었습니다 ( 정상처리 -> commit )
		// 0개의 행이 삽입 | 수정 | 삭제 되었습니다 ( 비정상처리 -> rollback )
		
		// 기본생성자는 클래스랑 이름을 똑같이 만듦
		public SummerBoardDAO()  {
			try { // 예외가 발생 할 수 있는 실행문, 프로그램 강제종료 처리용
				Class.forName("oracle.jdbc.driver.OracleDriver");//1단계 ojdbc.jar 호출
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","summerboard","summerboard");
			}catch (ClassNotFoundException e) {
				System.out.println("~ 드라이버 이름이나 ojdbc6.jar 파일이 잘못되었습니다 -.-^ ~");
				e.printStackTrace();
			}catch (SQLException e) {
				System.out.println("~ URL, ID, PW가 잘못되었습니다 -.-^ summerBoardDAO를 확인하세요 ㅠ.ㅠ ~ ");
				e.printStackTrace();
				System.exit(0);//강제종료
			}
		}// 기본생성자 종료
		
		// 메서드
	public void selectAll()throws SQLException {
		// SQL을 사용하여 전체 목록 보기 결과 출력
		try {
			String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
			// 데이터 베이스에 board 테이블 내용을 가져오는 쿼리문
			statement = connection.createStatement();// 쿼리문을 실행 할 객체 생성
			resultSet = statement.executeQuery(sql);// 쿼리문을 실행해 결과를 표로 받음
			
			System.out.println("번호\t   제목\t\t\t\t  작성자\t\t     작성일\t");
			while (resultSet.next()) {
			// 결과 표의 위에서부터 아래까지 내려오면서 출력
				System.out.print(resultSet.getInt("bno") +" : ");
				System.out.print(resultSet.getString("btitle") + "\t"+" : ");
				System.out.print(resultSet.getString("bwriter") + "\t "+" : ");
				System.out.println(resultSet.getDate("bdate") + "\t" );
				System.out.println("--------------------------------------------------");
			}//while 종료
			
			}catch (SQLException e) {
				// 오류발생시 예외처리문
				System.out.println("selectALL() 메서드에 쿼리문이 잘 못 되었습니다");
				e.printStackTrace();
				System.exit(0);
			}finally { // 항상 실행문
				resultSet.close(); 
				statement.close();
				
				
			}// finally 종료
		
	}//selectAll 메서드 종료

	public void insertBoard(SummerBoardDTO summerBoardDTO, Scanner inputStr) throws SQLException{
		// jdbc를 이용하여 insert 쿼리를 처리
		// preparestatement : 동적쿼리문, ?를 사용하여 세터로 입력
		
		try { String sql = "insert into board (bno, btitle, bcontent, bwriter, bdate)" + "values (board_seq.nextval,?,?,?,sysdate)";
				preparestatement = connection.prepareStatement(sql);
				preparestatement.setString(1, summerBoardDTO.getBtitle()); // 1번째?에 있는 dto 객체 제목을 넣음
				preparestatement.setString(2, summerBoardDTO.getBcontent());// 2번째?에 있는 dto 객체 제목을 넣음
				preparestatement.setString(3, summerBoardDTO.getBwriter());// 3번째?에 있는 dto 객체 제목을 넣음
				
				System.out.println("쿼리확인: "+sql); // 테스트용 코드
				result = preparestatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
				//result = preparestatement.executeUpdate(sql);하면 오류발생 -> 자동으로 되기 때문에 오류가 남
		
				if (result>0) {
					System.out.println(" * "+ result + "개의 게시물이 등록 되었습니다");
					connection.commit();
				}else {
					System.out.println("쿼리 실행 결과: " + result);
					System.out.println("~ 입력이 실패했습니다 ㅠ.ㅠ ~");
					connection.rollback(); // 저장 취소
					
				} // if 종료
				
		}catch (SQLException e) {
			System.out.println("insertBoard() 메서드에서 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally { // 예외 발생 및 정상 실행 후 무조건 처리되는 실행문
			preparestatement.close();
		//	connection.close();
		}//finally 종료
				
				
	} // insertBoard 종료

	public void readOne(String title) throws SQLException{
		// 제목 문자열이 넘어온 것을 select 처리하여 출력
		
		try {
			String sql = " select bno, btitle, bcontent, bwriter, bdate from board where btitle = ?";
			preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1,  title); // service에서 넘어온 찾고 싶은 제목이 ?로 넘어간다
			resultSet = preparestatement.executeQuery(); // 쿼리문 실행 후 결과를 표로 받는다
			
			if (resultSet.next()) {
			 SummerBoardDTO summerBoardDTO = new SummerBoardDTO(); // 빈객체 생성
			 summerBoardDTO.setBno(resultSet.getInt("bno"));
			 summerBoardDTO.setBtitle(resultSet.getString("btitle"));
			 summerBoardDTO.setBcontent(resultSet.getString("bcontent"));
			 summerBoardDTO.setBwriter(resultSet.getString("bwriter"));
			 summerBoardDTO.setBdate(resultSet.getDate("bdate"));
			// 데이터베이스에 있는 행을 객체에 넣기 완료
			 
			 System.out.println("--------------------------------------------------");
			 System.out.println("번 호 : " + summerBoardDTO.getBno());
			 System.out.println("제 목 : " + summerBoardDTO.getBtitle());
			 System.out.println("내 용 : " + summerBoardDTO.getBcontent());
			 System.out.println("작 성 자 : " + summerBoardDTO.getBwriter());
			 System.out.println("작 성 일 : " + summerBoardDTO.getBdate());
			}else { // 검색 결과가 없으면
				System.out.println("~ 조 회 하 신 게 시 물 이 존 재 하 지 않 습 니 다 ~");
			}// if종료
		}catch (SQLException e) {
			System.out.println("예외발생 : readOne() 메서드를 확인하세요");
			e.printStackTrace();
			
		}finally { // 항상 실행문
			resultSet.close();
			preparestatement.close();
			
		} // finally 종료
		
	} // readOne 메서드 종료

	public void modify(String title, Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용을 수정
		SummerBoardDTO summerBoardDTO = new  SummerBoardDTO();
		System.out.println("▽ 수 정 할 내 용 을 입 력 하 세 요 ▽");
		System.out.print("제목 : ");
		summerBoardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용: ");
		summerBoardDTO.setBcontent(inputLine.nextLine());
		
		try {
			String sql = "update board set btitle=? , bcontent = ?, bdate = sysdate where btitle = ?";
			preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, summerBoardDTO.getBtitle());
			preparestatement.setString(2, summerBoardDTO.getBcontent());
			preparestatement.setString(3, title);
			
			result = preparestatement.executeUpdate(); //쿼리문 실행 후 결과를 정수로 보냄
			
			if (result>0) {
				System.out.println(" * "+ result + "개의 게시물이 수정 되었습니다");
				connection.commit(); // 영구저장
			} else {
				System.out.println("~ 수 정 에 실 패 하 였 습 니 다 ~ ");
				connection.rollback();
			}// if종료
			
		} catch (SQLException e) {
			System.out.println("예외 발생 : modify() 메서드와 sql문을 확인하세요 ");
			e.printStackTrace();
		} finally {
			preparestatement.close();
		}// finally 종료
		} // modify 메서드 종료

	public void deleteOne(int selectBno) throws SQLException{
		// service에서 받은 게시물의 번호를 이용하여 데이터 삭제
		
		try {
			String sql = "delete from board where bno = ?";
			preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, selectBno);
			result = preparestatement.executeUpdate();
			
			if (result>0) {
				System.out.println(" * "+ result + "개의 게시물이 삭제 되었습니다");
				connection.commit();
			}else { 
				System.out.println("~ 게 시 물 삭 제 에 실 패 하 였 습 니 다 ~");
				connection.rollback();
				
			}// if 종료
			
			selectAll(); //  삭제 후 전체 리스트 보기
			
		} catch (SQLException e) {
			System.out.println("예외발생 : deleteOne() 메서드와 sql문을 확인하세요");
			e.printStackTrace();
			
		} finally {
			preparestatement.close();
		} // finally 종료
		
		
	} // deleteOne 메서드 종료

}//class 종료
