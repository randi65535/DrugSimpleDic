package com.example.wsu.cs.drugsimpledic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//서버에서 리스트뷰를 뿌릴 화면
public class DrugListAcitivity extends AppCompatActivity {

    //화면을 불러올 때 바로 실행되는 메소드
    //초기화를 담당한다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //이전 액티비티에서 전달한 값을 전달 받는다.


        //그 값을 가지고 API에 접근해서 리스트를 가져온다


        //리스트를 가져온 것을 가지고 화면에 뿌린다.

    }

}

//package com.example.a405.myapplication;
//
//        import android.os.Handler;
//        import android.support.v7.app.AppCompatActivity;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import org.xmlpull.v1.XmlPullParser;
//        import org.xmlpull.v1.XmlPullParserException;
//        import org.xmlpull.v1.XmlPullParserFactory;
//
//        import java.io.BufferedInputStream;
//        import java.io.IOException;
//        import java.io.InputStream;
//        import java.net.HttpURLConnection;
//        import java.net.URL;
//        import java.net.URLEncoder;
//        import java.util.ArrayList;
//        import java.util.List;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    TextView urlTextView, dataTextView;
//    Button testBtn;
//
//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        dataTextView = findViewById(R.id.dataTv);
//        urlTextView = findViewById(R.id.UrlTv);
//
//        testBtn = findViewById(R.id.TestBtn);
//
//        testBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new ReadStreamThread().start();
//            }
//        });
//    }
//
//
//
//    /*
//     해당 클래스는 Button을 누르면 식약처 API를 읽는다.
//     */
//    class ReadStreamThread extends Thread{
//        Handler mHandler = new Handler();
//        @Override
//        public void run() {
//            StringBuilder urlBuilder = new StringBuilder();
//            HttpURLConnection urlConnection = null;
//
//            try {
//                urlBuilder.append("http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductItem");
//                urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=WJ2%2FN2GWi1hIWxA4Bm4oxDk8Z3ADkAiKWG0RWs4LGZKvnDYcur09VRnBWWpRYhK9j33%2BNsO7MtfwrKgegpfoOg%3D%3D"); /*Service Key*/
//                urlBuilder.append("&" + URLEncoder.encode("item_name","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*품목명*/
//                urlBuilder.append("&" + URLEncoder.encode("entp_name","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*업체명*/
//                urlBuilder.append("&" + URLEncoder.encode("CLASS_NO","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*분류*/
//                urlBuilder.append("&" + URLEncoder.encode("MATERIAL_NAME","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*원료성분*/
//                urlBuilder.append("&" + URLEncoder.encode("UD_DOC_ID","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*용법용량*/
//                urlBuilder.append("&" + URLEncoder.encode("NB_DOC_ID","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*주의사항*/
//                urlBuilder.append("&" + URLEncoder.encode("EE_DOC_DATA","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*효능효과*/
//                urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
//                urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과수*/
//                URL url = new URL(urlBuilder.toString());
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//
//                if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
//                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//                    useHandler(in);
//                    urlConnection.disconnect();
//                }
//
//            }catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                urlConnection.disconnect();
//                urlBuilder.setLength(0);
//            }
//        }
//
//        /*
//        설명 : 해당 메소드는 Thread - Handler pattern을 이용하는 Method이다.
//        */
//        public void useHandler(InputStream in){
//            /*
//            필요에 의해 값을 받아오는 부분
//            핸들러를 사용하기 때문에 항상 값이 할당되어있어야 한다.
//             */
//            final String result = readItem(in);
//
//            mHandler.post(new Runnable() {
//                @Override
//                public void run() {
//
//                    /*
//                    위에서 받아온 값들로 Ui를 변경하는 곳
//                     */
//                    urlTextView.setText(result);
//                }
//            });
//        }
//
//        //해당 메서드는 Stream에서 설정하는 곳이다.
//        public String readItem(InputStream in){
//            try {
//
//                XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
//                XmlPullParser parser = pullParserFactory.newPullParser();
//                parser.setInput(in, null);
//                return parseXml(parser);
//
//            } catch (Exception e) {
//                return "실패";
//            }
//        }
//
//        /*********************************************************************************
//         매우 중요한 부분이다 지우지 말것!!
//         해당 메서드는 xml을 Parsing하는 알고리즘을 실행하는 메서드이다.
//         **********************************************************************************/
//
//        private String parseXml(XmlPullParser parser) throws XmlPullParserException,IOException{
//
//            ArrayList<String> itemList;
//            String tmp = "";
//
//            /* 사용 예시
//            <items> START_DOCUMENT 시점     while1
//                <item>                      while2
//                    <name></name>           while3
//                    <price></price>         while4
//                <item> item의 End Tag       while5 << 개체 생성 시점
//                <item>                      while6
//                    <name></name>           while7
//                    <price></price>         while8
//                <item>                      while9
//            </items>  END_DOCUMENT 시점     while10
//             */
//
//            String a;
//            String PN = "";
//            String EN= "";
//            String MN= "";
//
//            int eventType = parser.getEventType();
//            List<Product> pList = new ArrayList<>();
//
//
//
//            while (eventType != XmlPullParser.END_DOCUMENT){
//                String name;
//                switch (eventType){
//                    case XmlPullParser.START_DOCUMENT:
//                        //문서가 시작할 때
//                        break;
//                    case XmlPullParser.START_TAG:
//                        /*
//                        해당 부분은 필요한 개체를 가져오는 곳이다.
//                        예를 들어 <PRDUCT>칸쵸</PRDUCT>가 있으면
//                        parser.nextText()로 값을 받을 수 있다.
//                         */
//                        name = parser.getName();
//
//                        //테스트코드
//
//                        if (name.equalsIgnoreCase("ENTRPS")){
////                            country = new Country();
////                            country.id=parser.getAttributeValue(null,"id");
////                            tmp += parser.nextText() + "\n";
//                            EN = parser.nextText();
//                        }
//
//                        if (name.equalsIgnoreCase("PRDUCT")){
////                            country = new Country();
////                            country.id=parser.getAttributeValue(null,"id");
//                            //tmp += parser.nextText() + "\n";
//                            PN = parser.nextText();
//                        }
//
//                        if(name.equalsIgnoreCase("MTRAL_CODE")){
//                            //tmp += parser.nextText() + "\n";
//                        }
//
//                        if(name.equalsIgnoreCase("MTRAL_NM")){
//                            //tmp += parser.nextText() + "\n";
//                            MN = parser.nextText();
//                        }
//
//
//
//                        /// .. 추가 개체가 있으면 여기에 넣을 것
//
////                        else if (country != null){
////                            if (name.equals("name")){
////                                country.name = parser.nextText();
////                            } else if (name.equals("capital")){
////                                country.capital = parser.nextText();
////                            }
////                        }
//                        break;
//                    case XmlPullParser.END_TAG:
////                        혹여나 개체를 생성할 일이 있을 땐 여기서 하도록 하자.
////                        name = parser.getName();
////                        if (name.equalsIgnoreCase("country") && country != null){
////                            countries.add(country);
////                        }
//
//                        name = parser.getName();
//                        if(name.equalsIgnoreCase("ITEM")) {
//                            //list.add(new Product(a,b,c,d ...s);
//                            pList.add(new Product(PN, EN, MN));
//                        }
//
//                    case XmlPullParser.END_DOCUMENT:
//                        //문서가 끝났을 때
//                        break;
//                }
//
//                eventType = parser.next();
//            }
//
//            for(int i = 0; i < pList.size(); i++){
//                tmp += pList.get(i).ProName;
//            }
//            return tmp;
//        }
//        /*********************************************************************************
//         매우 중요한 부분이다 지우지 말것!!
//         **********************************************************************************/
//    }
//}