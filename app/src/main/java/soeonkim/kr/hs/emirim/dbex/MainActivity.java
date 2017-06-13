package soeonkim.kr.hs.emirim.dbex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //내부 클래스 생성(Main액티비티에 있는 멤버 필드 사용 가능 = > 코드가 쉬워짐
    class MyDBHelper extends SQLiteOpenHelper{
        //idolDB라는 이름의 데이터 베이스가 생성된다.
        public MyDBHelper(Context context) {
            super(context, "idolDB", null , 1);
        }
        // idolTable이라는 이름의 테이블 생성
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table idolTable(idolName text not null primary key, idolCount integer)";
            db.execSQL(sql);
        }
        // 이미 idolTable이 존재한다면 기존의 테이블을 삭제하고 새로 테이블을 만들 때 호출 (초기화버튼 눌렸을때)
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exist idolTable";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
