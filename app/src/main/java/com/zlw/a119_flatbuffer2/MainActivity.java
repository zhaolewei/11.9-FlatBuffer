package com.zlw.a119_flatbuffer2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zlw.a119_flatbuffer2.flatmodel.Student;
import com.zlw.a119_flatbuffer2.flatmodel.TestObj;
import com.zlw.utils.flatbuffer.FlatBufferBuilder;

import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startBuffer();


    }


    private void startBuffer() {
        FlatBufferBuilder builder = new FlatBufferBuilder();

        int id1 = builder.createString("zlw1"); //获取字符串的偏移量（指针）
        Log.i("zlw", "开始序列化");
//开始造人
        int studentID1 = Student.createStudent(builder, 1, id1);
        int studentID2 = Student.createStudent(builder, 2, builder.createString("zlw2"));  //构造一个学生
        int studentID3 = Student.createStudent(builder, 3, builder.createString("zlw3"));  //构造一个学生
//封装集合
        int[] list = {studentID1, studentID2, studentID3}; //封装类中的数据指针的集合（同json的datas）
        int listID = TestObj.createListVector(builder, list);//封装成封装类

        TestObj.startTestObj(builder);
        TestObj.addList(builder, listID);
        int rootID = TestObj.endTestObj(builder);
        TestObj.finishTestObjBuffer(builder, rootID);

        ByteBuffer data = builder.dataBuffer();
        Log.i("zlw", "序列化完成");

        //TODO：存文件/读文件
        //反序列化
        Log.i("zlw", "开始反序列化");

        TestObj obj = TestObj.getRootAsTestObj(data);
        for (int i = 0; i < obj.listLength(); i++) {
            Student s = obj.list(i);
            Log.i("zlw", "学生" + i + ":姓名：" + s.name());
            //TODO:构建List
        }
        Log.i("zlw", "反序列化完成");
    }
}
